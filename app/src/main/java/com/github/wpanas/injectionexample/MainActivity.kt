package com.github.wpanas.injectionexample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.github.wpanas.injectionexample.coffee.CoffeeService
import com.github.wpanas.injectionexample.coffee.CoffeeTwoService
import com.github.wpanas.injectionexample.order.OrderService
import com.github.wpanas.injectionexample.order.OrderServiceTwo
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    //Классы которые инжектированы в MainActivity
    @Inject
    lateinit var coffeeService: CoffeeService

    @Inject
    lateinit var orderService: OrderService

    @Inject
    lateinit var orderServiceTwo: OrderServiceTwo

    @Inject
    lateinit var coffeeTwoService: CoffeeTwoService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //Строка которая возвращает данные из orderService из метода askForOrder
        // ask_for_order_text.text = orderService.askForOrder()

        //Данный код экспериментальный он возвращает введенное число в денежном формате
        val num = 5000542.44
        val usd: Currency = Currency.getInstance("RUB")
        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.currency = usd
        val currency = format.format(num)
        ask_for_order_text.text = currency

        //Строка которая возвращает данные из coffeeTwoService из метода prepareCoffeeTwo
        //ask_for_order_text1.text = coffeeTwoService.prepareCoffeeTwo()

        fab.setOnClickListener { view ->
            Snackbar.make(view, coffeeTwoService.prepareCoffeeTwo(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    /*----------------------------------------------------------------------------------------*/
    //Дальнейший код относиться только к Fab кнопке.
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        // Раздуть меню; это добавляет элементы в панель действий, если она присутствует.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // Элемент панели действий ручки щелкает здесь. Панель действий будет
        // автоматически обрабатывать щелчки по кнопке Home / Up, так долго
        // как вы указываете родительскую активность в AndroidManifest.XML.
        when (item.itemId) {
            R.id.action_settings -> {
                title = item.title
                return true
            }
            R.id.dex -> {
                title = item.title
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

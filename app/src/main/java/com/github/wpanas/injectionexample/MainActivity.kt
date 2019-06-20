package com.github.wpanas.injectionexample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.github.wpanas.injectionexample.coffee.CoffeeService
import com.github.wpanas.injectionexample.order.OrderService
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var coffeeService: CoffeeService

    @Inject
    lateinit var orderService: OrderService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        findViewById<TextView>(R.id.ask_for_order_text)?.text = orderService.askForOrder()

        fab.setOnClickListener { view ->
            Snackbar.make(view, coffeeService.prepareCoffee(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

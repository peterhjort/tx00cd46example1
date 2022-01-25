package com.example.tx00cd46example1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var nappi: Button
    private lateinit var viesti: TextView
    private val greeter = Greeter("Hallo", "Terve", "Ciao", "Hi there")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nappi = findViewById(R.id.button)
        viesti = findViewById(R.id.textView)

        nappi.setOnClickListener {
            viesti.text = greeter.giveGreeting()
        }
        nappi.text = greeter.giveGreeting()
    }
}

class Greeter(vararg private val greetings: String) {
    init {
        require(greetings.isNotEmpty())
    }
    private var current = 0
    fun giveGreeting(): String {
        val greeting = greetings[ current ]
        current = (current + 1) % greetings.size
        return greeting
    }
}
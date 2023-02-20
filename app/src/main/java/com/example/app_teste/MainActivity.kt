package com.example.app_teste

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var helloTextView: TextView
    private lateinit var nameEditText: EditText
    private lateinit var randomNumberTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.apply {
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.amarelo)))
            setTitle("Meu App teste")
        }

        helloTextView = findViewById(R.id.helloTextView)
        helloTextView.text = "Olá, mundo!"

        nameEditText = findViewById(R.id.nameEditText)

        val myButton = findViewById<Button>(R.id.myButton)
        myButton.setOnClickListener {
            val name = nameEditText.text.toString()
            helloTextView.text = "Olá, $name!"
        }

        randomNumberTextView = findViewById(R.id.randomNumberTextView)


        val randomButton = findViewById<Button>(R.id.randomButton)
        randomButton.setOnClickListener {
            val randomNum = (1..10).random()
            randomNumberTextView.text = "Número aleatório: $randomNum"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.change_text -> {
                helloTextView.text = "Texto alterado pelo usuário"
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
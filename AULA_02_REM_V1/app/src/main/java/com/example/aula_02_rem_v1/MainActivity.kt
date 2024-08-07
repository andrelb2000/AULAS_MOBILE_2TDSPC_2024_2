package com.example.aula_02_rem_v1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private  var xModelo: Int = 0
    private  var yModelo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val botaoUp: Button = findViewById(R.id.ID1_XUp_button)
        val viewX: TextView = findViewById(R.id.ID1_XMod_textView)
        botaoUp.setOnClickListener {
            xModelo = xModelo + 1
            viewX.text = "Valor X ${xModelo}"
        }
    }
}
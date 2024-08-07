package com.example.aula2_ex1_pronto

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var x: Int = 0
    var y: Int = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botaoXP: Button = findViewById(R.id.ID1_XP_Button)
        val botaoXM: Button = findViewById(R.id.ID1_XP_Button)
        val xText: TextView = findViewById(R.id.ID1_X_textView)
        // val yText: TextView
        //val resEq1: TextView
        //val resEq2: TextView
        botaoXM.setOnClickListener{
            x++
            xText.text = x.toString()
        }


    }
}
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
    private  var viewX: TextView? = null
    private  var eq1:   TextView? = null

    private fun inicializar(){
        val botaoUp: Button = findViewById(R.id.ID1_XUp_button)
        viewX = findViewById(R.id.ID1_XMod_textView)
        eq1   = findViewById(R.id.ID1_EQ1_textView)

        botaoUp.setOnClickListener {
            xModelo = xModelo + 1
            viewX?.text = "Valor X ${xModelo}"

            var eq1Temp: Int = 0
            eq1Temp = 2* xModelo + 3*yModelo
            eq1?.text = eq1Temp.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        inicializar()
    }
}
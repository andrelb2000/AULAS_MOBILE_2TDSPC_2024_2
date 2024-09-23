package com.example.aulaciclovida

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var nrMortes:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        println("OnCreate")
    }

    override fun onStop() {
        super.onStop()
        nrMortes++
        println("Saindo da Aplicação - Morte $nrMortes")
        // Iniciar novamente a mesma Activity após onDestroy()
        println("On Stop Disparado startActivity antes")
        val handler = android.os.Handler(mainLooper)
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 100)  // Pequeno atraso de 100 milissegundos
        println("On StopDisparado startActivity")

    }

    override fun onDestroy() {
        super.onDestroy()
        nrMortes++
        println("Saindo da Aplicação - Morte $nrMortes")
        // Iniciar novamente a mesma Activity após onDestroy()
        println("Disparado startActivity antes")
        val handler = android.os.Handler(mainLooper)
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 100)  // Pequeno atraso de 100 milissegundos
        println("Disparado startActivity")
    }

    override fun onRestart() {
        super.onRestart()
        println("on Restart")
    }
}
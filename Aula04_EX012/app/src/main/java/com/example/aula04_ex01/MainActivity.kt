package com.example.aula04_ex01

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // 1 - Declarar componentes visuais
    private var insereEditText:EditText? = null
    private var somaTextView:TextView?   = null
    private var maiorTextView:TextView?  = null
    private var menorTextView:TextView?  = null
    private var botaoInsere:Button? = null
    private var botaoLimpa:Button? = null
    // Preparacao para listas
    // 1 - O listView
    private var listaViewInsercao:ListView? = null
    // 2 - A LISTA de dados
    private var listainsercao:ArrayList<String>? =null
    // 3 - ADAPTADOR
    private var adaptador:ArrayAdapter<String>? = null



    // 2 - Declarar variaveis de logica de negocios
    private var soma:Float = 0.0F
    private var menor:Float = 10000000.0F
    private var maior:Float = 0.0F
    // Inicializar componentes e acoes
    private fun inicializarComponentes(){
        insereEditText = findViewById(R.id.ID1_INSEREeditTextNumberDecimal)
        somaTextView   = findViewById(R.id.ID1_SOMA_textView)
        maiorTextView  = findViewById(R.id.ID1_MAIORtextView2)
        menorTextView  = findViewById(R.id.ID1_MENORtextView3)
        botaoInsere    = findViewById(R.id.ID1_INSERE_button)
        botaoLimpa     = findViewById(R.id.ID1_CLEAR_button2)

        // 1 - Obter a LISTVIEW do Layout
        listaViewInsercao = findViewById(R.id.ID1_LISTA_ListVIEW)
        // 2 - Criar a lista "Real" dos dados
        listainsercao = ArrayList<String>()
        // 3 - Criar o adaptador, passando a lista real e conectando na visual
        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, listainsercao!!)
        listaViewInsercao?.adapter = adaptador

    }
    private fun inicializarAcoes(){
        botaoInsere?.setOnClickListener {
            logicaInsercao()
        }
        botaoLimpa?.setOnClickListener {
            listainsercao?.clear()
            adaptador?.clear()
            adaptador?.notifyDataSetChanged()
        }
    }
    // Metodos de logica de negocios
    private fun logicaInsercao(){
        var tempInserido:Float = insereEditText?.text.toString().toFloat()
        if(tempInserido > maior){
            maior = tempInserido
        }
        if(tempInserido < menor){
            menor = tempInserido
        }
        soma = soma + tempInserido
        somaTextView?.text = soma.toString()
        maiorTextView?.text = maior.toString()
        menorTextView?.text = menor.toString()

        listainsercao?.add("--> R$ ${tempInserido}")
        adaptador?.notifyDataSetChanged()
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
        inicializarComponentes()
        inicializarAcoes()
    }
}
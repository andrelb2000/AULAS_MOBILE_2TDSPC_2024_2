package com.example.applistadetalheedicao_ex1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
class RegistroFragment : Fragment() {
    private var listener: OnFragmentInteractionListener? = null
    private var nomePessoa: EditText? = null
    private var insereButton: Button? = null
    interface OnFragmentInteractionListener {
        fun envioObjeto(objeto: Pessoa)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_registro, container, false)
        insereButton = view.findViewById(R.id.IDF1_button)
        nomePessoa   = view.findViewById(R.id.IDF1_editTextText)
        insereButton?.setOnClickListener {
            //// Criar um NOVO objeto da classe pessoa
            var pessoa:Pessoa = Pessoa()
            pessoa?.setNomePessoa(nomePessoa?.text.toString())
            listener?.envioObjeto(pessoa)
        }
        return view
    }
}
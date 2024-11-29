package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_Result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        var classificacao: String? = null

        if (result <= 18.5f) {
            classificacao = "MAGREZA"
        }
        if (result > 18.5f && result <= 24.9f) {
            classificacao = "NORMAL"
        }
        if (result > 25f && result <= 29.9f) {
            classificacao = "Sobrepeso"
        }
        if (result > 30f && result <= 34.9f) {
            classificacao = "Obesidade grau I"
        }
        if (result > 35f && result <= 39.9f) {
            classificacao = "Obesidade grau II"
        }
        if (result >= 40f) {
            classificacao = "Obesidade grau III"
        }
        tvClassificacao.text = classificacao
    }
}

package com.example.vizual1
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var screen: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        screen = findViewById(R.id.tvDisplay)
        setupButton(R.id.btn0, "0")
        setupButton(R.id.btn1, "1")
        setupButton(R.id.btn2, "2")
        setupButton(R.id.btn3, "3")
        setupButton(R.id.btn4, "4")
        setupButton(R.id.btn5, "5")
        setupButton(R.id.btn6, "6")
        setupButton(R.id.btn7, "7")
        setupButton(R.id.btn8, "8")
        setupButton(R.id.btn9, "9")
        setupButton(R.id.btnAdd, "+")
        setupButton(R.id.btnSubtract, "-")
        setupButton(R.id.btnMultiply, "*")
        setupButton(R.id.btnDivide, "/")
        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            calculate()
        }
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            screen.text = "0"
        }
    }

    fun setupButton(buttonId: Int, new: String) {
        findViewById<Button>(buttonId).setOnClickListener {
            val now = screen.text.toString()
            if (now == "0" || now == "Ошибка") {
                screen.text = new
            } else {
                screen.text = now + new
            }
        }
    }

    fun calculate() {
        val text = screen.text.toString()
        val operator = when {
            text.contains("+") -> "+"
            text.contains("-") -> "-"
            text.contains("*") -> "*"
            text.contains("/") -> "/"
            else -> return
        }

        val parts = text.split(operator)
        if (parts.size != 2) {
            screen.text = "Ошибка"
            return
        }

        try {
            val num1 = parts[0].toDouble()
            val num2 = parts[1].toDouble()
            val result = when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN
                else -> Double.NaN
            }

            screen.text = if (result.isNaN()) "Ошибка" else
                if (result % 1 == 0.0) result.toInt().toString() else result.toString()
        } catch (e: Exception) {
            screen.text = "Ошибка"
        }
    }
}
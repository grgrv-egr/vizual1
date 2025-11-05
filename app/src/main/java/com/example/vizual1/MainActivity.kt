package com.example.vizual1
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.graphics.Color

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val screen = findViewById<TextView>(R.id.tvDisplay)

        findViewById<Button>(R.id.btn0).setOnClickListener {
            if (screen.text == "0" || screen.text == "Ошибка") {
                screen.setText("0")
            } else {
                screen.setText(screen.text.toString() + "0")
            }
            findViewById<Button>(R.id.btn0).setBackgroundColor(Color.rgb(255,0,0))
            findViewById<Button>(R.id.btn0).postDelayed({
                findViewById<Button>(R.id.btn0).setBackgroundColor(Color.rgb(66,170,255))
            }, 150)
        }

        findViewById<Button>(R.id.btn1).setOnClickListener {
            if (screen.text == "0" || screen.text == "Ошибка") {
                screen.setText("1")
            } else {
                screen.setText(screen.text.toString() + "1")
            }
        }

        findViewById<Button>(R.id.btn2).setOnClickListener {
            if (screen.text == "0" || screen.text == "Ошибка") {
                screen.setText("2")
            } else {
                screen.setText(screen.text.toString() + "2")
            }
        }

        findViewById<Button>(R.id.btn3).setOnClickListener {
            if (screen.text == "0" || screen.text == "Ошибка") {
                screen.setText("3")
            } else {
                screen.setText(screen.text.toString() + "3")
            }
        }

        findViewById<Button>(R.id.btn4).setOnClickListener {
            if (screen.text == "0" || screen.text == "Ошибка") {
                screen.setText("4")
            } else {
                screen.setText(screen.text.toString() + "4")
            }
        }

        findViewById<Button>(R.id.btn5).setOnClickListener {
            if (screen.text == "0" || screen.text == "Ошибка") {
                screen.setText("5")
            } else {
                screen.setText(screen.text.toString() + "5")
            }
        }

        findViewById<Button>(R.id.btn6).setOnClickListener {
            if (screen.text == "0" || screen.text == "Ошибка") {
                screen.setText("6")
            } else {
                screen.setText(screen.text.toString() + "6")
            }
        }

        findViewById<Button>(R.id.btn7).setOnClickListener {
            if (screen.text == "0" || screen.text == "Ошибка") {
                screen.setText("7")
            } else {
                screen.setText(screen.text.toString() + "7")
            }
        }

        findViewById<Button>(R.id.btn8).setOnClickListener {
            if (screen.text == "0" || screen.text == "Ошибка") {
                screen.setText("8")
            } else {
                screen.setText(screen.text.toString() + "8")
            }
        }

        findViewById<Button>(R.id.btn9).setOnClickListener {
            if (screen.text == "0" || screen.text == "Ошибка") {
                screen.setText("9")
            } else {
                screen.setText(screen.text.toString() + "9")
            }
        }

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            if (screen.text != "0" && screen.text != "Ошибка") {
                screen.setText(screen.text.toString() + "+")
            }
        }

        findViewById<Button>(R.id.btnSubtract).setOnClickListener {
            if (screen.text != "0" && screen.text != "Ошибка") {
                screen.setText(screen.text.toString() + "-")
            }
        }

        findViewById<Button>(R.id.btnMultiply).setOnClickListener {
            if (screen.text != "0" && screen.text != "Ошибка") {
                screen.setText(screen.text.toString() + "*")
            }
        }

        findViewById<Button>(R.id.btnDivide).setOnClickListener {
            if (screen.text != "0" && screen.text != "Ошибка") {
                screen.setText(screen.text.toString() + "/")
            }
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            screen.setText("0")
        }

        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            val text = screen.text.toString()
            val operator = when {
                text.contains("+") -> "+"
                text.contains("-") -> "-"
                text.contains("*") -> "*"
                text.contains("/") -> "/"
                else -> ""
            }

            if (operator.isNotEmpty()) {
                val parts = text.split(operator)
                if (parts.size == 2) {
                    try {
                        val num1 = parts[0].toDouble()
                        val num2 = parts[1].toDouble()
                        val result = when (operator) {
                            "+" -> num1 + num2
                            "-" -> num1 - num2
                            "*" -> num1 * num2
                            "/" -> if (num2 != 0.0) num1 / num2 else null
                            else -> null
                        }

                        screen.setText(if (result == null) "Ошибка" else
                            if (result % 1 == 0.0) result.toInt().toString() else result.toString())
                    } catch (e: Exception) {
                        screen.setText("Ошибка")
                    }
                } else {
                    screen.setText("Ошибка")
                }
            }
        }
    }
}
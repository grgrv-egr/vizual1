package com.example.vizual1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = findViewById<Button>(R.id.bCalculator)
        btn1.setOnClickListener {
            startActivity(android.content.Intent(this, CalculatorActivity::class.java))
        }
        val btn2 = findViewById<Button>(R.id.bMediaPlayer)
        btn2.setOnClickListener {
            startActivity(android.content.Intent(this, MediaPlayerActivity::class.java))
        }
    }
}

package com.example.lab_week_01

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameInput = findViewById<TextInputEditText>(R.id.name_input)
        val studentNumberInput = findViewById<TextInputEditText>(R.id.student_number_input)
        val btnSubmit = findViewById<Button>(R.id.name_submit)

        btnSubmit.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val studentNumber = studentNumberInput.text.toString().trim()

            when {
                name.isEmpty() -> {
                    Snackbar.make(it, getString(R.string.name_empty), Snackbar.LENGTH_SHORT).show()
                }
                studentNumber.length != 11 -> {
                    Snackbar.make(it, getString(R.string.student_number_error), Snackbar.LENGTH_SHORT).show()
                }
                else -> {
                    val nameText = getString(R.string.name_greet, name)
                    val studentText = getString(R.string.student_number_greet, studentNumber)
                    nameDisplay.text = getString(R.string.full_display, nameText, studentText)
                }
            }
        }
    }
}

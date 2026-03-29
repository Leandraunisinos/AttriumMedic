package com.example.attriummedic

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.attriummedic.mock.MedicosMock
import com.example.attriummedic.model.MedicosModel

class MedicosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicos)

        val container = findViewById<LinearLayout>(R.id.containerDoctors)

        val doctors = DoctorMock.getDoctors()

        doctors.forEach { doctor ->

            val card = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(30, 30, 30, 30)
                setBackgroundColor(0xFFFFFFFF.toInt())
                elevation = 8f
            }

            val name = TextView(this).apply {
                text = doctor.name
                textSize = 18f
            }

            val specialty = TextView(this).apply {
                text = doctor.specialty
            }

            val description = TextView(this).apply {
                text = doctor.description
            }

            val button = Button(this).apply {
                text = "Agendar via WhatsApp"
            }

            card.addView(name)
            card.addView(specialty)
            card.addView(description)
            card.addView(button)

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 0, 0, 30)

            card.layoutParams = params

            container.addView(card)
        }
    }
}
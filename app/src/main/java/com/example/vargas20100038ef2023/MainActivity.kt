package com.example.vargas20100038ef2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var idEdtiText: EditText
    private lateinit var descripEditText: EditText
    private lateinit var cantiEditText: EditText
    private lateinit var precioEditText: EditText

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        idEdtiText = findViewById(R.id.edtId)
        descripEditText = findViewById(R.id.edtdescri)
        cantiEditText = findViewById(R.id.edtcanti)
        precioEditText = findViewById(R.id.edtprecio)

        db = FirebaseFirestore.getInstance()

        val RegistrarButton = findViewById<Button>(R.id.btnRegi)
        RegistrarButton.setOnClickListener {
            guardarProducto()
        }
    }

    private fun guardarProducto() {
        val id = idEdtiText.text.toString()
        val descripcion = descripEditText.text.toString()
        val cantidad = cantiEditText.text.toString()
        val precio = precioEditText.text.toString()

        val metodoPago = hashMapOf(
            "id" to id,
            "descripcion" to descripcion,
            "cantidad" to cantidad,
            "precio" to precio,
        )

        db.collection("Productos")
            .add(metodoPago)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(this, "Producto guardado exitosamente" , Toast.LENGTH_SHORT).show()

            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al guardar el producto", Toast.LENGTH_SHORT).show()
                Log.w("AgregarProducto", "Error al agregar el producto", e)
            }

        limpiarEditTexts()
    }

    private fun limpiarEditTexts() {
        findViewById<EditText>(R.id.edtId).text.clear()
        findViewById<EditText>(R.id.edtdescri).text.clear()
        findViewById<EditText>(R.id.edtcanti).text.clear()
        findViewById<EditText>(R.id.edtprecio).text.clear()
    }

}
package com.example.myactividad.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.myactividad.MainActivity
import com.example.myactividad.R
import com.example.myactividad.model.User

class FormActivity : AppCompatActivity() {

    var usuario = User()
    var registro = true
    lateinit var editTextUsuario: EditText
    lateinit var editTextPassword: EditText
    lateinit var editTexNombre: EditText
    lateinit var editTextApellido: EditText
    lateinit var buttonCancelar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        editTextUsuario = findViewById<EditText>(R.id.editTextUsuario)
        editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        editTexNombre = findViewById<EditText>(R.id.editTextNombre)
        editTextApellido = findViewById<EditText>(R.id.editTextApellido)
        buttonCancelar = findViewById<Button>(R.id.buttonCancelar)

        registro = intent.getBooleanExtra("registro", true)

        if (!registro) {
            var bundle: Bundle? = intent.getBundleExtra("usuario")
            usuario.setBundle(bundle!!)

            editTextUsuario.setText(usuario.usuario)
            editTextPassword.setText(usuario.password)
            editTexNombre.setText(usuario.nombre)
            editTextApellido.setText(usuario.apellido)

            editTextUsuario.isEnabled = false
            editTextPassword.isEnabled = false
            editTexNombre.isEnabled = false
            editTextApellido.isEnabled = false

            buttonCancelar.visibility = View.INVISIBLE

        }
    }

    fun onAceptar(view: View) {

        if(registro) {
            usuario.usuario = editTextUsuario.text.toString()
            usuario.password = editTextPassword.text.toString()
            usuario.nombre = editTexNombre.text.toString()
            usuario.apellido = editTextApellido.text.toString()

            var resultIntent = Intent(this, MainActivity::class.java)

            resultIntent.putExtra("usuario", usuario.getBundle())
            setResult(Activity.RESULT_OK, resultIntent)
        }
        finish()
    }

    fun onCancelar(view: View) {
        finish()
    }
}

package com.example.myactividad.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.myactividad.MainActivity
import com.example.myactividad.R
import com.example.myactividad.model.User

class LoginDialogs : DialogFragment() {
    lateinit var usuario: User
    lateinit var mainActivity: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var viewDialog = inflater.inflate(R.layout.login_dialog, container, false)


        var bottomLogin2 = viewDialog.findViewById<Button>(R.id.buttonLogin)
        bottomLogin2.setOnClickListener { view -> login(view) }
        return viewDialog
    }

    fun login(view: View) {
        var et_user = dialog!!.findViewById<EditText>(R.id.et_username)
        var et_password = dialog!!.findViewById<EditText>(R.id.et_password)
        var user = et_user.text.toString()
        var pass = et_password.text.toString()

        if (user.equals(usuario.usuario) && pass.equals(usuario.password, true)) {
            mainActivity.activarBotonInformacion()
            dismiss()
        } else {
            Toast.makeText(this.activity, "Usuario/Contraseña incorrecta", Toast.LENGTH_LONG).show()
        }
    }
}
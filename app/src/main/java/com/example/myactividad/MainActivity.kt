package com.example.myactividad

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.myactividad.activities.FormActivity
import com.example.myactividad.dialogs.LoginDialogs
import com.example.myactividad.model.User

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE_ACTIVITY_FORM = 10
    lateinit var buttonLogin: Button
    lateinit var buttonInformacion: Button
    var usuario = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonInformacion = findViewById<Button>(R.id.buttonInformacion)
        buttonLogin = findViewById<Button>(R.id.buttonLogin)
        buttonInformacion.isEnabled = false
    }

    fun onRegistro(view: View) {
        var intentRegistro = Intent(this, FormActivity::class.java)
        intentRegistro.putExtra("registro", true)
        startActivityForResult(intentRegistro, REQUEST_CODE_ACTIVITY_FORM)
    }

    fun onLogin(view: View) {

        var loginDialog = LoginDialogs()
        loginDialog.usuario = usuario
        loginDialog.mainActivity = this
        loginDialog.show(supportFragmentManager, "loginDialog_Tag")
    }

    fun onInformacion(view: View) {

        var intentInformacion = Intent(this, FormActivity::class.java)
        intentInformacion.putExtra("registro", false)
        intentInformacion.putExtra("usuario", usuario.getBundle())
        startActivity(intentInformacion)

    }

    fun activarBotonInformacion() {

        buttonInformacion.isEnabled = true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CODE_ACTIVITY_FORM) {
                usuario = User()
                var bundleData = data!!.getBundleExtra("usuario")

                usuario.setBundle(bundleData!!)
                buttonLogin.isEnabled = true


            }
        }

    }
}

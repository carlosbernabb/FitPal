package com.fitpal.app

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.fitpal.app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFooterLink()
        setupLoginButton()
    }

    private fun setupLoginButton() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()

            when {
                email.isEmpty() -> {
                    binding.tilEmail.error = "Ingresa tu correo"
                }
                password.isEmpty() -> {
                    binding.tilEmail.error = null
                    binding.tilPassword.error = "Ingresa tu contraseña"
                }
                else -> {
                    binding.tilEmail.error = null
                    binding.tilPassword.error = null
                    // TODO: implement real authentication
                    Toast.makeText(this, "Iniciando sesión…", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        }
    }

    private fun setupFooterLink() {
        val fullText = "¿No tienes una cuenta? Regístrate"
        val spannable = SpannableString(fullText)
        val startIndex = fullText.indexOf("Regístrate")
        val red = ContextCompat.getColor(this, R.color.primary)

        spannable.setSpan(
            ForegroundColorSpan(red),
            startIndex, fullText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }
            override fun updateDrawState(ds: android.text.TextPaint) {
                ds.color = red
                ds.isUnderlineText = false
            }
        }, startIndex, fullText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.tvRegisterLink.text = spannable
        binding.tvRegisterLink.movementMethod = LinkMovementMethod.getInstance()
    }
}

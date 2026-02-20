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
import com.fitpal.app.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        setupFooterLink()
        setupRegisterButton()
    }

    private fun setupRegisterButton() {
        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()
            val confirm = binding.etConfirmPassword.text.toString()

            binding.tilName.error = null
            binding.tilEmail.error = null
            binding.tilPassword.error = null
            binding.tilConfirmPassword.error = null

            when {
                name.isEmpty() -> binding.tilName.error = "Ingresa tu nombre"
                email.isEmpty() -> binding.tilEmail.error = "Ingresa tu correo"
                password.length < 6 -> binding.tilPassword.error = "Mínimo 6 caracteres"
                password != confirm -> binding.tilConfirmPassword.error = "Las contraseñas no coinciden"
                else -> {
                    // TODO: implement real registration
                    Toast.makeText(this, "Cuenta creada correctamente", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun setupFooterLink() {
        val fullText = "¿Ya tienes una cuenta? Inicia sesión"
        val spannable = SpannableString(fullText)
        val startIndex = fullText.indexOf("Inicia sesión")
        val red = ContextCompat.getColor(this, R.color.primary)

        spannable.setSpan(
            ForegroundColorSpan(red),
            startIndex, fullText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) { finish() }
            override fun updateDrawState(ds: android.text.TextPaint) {
                ds.color = red
                ds.isUnderlineText = false
            }
        }, startIndex, fullText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.tvLoginLink.text = spannable
        binding.tvLoginLink.movementMethod = LinkMovementMethod.getInstance()
        binding.tvLoginLink.highlightColor = android.graphics.Color.TRANSPARENT
    }
}

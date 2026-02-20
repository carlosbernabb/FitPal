package com.fitpal.app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.fitpal.app.databinding.ActivitySplashBinding

/**
 * SplashActivity — FitPal entry screen.
 *
 * Displays the logo, tagline, and version info with fade-in animations.
 * After [SPLASH_DURATION_MS] it navigates to MainActivity.
 */
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    companion object {
        /** Total time the splash is visible before navigating (ms). */
        private const val SPLASH_DURATION_MS = 2_500L

        /** Individual element animation duration (ms). */
        private const val ANIM_DURATION_MS = 600L
    }

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Edge-to-edge, hide status/nav bars
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        val insetsController = WindowInsetsControllerCompat(window, window.decorView)
        insetsController.hide(WindowInsetsCompat.Type.systemBars())
        insetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startAnimations()
    }

    // ─── Animations ────────────────────────────────────────────────────────────

    private fun startAnimations() {
        // 1. Glow fades in first (behind everything)
        fadeIn(binding.ivGlow, delay = 0L, duration = 800L)

        // 2. Logo row
        fadeInUp(binding.llLogoRow, delay = 200L)

        // 3. Tagline
        fadeInUp(binding.tvTagline, delay = 400L)

        // 4. Version label at the bottom
        fadeIn(binding.tvVersion, delay = 600L)

        // 5. Navigate after total duration
        binding.root.postDelayed({ navigateToMain() }, SPLASH_DURATION_MS)
    }

    private fun fadeIn(view: View, delay: Long, duration: Long = ANIM_DURATION_MS) {
        view.alpha = 0f
        view.animate()
            .alpha(1f)
            .setDuration(duration)
            .setStartDelay(delay)
            .start()
    }

    private fun fadeInUp(view: View, delay: Long) {
        view.alpha = 0f
        view.translationY = 24f   // start 24px below final position
        view.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(ANIM_DURATION_MS)
            .setStartDelay(delay)
            .start()
    }

    // ─── Navigation ────────────────────────────────────────────────────────────

    private fun navigateToMain() {
        // Replace MainActivity::class.java with your actual next screen
        startActivity(Intent(this, LoginActivity::class.java))
        // Crossfade transition
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}

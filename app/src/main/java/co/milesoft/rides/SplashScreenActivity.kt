package co.milesoft.rides

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import co.milesoft.rides.misc.toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar.let { it?.hide() }
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            startSignInActivity()
        },3000)
    }

    private fun startSignInActivity() {
        val i = Intent(this,SignInActivity::class.java)
        startActivity(i)
        finish()
    }


}
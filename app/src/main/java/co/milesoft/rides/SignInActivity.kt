package co.milesoft.rides

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.milesoft.rides.misc.toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult

class SignInActivity : AppCompatActivity() {
    private val signInLauncher = registerForActivityResult(FirebaseAuthUIActivityResultContract()){
        onSignInResult(it)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }

    override fun onResume() {
        super.onResume()
        launchSignIn()
    }
    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK){
            startMainActivity()
        }else{
            toast(response?.error?.message.toString())
        }
    }
    private fun startMainActivity() {
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
        finish()
    }
    private fun launchSignIn() {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
    }
}
package co.milesoft.rides

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.milesoft.rides.databinding.ActivityMainBinding
import co.milesoft.rides.misc.authorize
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSignOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startSignInActivity()
        }
        binding.buttonDrive.setOnClickListener {
            val i = Intent(this,DriveActivity::class.java)
            startActivity(i)
        }
        binding.buttonRide.setOnClickListener {
            val i = Intent(this,RideActivity::class.java)
            startActivity(i)
        }
    }

    override fun onResume() {
        super.onResume()
        authorize()
    }

    private fun startSignInActivity() {
        val i = Intent(this,SignInActivity::class.java)
        startActivity(i)
        finish()
    }
}
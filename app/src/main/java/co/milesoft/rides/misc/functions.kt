package co.milesoft.rides.misc

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import co.milesoft.rides.SignInActivity
import com.google.firebase.auth.FirebaseAuth

fun AppCompatActivity.toast(msg:String){
    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
}
fun AppCompatActivity.authorize(){
    val user = FirebaseAuth.getInstance().currentUser
    if (user == null){
        val i = Intent(this,SignInActivity::class.java)
        startActivity(i)
        finish()
    }
}
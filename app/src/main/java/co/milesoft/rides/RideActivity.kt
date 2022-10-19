package co.milesoft.rides

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.milesoft.rides.misc.authorize

class RideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ride)
    }

    override fun onResume() {
        super.onResume()
        authorize()
    }
}
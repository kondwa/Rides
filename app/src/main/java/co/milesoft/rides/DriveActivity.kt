package co.milesoft.rides

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.milesoft.rides.misc.authorize

class DriveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drive)
    }

    override fun onResume() {
        super.onResume()
        authorize()
    }
}
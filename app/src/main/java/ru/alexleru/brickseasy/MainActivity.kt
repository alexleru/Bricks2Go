package ru.alexleru.brickseasy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.alexleru.brickseasy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    val cnh = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        APP_ACTIVITY   = this
    }
}
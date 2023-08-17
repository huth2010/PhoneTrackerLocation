package com.knd.duantotnghiep.phonetrackerlocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.knd.duantotnghiep.phonetrackerlocation.core.BaseActivity
import com.knd.duantotnghiep.phonetrackerlocation.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding
    }

    override fun getViewBinding(): ActivityMainBinding {
         return ActivityMainBinding.inflate(layoutInflater)
    }
}
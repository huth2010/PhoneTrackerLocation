package com.knd.duantotnghiep.phonetrackerlocation.core

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    private var _binding: VB? = null
    open val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        setContentView(binding.root)
    }

    fun setUpToolBar(toolbar: Toolbar, enableDisplayHome: Boolean = false, draw: Drawable) {
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(enableDisplayHome)
            it.setDisplayHomeAsUpEnabled(enableDisplayHome)
            it.setHomeAsUpIndicator(draw)
        }
    }

    abstract fun getViewBinding(): VB

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
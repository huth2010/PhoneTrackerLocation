package com.knd.duantotnghiep.phonetrackerlocation.core

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(layout: Int) : Fragment(layout) {
    private var _binding: VB? = null
    open val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = getViewBinding(view)
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun getViewBinding(view: View): VB

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
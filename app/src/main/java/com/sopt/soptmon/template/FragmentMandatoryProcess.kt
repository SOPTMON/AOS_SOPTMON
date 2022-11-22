package com.sopt.soptmon.template

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

interface FragmentMandatoryProcess<out FragmentType> {
    fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    )

    fun getBinding(): ViewBinding
    fun removeBinding()
}
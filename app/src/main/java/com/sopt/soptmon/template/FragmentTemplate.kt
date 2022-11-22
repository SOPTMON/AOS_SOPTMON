package com.sopt.soptmon.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class FragmentTemplate<FragmentType> : Fragment(), FragmentMandatoryProcess<FragmentType> {
    protected var _binding: ViewBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initBinding(inflater, container, false)

        return (getBinding() as ViewBinding).root
    }

    override fun removeBinding() {
        _binding = null
    }

    override fun onDestroyView() {
        removeBinding()
        super.onDestroyView()
    }
}
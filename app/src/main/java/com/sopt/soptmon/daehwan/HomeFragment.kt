package com.sopt.soptmon.daehwan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt.soptmon.databinding.HomeFrameBinding
import com.sopt.soptmon.template.FragmentTemplate

class HomeFragment : FragmentTemplate<HomeFrameBinding>() {

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    ) {
        _binding = HomeFrameBinding.inflate(inflater, container, attachToParent)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun getBinding(): HomeFrameBinding = requireNotNull(_binding) as HomeFrameBinding
}
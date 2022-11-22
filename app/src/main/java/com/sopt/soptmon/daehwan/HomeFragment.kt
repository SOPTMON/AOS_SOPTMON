package com.sopt.soptmon.daehwan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt.soptmon.ImageType
import com.sopt.soptmon.R
import com.sopt.soptmon.databinding.HomeFrameBinding
import com.sopt.soptmon.template.FragmentTemplate

class HomeFragment : FragmentTemplate<HomeFrameBinding>() {
    private val adsList = listOf(
        AdsElement(
            imageNo = R.drawable.home_img_ad1,
            imageType = ImageType.PNG,
            imageName = "center",
            imageUrl = null
        ),
        AdsElement(
            imageNo = R.drawable.home_img_ad2,
            imageType = ImageType.PNG,
            imageName = "left",
            imageUrl = null
        ),
        AdsElement(
            imageNo = R.drawable.home_img_ad3,
            imageType = ImageType.PNG,
            imageName = "right",
            imageUrl = null
        )
    )


    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    ) {
        _binding = HomeFrameBinding.inflate(inflater, container, attachToParent)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeBodyAdsBlockAdapter = HomeBodyAdsBlockAdapter(requireContext())
        homeBodyAdsBlockAdapter.setList(adsList)

        getBinding().bodyAds.adapter = homeBodyAdsBlockAdapter
    }

    override fun getBinding(): HomeFrameBinding = requireNotNull(_binding) as HomeFrameBinding
}
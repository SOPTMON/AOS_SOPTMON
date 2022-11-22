package com.sopt.soptmon.daehwan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
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

    private val homeMenuList = listOf(
        MenuElement(
            imageNo = R.drawable.home_ic_attendance,
            imageType = ImageType.SVG,
            imageName = "출석/혜택"
        ),
        MenuElement(
            imageNo = R.drawable.home_ic_flight,
            imageType = ImageType.SVG,
            imageName = "여행/항공권"
        ),
        MenuElement(
            imageNo = R.drawable.home_ic_ecoupon,
            imageType = ImageType.PNG,
            imageName = "E쿠폰"
        ),
        MenuElement(
            imageNo = R.drawable.home_ic_trade,
            imageType = ImageType.SVG,
            imageName = "티몬무역"
        ),
        MenuElement(
            imageNo = R.drawable.home_ic_tvon,
            imageType = ImageType.SVG,
            imageName = "TV ON"
        ),
        MenuElement(
            imageNo = R.drawable.home_ic_foodday,
            imageType = ImageType.SVG,
            imageName = "식품데이"
        ),
        MenuElement(
            imageNo = R.drawable.home_ic_baro,
            imageType = ImageType.PNG,
            imageName = "바로식탁"
        ),
        MenuElement(
            imageNo = R.drawable.home_ic_onlyone,
            imageType = ImageType.SVG,
            imageName = "단하루"
        ),
        MenuElement(
            imageNo = R.drawable.home_ic_manwon,
            imageType = ImageType.SVG,
            imageName = "만원의 행복"
        ),
        MenuElement(
            imageNo = R.drawable.home_ic_appliances,
            imageType = ImageType.SVG,
            imageName = "가전빅세일"
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

        val homeBodyMenuBlockAdapter = HomeBodyMenuBlockAdapter(requireContext())
        homeBodyMenuBlockAdapter.setList(homeMenuList)
        getBinding().bodyMenu.adapter = homeBodyMenuBlockAdapter
    }

    override fun getBinding(): HomeFrameBinding = requireNotNull(_binding) as HomeFrameBinding
}
package com.sopt.soptmon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sopt.soptmon.R
import com.sopt.soptmon.service.CategoryData
import com.sopt.soptmon.databinding.FragmentCategoryBinding
import com.sopt.soptmon.service.CategoryAdapter

class CategoryFragment : Fragment() {
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화되지 않았슴다.")

    private val mockRepoList = listOf<CategoryData>(
        CategoryData(
            image = R.drawable.cloth,
            name = "",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.ic_launcher_foreground,
            name = "",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.cloth,
            name = "의류",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.fashion,
            name = "패션잡화",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.beauty,
            name = "뷰티",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.child,
            name = "유아",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.food,
            name = "식품",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.living,
            name = "생활.주방",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.interior,
            name = "가구.인테리어",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.pet,
            name = "반려동물용품",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.book,
            name = "도서.교육.취미",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.sport,
            name = "스포츠",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.digital,
            name = "가전.디지털.컴퓨터",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.car,
            name = "자동차",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.travel,
            name = "여행",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.buying,
            name = "해외직구",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.performance,
            name = "공연.전시.체험",
            colors = arrayListOf()
        ),
        CategoryData(
            image = R.drawable.performance,
            name = "기획전",
            colors = arrayListOf(R.drawable.category_img_ad2, R.drawable.category_img_ad1, R.drawable.category_img_ad3)
        )
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CategoryAdapter(requireContext())
        binding.rvHomeFragment.adapter = adapter
        adapter.setRepoList(mockRepoList)   //notifydataset
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
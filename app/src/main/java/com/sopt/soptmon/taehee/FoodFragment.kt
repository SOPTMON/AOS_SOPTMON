package com.dabo.soptmon_prototype

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dabo.soptmon_prototype.adaptor.BestItemAdaptor
import com.dabo.soptmon_prototype.adaptor.CustomItemAdaptor
import com.dabo.soptmon_prototype.adaptor.FoodCategoryAdaptor
import com.dabo.soptmon_prototype.data.FoodCategory
import com.dabo.soptmon_prototype.databinding.FragmentFoodBinding
import com.dabo.soptmon_prototype.remote.BestItemServicePool
import com.dabo.soptmon_prototype.remote.CustomItemServicePool
import com.dabo.soptmon_prototype.remote.ResponseBestItemDto
import com.dabo.soptmon_prototype.remote.ResponseCustomItemDto
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodFragment : Fragment() {
    private var _binding: FragmentFoodBinding? = null
    private val binding get() = requireNotNull(_binding) { "There is an error in CategoryDetailFragment" }

    private val customItemService = CustomItemServicePool.customItemService
    private val customItemViewModel by viewModels<CustomItemViewModel>()

    private val bestItemService = BestItemServicePool.bestItemService
    private val bestItemViewModel by viewModels<BestItemViewModel>()

    private val foodCategoryList = listOf<FoodCategory>(
        FoodCategory(
            title = "전체"
        ),
        FoodCategory(
            title = "신선식품"
        ),
        FoodCategory(
            title = "가공식품"
        ),
        FoodCategory(
            title = "건강식품/다이어트"
        ),
        FoodCategory(
            title = "커피/음료"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customItemService.getCustomItem().enqueue(object : Callback<ResponseCustomItemDto> {
            override fun onResponse(
                call: Call<ResponseCustomItemDto>,
                response: Response<ResponseCustomItemDto>
            ) {
                if (response.isSuccessful) {
                    customItemViewModel.customItemList.addAll(response.body()?.data!!)

                    val adaptor = CustomItemAdaptor(requireContext())
                    binding.rvCustomItem.adapter = adaptor
                    adaptor.setCustomItemList(customItemViewModel.customItemList)
                    Log.e("customAdapter", "onResponse: customAdapter")
                } else if (response.code() == 404) {
                    Snackbar.make(binding.root, "404 error", Snackbar.LENGTH_LONG)
                        .show()
                } else if (response.code() == 401) {
                    Snackbar.make(binding.root, "401 error", Snackbar.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<ResponseCustomItemDto>, t: Throwable) {
                Log.e("customItemServer", "onFailure: customItemServer", t)
                Snackbar.make(binding.root, "서버 통신 장애가 발생", Snackbar.LENGTH_LONG).show()
            }

        }
        )

        bestItemService.getBestItem().enqueue(object : Callback<ResponseBestItemDto>{
            override fun onResponse(
                call: Call<ResponseBestItemDto>,
                response: Response<ResponseBestItemDto>
            ) {
                if(response.isSuccessful){
                    bestItemViewModel.bestItemList.addAll(response.body()?.data!!)
                    val adapter = BestItemAdaptor(requireContext())
                    binding.rvBestItem.adapter = adapter
                    adapter.setBestItemList(bestItemViewModel.bestItemList)
                }
                else if (response.code() == 404) {
                    Snackbar.make(binding.root, "404 error", Snackbar.LENGTH_LONG)
                        .show()
                } else if (response.code() == 401) {
                    Snackbar.make(binding.root, "401 error", Snackbar.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<ResponseBestItemDto>, t: Throwable) {
                Snackbar.make(binding.root, "서버 통신 장애가 발생", Snackbar.LENGTH_LONG).show()
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
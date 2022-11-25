package com.sopt.soptmon.service

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.soptmon.api.food.FoodCategory
import com.sopt.soptmon.databinding.ItemFoodCategoryBinding

class FoodCategoryAdaptor(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var foodCategoryList: List<FoodCategory> = emptyList()

    class FoodCategoryViewHolder(private val binding: ItemFoodCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setFoodCategoryItem(list: FoodCategory) {
            binding.tvFoodCategoryName.text = list.title
            if (binding.tvFoodCategoryName.text == "전체") {
                changeTextColorToTmon(list)
            }
        }

        private fun changeTextColorToTmon(data: FoodCategory) {
            val txt = "${data.title}" // 안녕나는준원이야
            val spannableString = SpannableString(txt)
            val start = txt.indexOf("${data.title}")
            val end = txt.lastIndex + 1
            spannableString.setSpan(
                ForegroundColorSpan(Color.parseColor("#ED7B30")), // 색깔
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.tvFoodCategoryName.text = spannableString

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemFoodCategoryBinding.inflate(inflater, parent, false)
        return FoodCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FoodCategoryViewHolder) holder.setFoodCategoryItem(foodCategoryList[position])
    }

    override fun getItemCount() = foodCategoryList.size

    fun setFoodCategoryList(foodCategoryList: List<FoodCategory>) {
        this.foodCategoryList = foodCategoryList.toList()
        notifyDataSetChanged()
    }
}
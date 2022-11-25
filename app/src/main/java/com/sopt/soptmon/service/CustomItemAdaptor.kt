package com.sopt.soptmon.service

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dabo.soptmon_prototype.databinding.LayoutCustomitemListBinding
import com.sopt.soptmon.api.food.ResponseCustomItemDto

class CustomItemAdaptor(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var customItemList: List<ResponseCustomItemDto.CustomItem> = emptyList()

    class CustomListViewHolder(private val binding: LayoutCustomitemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setCustomItem(list: ResponseCustomItemDto.CustomItem) {
            Glide.with(this.binding.root)
                .load(list.itemImage)
                .into(binding.imgCustomItem)
            binding.txtCustomItemName.text = list.itemName
            binding.txtCustomItemPrice.text = "${list.itemPrice}원~"
            onBindDiscountRate(list)
        }

        private fun onBindDiscountRate(data: ResponseCustomItemDto.CustomItem) {
            val txt = "${data.itemName}/ ${data.discountRate}%할인" // 안녕나는준원이야
            val spannableString = SpannableString(txt)
            val start = txt.indexOf("${data.discountRate}")
            val end = txt.lastIndex + 1
            spannableString.setSpan(
                ForegroundColorSpan(Color.parseColor("#ED7B30")), // 색깔
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.txtCustomItemName.text = spannableString

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = LayoutCustomitemListBinding.inflate(inflater, parent, false)
        return CustomListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CustomListViewHolder) holder.setCustomItem(customItemList[position])
    }

    override fun getItemCount() = customItemList.size

    fun setCustomItemList(customItemList: List<ResponseCustomItemDto.CustomItem>) {
        Log.e("setCustomItemList", "setCustomItemList: FoodFragment")
        this.customItemList = customItemList.toList()
        notifyDataSetChanged()
    }
}
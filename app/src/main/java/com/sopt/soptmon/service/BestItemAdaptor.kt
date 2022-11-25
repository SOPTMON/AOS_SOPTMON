package com.sopt.soptmon.service

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dabo.soptmon_prototype.databinding.LayoutBestItemListBinding
import com.sopt.soptmon.api.food.ResponseBestItemDto

class BestItemAdaptor(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var bestItemList: List<ResponseBestItemDto.BestItem> = emptyList()

    class BestListViewHolder(private val binding: LayoutBestItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setBestItem(list: ResponseBestItemDto.BestItem) {
            Glide.with(this.binding.root)
                .load(list.bestItemImage)
                .into(binding.imgBestItem)
            binding.tvBestItemName.text = list.bestItemName
            binding.txtBestItemPrice.text = "${list.bestItemPrice}원"
            binding.tvBestItemNumber.text = "0${list.bestItemId}"
            if (list.bestDiscountRate != 0) {
                onBindDiscountRate(list)
            }
        }

        private fun onBindDiscountRate(data: ResponseBestItemDto.BestItem) {
            val txt = "${data.bestDiscountRate}% ${data.bestItemPrice}"
            val spannableString = SpannableString(txt)
            val start = txt.indexOf("${data.bestDiscountRate}")
            val end = txt.lastIndexOf("${data.bestDiscountRate}") + 3
            spannableString.setSpan(
                ForegroundColorSpan(Color.parseColor("#ED7B30")),
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.txtBestItemPrice.text = spannableString
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = LayoutBestItemListBinding.inflate(inflater, parent, false)
        return BestListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BestListViewHolder) holder.setBestItem(bestItemList[position])
    }

    override fun getItemCount() = bestItemList.size

    fun setBestItemList(bestItemList: List<ResponseBestItemDto.BestItem>) {
        this.bestItemList = bestItemList.toList()
        notifyDataSetChanged()
    }
}
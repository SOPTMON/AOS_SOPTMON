package com.sopt.soptmon.daehwan

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.soptmon.databinding.SuggestionBlockElementBinding

class HomeBodySuggestionBlockAdaptor(
    context: Context
) : RecyclerView.Adapter<HomeBodySuggestionBlockAdaptor.ViewHolder>() {
    private var suggestionList = emptyList<SuggestionElementNameOnly>()

    private val inflater by lazy {
        LayoutInflater.from(context)
    }

    class ViewHolder(
        private val binding: SuggestionBlockElementBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: SuggestionElementNameOnly) {
            Glide.with(binding.root)
                .load(data.imageUrl)
                .centerCrop()
                .into(binding.imgSuggestion)

            binding.nameSuggestionFirst.text = firstLine(data.name)
            binding.nameSuggestionSecondEllip.text = secondLine(data.name)
            binding.discountSuggestion.text = discountInfo(data.discountRate)
            binding.priceSuggestion.text = priceInfo(data.price)
        }

        fun firstLine(name: String) = name.substring(0, LINE_SEPARATE_INDEX)
        fun secondLine(name: String) = name.substring(LINE_SEPARATE_INDEX)
        fun discountInfo(discountRate: Int) = "${discountRate}% 할인"
        fun priceInfo(price: Int) = "${price}원 ~"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SuggestionBlockElementBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(suggestionList[position])
    }

    override fun getItemCount() = suggestionList.size

    fun setList(list: List<SuggestionElementNameOnly>) {
        suggestionList = list.toList()

        if (suggestionList.changed(list)) {
            notifyDataSetChanged()
        }
    }

    private fun <E> List<E>.changed(toBe: List<E>) =
        !(this.size == toBe.size && this.containsAll(toBe))

    companion object {
        private const val LINE_SEPARATE_INDEX = 10
    }
}

data class SuggestionElementNameOnly(
    val id: Int,
    val name: String,
    val discountRate: Int,
    val price: Int,
    val imageUrl: String
) {
    companion object {
        fun from(dataList: List<SuggestionDetail>?): List<SuggestionElementNameOnly> {
            return dataList?.map {
                SuggestionElementNameOnly(
                    id = it.id,
                    name = it.name,
                    discountRate = it.discountRate,
                    price = it.price,
                    imageUrl = it.imageUrl
                )
            } ?: emptyList()
        }
    }
}

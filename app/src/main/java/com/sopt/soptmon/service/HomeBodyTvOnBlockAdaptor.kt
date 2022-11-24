package com.sopt.soptmon.service

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.soptmon.daehwan.TvOnDetail
import com.sopt.soptmon.databinding.TvonBlockElementBinding

class HomeBodyTvOnBlockAdaptor(
    context: Context
) : RecyclerView.Adapter<HomeBodyTvOnBlockAdaptor.ViewHolder>() {

    private var tvOnList = emptyList<TvOnElement>()

    private val inflater by lazy {
        LayoutInflater.from(context)
    }

    class ViewHolder(
        private val normalElementBinding: TvonBlockElementBinding
    ) : RecyclerView.ViewHolder(normalElementBinding.root) {
        fun onBind(data: TvOnElement) {

            Glide.with(normalElementBinding.root)
                .load(data.imageUrl)
                .centerCrop()
                .into(normalElementBinding.imgTvOn)

            normalElementBinding.txTvOn.text = data.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TvonBlockElementBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.onBind(tvOnList[position])
    }

    override fun getItemCount() = tvOnList.size

    fun setList(list: List<TvOnElement>) {
        tvOnList = list.toList()

        if (tvOnList.changed(list)) {
            notifyDataSetChanged()
        }
    }

    private fun <E> List<E>.changed(toBe: List<E>) =
        !(this.size == toBe.size && this.containsAll(toBe))
}

data class TvOnElement(
    val id: Int,
    val name: String,
    val imageUrl: String
) {
    companion object {
        fun from(dataList: List<TvOnDetail>?): List<TvOnElement> {
            return dataList?.map {

                TvOnElement(
                    id = it.id,
                    name = it.name,
                    imageUrl = it.imageUrl
                )
            } ?: emptyList()
        }
    }
}
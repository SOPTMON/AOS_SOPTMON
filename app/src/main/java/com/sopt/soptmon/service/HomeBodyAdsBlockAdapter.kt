package com.sopt.soptmon.service

import android.content.Context
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.sopt.soptmon.ImageType
import com.sopt.soptmon.databinding.HomeAdsBlockElementBinding

class HomeBodyAdsBlockAdapter(
    context: Context
) : RecyclerView.Adapter<HomeBodyAdsBlockAdapter.ViewHolder>() {

    private val inflater by lazy {
        LayoutInflater.from(context)
    }

    private var adsImageList = emptyList<AdsElement>()

    class ViewHolder(
        private val binding: HomeAdsBlockElementBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: AdsElement) {
            binding.imgAds.setImageResource(data.imageNo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HomeAdsBlockElementBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(adsImageList[position])
    }

    override fun getItemCount() = adsImageList.size

    fun setList(list: List<AdsElement>) {
        adsImageList = list.toList()

        if (adsImageList.changed(list)) {
            notifyDataSetChanged()
        }
    }

    private fun <E> List<E>.changed(toBe: List<E>) =
        !(this.size == toBe.size && this.containsAll(toBe))
}

data class AdsElement(
    @DrawableRes val imageNo: Int,
    val imageName: String?,
    val imageType: ImageType?,
    val imageUrl: String?
)

class HomeAdsDecorator(val width : Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = width
        outRect.right = width
    }
}

class HomeAdsState() : RecyclerView.State() {
    override fun getRemainingScrollHorizontal(): Int {
        return 2
    }
}
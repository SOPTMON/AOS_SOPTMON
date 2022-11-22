package com.sopt.soptmon.daehwan

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.sopt.soptmon.ImageType
import com.sopt.soptmon.databinding.HomeMenuBlockElementBinding

class HomeBodyMenuBlockAdapter(
    context: Context
) : RecyclerView.Adapter<HomeBodyMenuBlockAdapter.ViewHolder>() {

    private val inflater by lazy {
        LayoutInflater.from(context)
    }

    private var menuList = emptyList<MenuElement>()

    class ViewHolder(
        private val binding: HomeMenuBlockElementBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: MenuElement) {
            binding.imgName.text = data.imageName
            binding.imgMenu.setImageResource(data.imageNo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HomeMenuBlockElementBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(menuList[position])
    }

    override fun getItemCount() = menuList.size

    fun setList(list: List<MenuElement>) {
        menuList = list.toList()

        if (menuList.changed(list)) {
            notifyDataSetChanged()
        }
    }

    private fun <E> List<E>.changed(toBe: List<E>) =
        !(this.size == toBe.size && this.containsAll(toBe))
}

data class MenuElement(
    @DrawableRes val imageNo: Int,
    val imageName: String,
    val imageType: ImageType
)
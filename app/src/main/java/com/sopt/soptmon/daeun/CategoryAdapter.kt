package com.sopt.soptmon.daeun

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.soptmon.daeun.data.CategoryData
import com.sopt.soptmon.databinding.ItemCategoryExhibitionsBinding
import com.sopt.soptmon.databinding.ItemCategoryListBinding
import com.sopt.soptmon.databinding.ItemCategoryTitleBinding
import com.sopt.soptmon.databinding.ItemNewBinding

class CategoryAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var categoryList: List<CategoryData> = emptyList()
    private val inflater by lazy {LayoutInflater.from(context)}


    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TITLE_ITEM
            1 -> NEW_ITEM
            17 -> EXHIBITION_ITEM
            else -> CATEGORY_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            TITLE_ITEM -> {
                val binding = ItemCategoryTitleBinding.inflate(inflater, parent,false)
                HomeTitleViewHolder(binding)
            }
            CATEGORY_ITEM -> {
                val binding = ItemCategoryListBinding.inflate(inflater, parent,false)
                binding.btnArrow.setOnClickListener {
                    if(binding.subCategory.visibility == View.VISIBLE){
                        binding.subCategory.visibility = View.GONE
                        }
                    else{
                        binding.subCategory.visibility = View.VISIBLE
                    }
                }
                HomeBodyViewHolder(binding)

            }
            NEW_ITEM -> {
                val binding = ItemNewBinding.inflate(inflater, parent,false)
                ItemNewHolder(binding)
            }
            EXHIBITION_ITEM ->
                     { val binding = ItemCategoryExhibitionsBinding.inflate(inflater, parent,false)
                         ExhibitionViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeBodyViewHolder) {
            holder.onBind(categoryList[position])
        }
        if(holder is ExhibitionViewHolder){
           holder.bind(categoryList[position])
        }
    }

    override fun getItemCount(): Int = categoryList.size

    fun setRepoList(repoList: List<CategoryData>) {
        this.categoryList = repoList.toList()
        notifyDataSetChanged()
    }

    //ViewHolder
    class HomeTitleViewHolder(
        private val itemCategoryTitleBinding: ItemCategoryTitleBinding
    ) : RecyclerView.ViewHolder(itemCategoryTitleBinding.root) {}

    class ItemNewHolder(
        private val itemNewBinding: ItemNewBinding
    ) : RecyclerView.ViewHolder(itemNewBinding.root) {}

    class HomeBodyViewHolder(
        private val  itemCategoryListBinding: ItemCategoryListBinding
    ) : RecyclerView.ViewHolder(itemCategoryListBinding.root) {
        fun onBind(data: CategoryData) {
            itemCategoryListBinding.categorydata = data
        }
    }
    class ExhibitionViewHolder(
        private val itemCategoryExhibitionsBinding : ItemCategoryExhibitionsBinding
    ): RecyclerView.ViewHolder(itemCategoryExhibitionsBinding.root) {
        fun bind(item: CategoryData) {
           with(itemCategoryExhibitionsBinding)
            {
                viewPager.offscreenPageLimit = 1
                viewPager.clipToPadding = false
                viewPager.clipChildren = false
                viewPager.setPageTransformer{
                    page, position ->
                    page.translationX = position * -400
                }
                viewPager.adapter = ViewPagerAdatper().build(item.colors)
                viewPager.setCurrentItem(1)
            }
        }
    }


    companion object {
        private const val TITLE_ITEM = 0
        private const val NEW_ITEM = 1
        private const val CATEGORY_ITEM = 2
        private const val EXHIBITION_ITEM = 3
    }
}
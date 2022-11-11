package org.sopt.sample.presentation.main.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.databinding.ItemGalleryBinding

class GalleryAdapter(initItems: List<Int> = listOf()) :
    RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {
    private var items: List<Int> = initItems

    fun setItems(items: List<Int>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val binding = ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class GalleryViewHolder(private val binding: ItemGalleryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(src: Int) {
            binding.imgGallery.setImageResource(src)
        }
    }
}
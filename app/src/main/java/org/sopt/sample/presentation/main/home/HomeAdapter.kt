package org.sopt.sample.presentation.main.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.data.RepoData
import org.sopt.sample.databinding.ItemListHomeBinding

class HomeAdapter(context: Context) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private var repoList: List<RepoData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding =
            ItemListHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    override fun getItemCount(): Int = repoList.size

    fun setRepoList(repoList: List<RepoData>) {
        this.repoList = repoList.toList()
        notifyDataSetChanged()
    }

    class HomeViewHolder(
        private val homeItemListHomeBinding: ItemListHomeBinding
    ) : RecyclerView.ViewHolder(homeItemListHomeBinding.root) {
        fun onBind(data: RepoData) {
            homeItemListHomeBinding.repodata = data
            Log.d("data가 잘 들어오나?", "onBind: $data")
        }
    }
}

package org.sopt.sample.presentation.main.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.data.RepoData
import org.sopt.sample.databinding.ItemBodyListHomeBinding
import org.sopt.sample.databinding.ItemTitleHomeBinding

class HomeAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var repoList: List<RepoData> = emptyList()
    private lateinit var itemTitleHomeBinding: ItemTitleHomeBinding
    private lateinit var itemBodyListHomeBinding: ItemBodyListHomeBinding

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TITLE_ITEM
            else -> BODY_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            TITLE_ITEM -> {
                itemTitleHomeBinding =
                    ItemTitleHomeBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                HomeTitleViewHolder(itemTitleHomeBinding)
            }
            BODY_ITEM -> {
                itemBodyListHomeBinding =
                    ItemBodyListHomeBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                HomeBodyViewHolder(itemBodyListHomeBinding)
            }
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeBodyViewHolder) {
            holder.onBind(repoList[position])
        }
    }

    override fun getItemCount(): Int = repoList.size

    fun setRepoList(repoList: List<RepoData>) {
        this.repoList = repoList.toList()
        notifyDataSetChanged()
    }

    class HomeTitleViewHolder(
        private val itemTitleHomeBinding: ItemTitleHomeBinding
    ) : RecyclerView.ViewHolder(itemTitleHomeBinding.root) {}

    class HomeBodyViewHolder(
        private val homeBodyBinding: ItemBodyListHomeBinding
    ) : RecyclerView.ViewHolder(homeBodyBinding.root) {
        fun onBind(data: RepoData) {
            homeBodyBinding.repodata = data
        }
    }

    companion object {
        private const val TITLE_ITEM = 0
        private const val BODY_ITEM = 1
    }
}

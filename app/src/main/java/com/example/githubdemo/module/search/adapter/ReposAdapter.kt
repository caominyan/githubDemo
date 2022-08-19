package com.example.githubdemo.module.search.adapter

import android.content.res.ColorStateList
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.githubdemo.databinding.LayoutItemRepositoryBinding
import com.example.githubdemo.imageapi.ImageFx
import com.example.githubdemo.module.search.pojo.Repository
import com.example.githubdemo.utils.LanguageColorsHelper
import java.lang.String
import kotlin.Boolean
import kotlin.Int

class ReposAdapter : PagingDataAdapter<Repository, RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)!!
        (holder as RepoViewHolder).bind(repoItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RepoViewHolder.create(parent)
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Repository>() {
            override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean =
                oldItem.fullName == newItem.fullName

            override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean =
                oldItem == newItem
        }
    }
}

class RepoViewHolder(val binding: LayoutItemRepositoryBinding) : RecyclerView.ViewHolder(binding.root) {

    private var repo: Repository? = null

    fun bind(repo: Repository) {
        showRepoData(repo)
    }

    private fun showRepoData(repository: Repository) {
        val hasOwnerAvatar: Boolean = !TextUtils.isEmpty(repository.owner?.avatarUrl)
        binding.tvRepoName.text = if (hasOwnerAvatar) repository.name else repository.fullName
        binding.tvRepoDescription.text = repository.description
        binding.tvStarNum.text = String.valueOf(repository.stargazersCount)
        binding.tvForkNum.text = String.valueOf(repository.forksCount)
        binding.tvOwnerName.text = repository.owner?.login

        if (TextUtils.isEmpty(repository.language)) {
            binding.tvLanguage.text = ""
            binding.languageColor.visibility = View.INVISIBLE
        } else {
            binding.languageColor.visibility = View.VISIBLE
            binding.tvLanguage.setText(repository.language)
            repository.language?.run {
                val languageColor: Int =
                    LanguageColorsHelper.getColor(binding.languageColor.context, this)
                binding.languageColor.imageTintList = ColorStateList.valueOf(languageColor)
            }
        }


        if (hasOwnerAvatar) {
            binding.ivUserAvatar.visibility = View.VISIBLE
            binding.ownerLay.visibility = View.VISIBLE
            binding.sinceStarLay.visibility = View.GONE
            repository.owner?.avatarUrl?.run {
                ImageFx.getLoader()?.loadImage(binding.ivUserAvatar,this)
            }
        } else {
            binding.ivUserAvatar.visibility = View.GONE
            binding.ownerLay.visibility = View.GONE
            binding.sinceStarLay.visibility = View.INVISIBLE
        }
        binding.forkMark.visibility = View.GONE
    }

    companion object {
        fun create(parent: ViewGroup): RepoViewHolder {
            val binding = LayoutItemRepositoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return RepoViewHolder(binding)
        }
    }
}
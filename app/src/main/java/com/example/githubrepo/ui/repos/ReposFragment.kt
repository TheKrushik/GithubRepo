package com.example.githubrepo.ui.repos

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.example.githubrepo.R
import com.example.githubrepo.databinding.FragmentReposBinding
import com.example.githubrepo.ui.BaseFragment

class ReposFragment : BaseFragment<ReposViewModel, FragmentReposBinding>() {

    override val layoutRes: Int = R.layout.fragment_repos

    override fun getViewModel(): Class<ReposViewModel> = ReposViewModel::class.java

    private val args: ReposFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dataBinding.lifecycleOwner = this

        dataBinding.viewModel = viewModel

        dataBinding.recyclerRepo.adapter = RepoAdapter()

        viewModel.getRepoList(args.argUser)

    }
}

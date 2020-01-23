package com.example.githubrepo.ui.repos

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.githubrepo.R
import com.example.githubrepo.databinding.FragmentReposBinding
import com.example.githubrepo.di.Injectable
import com.example.githubrepo.di.injectViewModel
import com.example.githubrepo.ui.BaseFragment
import javax.inject.Inject

class ReposFragment : BaseFragment<ReposViewModel, FragmentReposBinding>() {

    override val layoutRes: Int = R.layout.fragment_repos

    private val args: ReposFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)

        dataBinding.let {
            it.lifecycleOwner = this
            it.viewModel = viewModel
            it.recyclerRepo.adapter = RepoAdapter()
        }

        viewModel.getRepoList(args.argUser)

    }
}

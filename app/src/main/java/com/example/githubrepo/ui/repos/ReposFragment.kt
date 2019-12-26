package com.example.githubrepo.ui.repos


import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.githubrepo.R
import com.example.githubrepo.databinding.FragmentReposBinding
import com.example.githubrepo.ui.BaseFragment


class ReposFragment : BaseFragment<ReposViewModel, FragmentReposBinding>() {

    override val layoutRes: Int = R.layout.fragment_repos

    override fun getViewModel(): Class<ReposViewModel> = ReposViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        viewModel.getRepoList("TheKrushik").observe(this, Observer { postcard ->
//            postcard?.let { list ->
//                Log.d("MyTag", list.toString())
//            }
//        })
    }
}

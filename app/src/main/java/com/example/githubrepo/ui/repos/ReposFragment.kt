package com.example.githubrepo.ui.repos


import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.githubrepo.R
import com.example.githubrepo.databinding.FragmentReposBinding
import com.example.githubrepo.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_repos.*


class ReposFragment : BaseFragment<ReposViewModel, FragmentReposBinding>() {

    override val layoutRes: Int = R.layout.fragment_repos

    override fun getViewModel(): Class<ReposViewModel> = ReposViewModel::class.java

    private val args: ReposFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val user = args.argUser
        test.text = user
//        viewModel.user = user

        viewModel.repos.observe(this, Observer { postcard ->
            postcard?.let { list ->
                Log.d("MyTag", list.toString())
            }
        })
    }
}

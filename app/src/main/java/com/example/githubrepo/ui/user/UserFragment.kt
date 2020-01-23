package com.example.githubrepo.ui.user

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.githubrepo.R
import com.example.githubrepo.databinding.FragmentUserBinding
import com.example.githubrepo.di.injectViewModel
import com.example.githubrepo.extension.hideKeyboard
import com.example.githubrepo.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : BaseFragment<UserViewModel, FragmentUserBinding>() {

    override val layoutRes: Int = R.layout.fragment_user

    var name: String = ""

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)

        dataBinding.let {
            it.lifecycleOwner = this
            it.viewModel = viewModel
        }

        viewModel.userName.observe(viewLifecycleOwner, Observer { userName ->
            name = userName
        })

        btnConfirm.setOnClickListener {
            requireContext().hideKeyboard(btnConfirm)
            navController.navigate(UserFragmentDirections.actionUserFragmentToReposFragment(name))
        }
    }
}

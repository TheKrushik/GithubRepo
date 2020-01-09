package com.example.githubrepo.ui.user

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.githubrepo.R
import com.example.githubrepo.databinding.FragmentUserBinding
import com.example.githubrepo.extension.hideKeyboard
import com.example.githubrepo.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : BaseFragment<UserViewModel, FragmentUserBinding>() {

    override val layoutRes: Int = R.layout.fragment_user

    override fun getViewModel(): Class<UserViewModel> = UserViewModel::class.java

    var name: String = ""

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dataBinding.lifecycleOwner = this

        dataBinding.viewModel = viewModel

        viewModel.userName.observe(this, Observer { userName ->
            name = userName
        })

        btnConfirm.setOnClickListener {
            requireContext().hideKeyboard(btnConfirm)
            navController.navigate(UserFragmentDirections.actionUserFragmentToReposFragment(name))
        }
    }
}

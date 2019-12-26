package com.example.githubrepo.ui.user

import android.os.Bundle
import com.example.githubrepo.R
import com.example.githubrepo.databinding.FragmentUserBinding
import com.example.githubrepo.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : BaseFragment<UserViewModel, FragmentUserBinding>() {

    override val layoutRes: Int = R.layout.fragment_user

    override fun getViewModel(): Class<UserViewModel> = UserViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnConfirm.setOnClickListener {
            val userName = etUserName.text.toString()
            navController.navigate(UserFragmentDirections.actionUserFragmentToReposFragment(userName))
        }
    }
}

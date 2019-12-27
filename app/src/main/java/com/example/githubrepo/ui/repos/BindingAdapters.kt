package com.example.githubrepo.ui.repos

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepo.models.Repo


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Repo>?) {
    val adapter = recyclerView.adapter as RepoAdapter
    adapter.submitList(data)
}

@BindingAdapter("requestStatus")
fun bindStatus(statusView: ProgressBar, status: RequestStatus?) {
    when (status) {
        RequestStatus.LOADING -> statusView.visibility = View.VISIBLE
        RequestStatus.ERROR -> statusView.visibility = View.VISIBLE
        RequestStatus.DONE -> statusView.visibility = View.GONE
    }
}

@BindingAdapter("repoInt")
fun bindingId(textView: TextView, textId: Int?) {
    textView.text = textId.toString()
}

@BindingAdapter("repoString")
fun bindingString(textView: TextView, text: String?) {
    textView.text = text
}


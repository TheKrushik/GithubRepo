package com.example.githubrepo.models

import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("description") val description: String?,
    @SerializedName("language") val language: String?,
    @SerializedName("created_at") val created_at: String
    ) {
}
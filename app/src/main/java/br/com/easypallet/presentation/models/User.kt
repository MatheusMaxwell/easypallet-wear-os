package br.com.easypallet.presentation.models

import com.google.gson.annotations.SerializedName

data class SessionModel(
    var token: String,
    var userId: Int?,
    var localityId: Int?
)



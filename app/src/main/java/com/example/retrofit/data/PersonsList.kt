package com.example.retrofit.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PersonsList(
    @Json(name = "results") val results: List<Result>
)
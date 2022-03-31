package com.example.retrofitexample

import com.squareup.moshi.Json

data class ImageModel(
    @field:Json(name = "src") val src: String?,
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "alt") val alt: String?
)

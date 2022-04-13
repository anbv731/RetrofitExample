package com.example.retrofitexample.domain

import com.squareup.moshi.Json

data class FishModel(
    @field:Json(name = "Species Name") val speciesName: String?,
    @field:Json(name = "Location") val location: String?,
    @field:Json(name = "Habitat") val habitat: String?,
    @field:Json(name = "Species Illustration Photo") val imageGallery: ImageModel?,
    @field:Json(name = "Scientific Name") val scientificName: String?
)

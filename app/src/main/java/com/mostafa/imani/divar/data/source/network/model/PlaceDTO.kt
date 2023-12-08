package com.mostafa.imani.divar.data.source.network.model

data class PlaceDTO(
    val categories: List<CategoryDTO>,
    val closed_bucket: String,
    val fsq_id: String,
    val link: String,
    val location: LocationDTO,
    val name: String,
    val timezone: String
)


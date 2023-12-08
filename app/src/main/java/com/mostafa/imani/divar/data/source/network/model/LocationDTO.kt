package com.mostafa.imani.divar.data.source.network.model


data class LocationDTO(
    val address: String,
    val census_block: String,
    val country: String,
    val cross_street: String,
    val dma: String,
    val formatted_address: String,
    val locality: String,
    val po_box: String,
    val postcode: String,
    val region: String
)
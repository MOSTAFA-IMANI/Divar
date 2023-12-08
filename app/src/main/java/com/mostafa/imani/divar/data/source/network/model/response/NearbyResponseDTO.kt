package com.mostafa.imani.divar.data.source.network.model.response

import com.mostafa.imani.divar.data.source.network.model.PlaceDTO

data class NearbyResponseDTO (
    val results :List<PlaceDTO>
)
package com.mostafa.imani.divar.data.source.network.place

import com.mostafa.imani.divar.data.source.network.model.PlaceDTO
import com.mostafa.imani.divar.data.source.network.model.response.NearbyResponseDTO

interface PlaceNetworkDataSource {
    suspend fun getNearbyPlaces(latitude:Double, longitude:Double): NearbyResponseDTO?
    suspend fun getPlaceDetail(id:String): PlaceDTO?
}
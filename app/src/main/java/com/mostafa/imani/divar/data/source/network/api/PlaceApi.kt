package com.mostafa.imani.divar.data.source.network.api

import com.mostafa.imani.divar.data.source.network.model.PlaceDTO
import com.mostafa.imani.divar.data.source.network.model.response.NearbyResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlaceApi {

    @GET("/v3/places/nearby")
    suspend fun getNearbyPlaces(
        @Query("ll") latLng: String
    ): Response<NearbyResponseDTO>

    @GET("/v3/places/nearby")
    suspend fun getPlaceDetail(
        @Path("id") id: String
    ): Response<PlaceDTO>
}
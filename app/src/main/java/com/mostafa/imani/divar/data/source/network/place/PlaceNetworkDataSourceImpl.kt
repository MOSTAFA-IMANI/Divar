package com.mostafa.imani.divar.data.source.network.place

import android.content.Context
import com.mostafa.imani.divar.data.source.network.api.PlaceApi
import com.mostafa.imani.divar.data.source.network.model.PlaceDTO
import com.mostafa.imani.divar.data.source.network.model.response.NearbyResponseDTO
import com.mostafa.imani.divar.data.source.network.util.apiCall
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PlaceNetworkDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val placeApi: PlaceApi,
) : PlaceNetworkDataSource {
    override suspend fun getNearbyPlaces(latitude: Double, longitude: Double): NearbyResponseDTO? {
        val latLng = String.format("%f,%f", latitude, longitude)
        return apiCall(context) { placeApi.getNearbyPlaces(latLng) }
    }

    override suspend fun getPlaceDetail(id: String): PlaceDTO? {
        return apiCall(context) { placeApi.getPlaceDetail(id) }
    }
}
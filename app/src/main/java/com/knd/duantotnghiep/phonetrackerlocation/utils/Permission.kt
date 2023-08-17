package com.knd.duantotnghiep.phonetrackerlocation.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.LocationManager
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsResponse
import com.google.android.gms.location.Priority
import com.google.android.gms.location.SettingsClient
import com.google.android.gms.tasks.Task

object Permission {
    const val ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION
    const val ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION
    fun hasPermissionLocation(context: Context): Boolean {
        val PERMISSION_GRANTED = 0
        return context.let {
            val checkFind = it.checkSelfPermission(ACCESS_FINE_LOCATION) == PERMISSION_GRANTED
            val checkCoarse = it.checkSelfPermission(ACCESS_COARSE_LOCATION) == PERMISSION_GRANTED
            checkFind || checkCoarse
        }
    }

    fun hasEnableGPS(context: Context): Boolean {
        val locationMng = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationMng.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    fun turnOnGPS(context: Activity) {
        val request = LocationRequest
            .Builder(1000)
            .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
            .setMaxUpdateDelayMillis(1000)
            .build()
        val builder = LocationSettingsRequest.Builder().addLocationRequest(request)
        val client: SettingsClient = LocationServices.getSettingsClient(context)
        val task: Task<LocationSettingsResponse> = client.checkLocationSettings(builder.build())
        task.addOnFailureListener {
            if (it is ResolvableApiException) {
                try {
                    it.startResolutionForResult(context, 12345)
                } catch (_: IntentSender.SendIntentException) {
                }
            }
        }
    }
}
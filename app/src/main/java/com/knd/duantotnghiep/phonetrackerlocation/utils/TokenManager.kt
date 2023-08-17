package com.knd.duantotnghiep.phonetrackerlocation.utils

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(@ApplicationContext context: Context) {
    private val sharedPreferences =
        context.getSharedPreferences(Constraints.PREFS_TOKEN_FILE, AppCompatActivity.MODE_PRIVATE)

    fun saveToken(token: String) {
        sharedPreferences.edit().apply {
            putString(Constraints.USER_TOKEN, token)
        }.apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString(Constraints.USER_TOKEN, null)
    }
}
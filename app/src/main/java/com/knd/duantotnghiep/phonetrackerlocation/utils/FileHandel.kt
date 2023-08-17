package com.knd.duantotnghiep.phonetrackerlocation.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream



object FileHandel {
    fun saveImage(context: Context, imageView: ImageView): String {
        return try {
            val bitmap = getBitmap(imageView)
            val file = File(context.filesDir, System.currentTimeMillis().toString() + ".png")
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            outputStream.flush()
            outputStream.close()
            getUri(context, file)
        } catch (e: Exception) {
            ""
        }

    }

    private fun getUri(context: Context, file: File): String {
        return FileProvider.getUriForFile(context, Constants.AUTHORITY, file).toString()
    }

    private fun getBitmap(imageView: ImageView): Bitmap {
        return imageView.let { (it.drawable as BitmapDrawable).bitmap }
    }
}
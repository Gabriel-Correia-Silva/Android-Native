package com.example.beberagua

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import java.text.SimpleDateFormat
import java.util.*

class GlassPreferences(private val context: Context) {

    companion object{
        const val PREFS_NAME = "co.com.example.beberagua.preferences"
        const val PREFS_PREFIX= "key_"
    }

    private val sdf = SimpleDateFormat("ddMMyyyy", Locale.US)

    fun save(value: Int){
        println("Saving $value")
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit{
            putInt(PREFS_PREFIX + sdf.format(Date()), value)
        }

    }
    fun fetch():Int {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getInt(PREFS_PREFIX + sdf.format(Date()), 0)
    }
}
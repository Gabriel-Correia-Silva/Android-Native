package com.example.beberagua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.beberagua.GlassType
import com.example.beberagua.GlassPreferences
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private val prefs = GlassPreferences(this)

    private var today: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_small).setOnClickListener {
            saveGlass(GlassType.SMALL)
        }
        findViewById<Button>(R.id.btn_medium).setOnClickListener {
            saveGlass(GlassType.MEDIUM)
        }
        findViewById<Button>(R.id.btn_large).setOnClickListener {
            saveGlass(GlassType.LARGE)
        }
        refresh()
    }


        private fun saveGlass(glassYpe: GlassType){
            prefs.save(today + glassYpe.value)
            Snackbar.make(findViewById(android.R.id.content),R.string.undo, Snackbar.LENGTH_LONG)
                .setAction(android.R.string.ok){
                    prefs.save(today-glassYpe.value)
                    refresh()
                }
                .show()
            refresh()
        }

        private fun refresh(){
            val value = prefs.fetch()
            today = value
            findViewById<TextView>(R.id.text_result).text = getString(R.string.result, today)
        }
}
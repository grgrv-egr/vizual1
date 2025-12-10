package com.example.vizual1

import android.Manifest
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.json.JSONObject
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class LocationActivity : AppCompatActivity() {
    lateinit var tvLat: TextView
    lateinit var tvLon: TextView
    lateinit var tvAlt: TextView
    lateinit var tvTime: TextView
    lateinit var locationClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        tvLat = findViewById(R.id.tv_lat)
        tvLon = findViewById(R.id.tv_lon)
        tvAlt = findViewById(R.id.tv_alt)
        tvTime = findViewById(R.id.tv_time)
        locationClient = LocationServices.getFusedLocationProviderClient(this)
        val btnGet = findViewById<Button>(R.id.btn_update)
        btnGet.setOnClickListener {
            getLocation()
        }
    }
    fun getLocation() {
        if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), 100)
            return
        }

        locationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    showLocation(location)
                    saveLocation(location)
                } else {
                    tvTime.text = "GPS не нашел"
                    Toast.makeText(this, "GPS не работает", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun showLocation(location: android.location.Location) {
        val timeFormat = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())
        val currentTime = timeFormat.format(Date())
        tvLat.text = "Широта: ${location.latitude}"
        tvLon.text = "Долгота: ${location.longitude}"
        tvAlt.text = "Высота: ${location.altitude} м"
        tvTime.text = "Время: $currentTime"
        Toast.makeText(this, "Данные получены!", Toast.LENGTH_SHORT).show()
    }

    fun saveLocation(location: android.location.Location) {
        val json = JSONObject()
        json.put("latitude", location.latitude)
        json.put("longitude", location.longitude)
        json.put("altitude", location.altitude)
        val timeFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        json.put("time", timeFormat.format(Date()))
        val fileName = "location_${System.currentTimeMillis()}.json"
        val file = File(filesDir, fileName)
        file.writeText(json.toString())
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && grantResults.isNotEmpty() && grantResults[0] == android.content.pm.PackageManager.PERMISSION_GRANTED) {
            getLocation()
        }
    }
}
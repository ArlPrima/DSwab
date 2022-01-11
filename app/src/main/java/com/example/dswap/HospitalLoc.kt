package com.example.dswap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.dswap.databinding.ActivityHospitalLocBinding

class HospitalLoc : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityHospitalLocBinding

    val RKZ = LatLng(-7.291140,112.736022)
    val RSUnair = LatLng( -7.269638796013627,112.78487742177319)
    val RSDrSoetomo = LatLng( -7.267940328978933,112.75804483869209)
    var locationArray:ArrayList<LatLng>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHospitalLocBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        locationArray= ArrayList()
        locationArray!!.add(RKZ)
        locationArray!!.add(RSUnair)
        locationArray!!.add(RSDrSoetomo)

    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled = true
       for (i in locationArray!!.indices){
           mMap.addMarker(MarkerOptions().position(locationArray!![i]).title("Marker"))
//           mMap.animateCamera(CameraUpdateFactory.zoomTo(50f))
           mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(locationArray!![i],10f))
           mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArray!!.get(i)))
       }

    }
}
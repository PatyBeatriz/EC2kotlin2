package pe.edu.idat.ec2kotlin

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->




        val mallSur=LatLng(-12.15446,-76.983068)
        googleMap.addMarker(MarkerOptions().position(mallSur).title("Mall del Sur"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(mallSur))

        val coliseo=LatLng(41.890278,12.492222)
        googleMap.addMarker(MarkerOptions().position(coliseo).title("Coliseo Romano"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(coliseo))

        val tajmahal=LatLng(27.174167,78.042222)
        googleMap.addMarker(MarkerOptions().position(tajmahal).title("Taj Majal"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(tajmahal))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}
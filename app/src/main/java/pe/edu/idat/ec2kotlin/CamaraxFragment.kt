package pe.edu.idat.ec2kotlin

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import pe.edu.idat.ec2kotlin.databinding.FragmentCamaraxBinding


class CamaraxFragment : Fragment() {

    private var _binding: FragmentCamaraxBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentCamaraxBinding.inflate(inflater,container,false)

        binding.btnTomarFoto.setOnClickListener{
            start.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }



        return binding.root
    }

    private val start=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result: ActivityResult->
        if (result.resultCode== Activity.RESULT_OK){
            val intent=result.data

            val imageBitmap=intent?.extras?.get("data") as Bitmap

            binding.ivImagenCam.setImageBitmap(imageBitmap)

        }
    }


}
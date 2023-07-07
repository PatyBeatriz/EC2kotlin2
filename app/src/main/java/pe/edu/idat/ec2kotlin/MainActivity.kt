package pe.edu.idat.ec2kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import pe.edu.idat.ec2kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(vista: View) {
        when(vista.id){
            R.id.btnLogin->login()
        }

    }

    private fun login(){

        if (binding.edtCorreo.text.toString()=="patricia@idat.edu.pe"&&
                binding.edtPasword.text.toString()=="123456"){
            startActivity(Intent(applicationContext,MenuActivity::class.java))

        }else{
            Toast.makeText(applicationContext, "Usuario o Password Incorrecto", Toast.LENGTH_SHORT).show();
        }


    }
}
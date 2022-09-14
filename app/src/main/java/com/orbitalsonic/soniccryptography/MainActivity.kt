package com.orbitalsonic.soniccryptography

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.orbitalsonic.soniccryptography.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        onClickMethods()
    }

    private fun onClickMethods(){

        binding.btnDecrypt.setOnClickListener {
            if (validateText()) {
                val encData = SonicCryptography.decryptMessage(
                    binding.etMessageText.text.toString(),
                    binding.etKeyText.text.toString()
                )
                binding.tvResult.text = encData
            }
        }
        binding.btnEncrypt.setOnClickListener {
            if (validateText()) {
                val encData = SonicCryptography.encryptMessage(
                    binding.etMessageText.text.toString(),
                    binding.etKeyText.text.toString()
                )
                binding.tvResult.text = encData
                Log.d("myInformation",encData)
            } else {
                showToast("Fields Empty!")
            }
        }

    }

    private fun validateText(): Boolean {
        val isKeyCorrect: Boolean
        val textMessage: String =
            binding.etMessageText.text.toString()
        val textKey: String =
            binding.etKeyText.text.toString()

        if (textMessage.isEmpty() || textKey.isEmpty()) {
            showToast("Field can't be empty")
            return false
        }

        if (textKey.length != 16) {
            showToast("Key must contains 16 characters")
            return false
        } else {
            isKeyCorrect = true
        }

        return (isKeyCorrect && textMessage.isNotEmpty())
    }

    private fun showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

}
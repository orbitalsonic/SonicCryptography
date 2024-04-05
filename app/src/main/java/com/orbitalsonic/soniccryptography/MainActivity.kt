package com.orbitalsonic.soniccryptography

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * @Author: Muhammad Yaqoob
 * @Date: 29,March,2024.
 * @Accounts
 *      -> https://github.com/orbitalsonic
 *      -> https://www.linkedin.com/in/myaqoob7
 */
class MainActivity : AppCompatActivity() {
    private lateinit var etMessageText:EditText
    private lateinit var etKeyText:EditText
    private lateinit var tvResult:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etMessageText = findViewById(R.id.etMessageText)
        etKeyText = findViewById(R.id.etKeyText)
        tvResult = findViewById(R.id.tv_result)

        onClickMethods()
    }

    private fun onClickMethods(){

        findViewById<TextView>(R.id.btn_decrypt).setOnClickListener {
            if (validateText()) {
                val encData = SonicCryptography.decryptMessage(
                    etMessageText.text.toString(),
                    etKeyText.text.toString()
                )
                tvResult.text = encData
            }
        }
        findViewById<TextView>(R.id.btn_encrypt).setOnClickListener {
            if (validateText()) {
                val encData = SonicCryptography.encryptMessage(
                    etMessageText.text.toString(),
                    etKeyText.text.toString()
                )
                tvResult.text = encData
                Log.d("myInformation",encData)
            } else {
                showToast("Fields Empty!")
            }
        }

    }

    private fun validateText(): Boolean {
        val isKeyCorrect: Boolean
        val textMessage: String =
            etMessageText.text.toString()
        val textKey: String =
            etKeyText.text.toString()

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
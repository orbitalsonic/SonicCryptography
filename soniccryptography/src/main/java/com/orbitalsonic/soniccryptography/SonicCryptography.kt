package com.orbitalsonic.soniccryptography

import android.util.Base64
import android.util.Log
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class SonicCryptography {

    companion object {
        private const val INIT_VECTOR = "encryptionIntVec"
        private const val TAG = "SonicCryptography"

        fun encryptMessage(message: String, key: String): String {
            val encryptedMessage: String = try {
                val iv = IvParameterSpec(INIT_VECTOR.toByteArray(charset("UTF-8")))
                val skeySpec = SecretKeySpec(key.toByteArray(charset("UTF-8")), "AES")
                val cipher: Cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv)
                val encrypted: ByteArray = cipher.doFinal(message.toByteArray())
                Base64.encodeToString(encrypted, Base64.DEFAULT)
            } catch (ex: Exception) {
                Log.e(TAG, "${ex.message}")
                ex.message.toString()
            }
            return encryptedMessage
        }

        fun decryptMessage(message: String, key: String): String {
            val decryptedMessage: String = try {
                val iv = IvParameterSpec(INIT_VECTOR.toByteArray(charset("UTF-8")))
                val skeySpec = SecretKeySpec(key.toByteArray(charset("UTF-8")), "AES")
                val cipher: Cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv)
                val original: ByteArray = cipher.doFinal(Base64.decode(message, Base64.DEFAULT))
                String(original)
            } catch (ex: Exception) {
                Log.e(TAG, "${ex.message}")
                ex.message.toString()
            }
            return decryptedMessage
        }
    }
}
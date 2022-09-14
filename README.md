[![](https://jitpack.io/v/orbitalsonic/SonicCryptography.svg)](https://jitpack.io/#orbitalsonic/SonicCryptography)
# SonicCryptography
Cryptography, or cryptology, is the practice and study of techniques for secure communication in the presence of adversarial behavior. More generally, cryptography is about constructing and analyzing protocols that prevent third parties or the public from reading private messages

# Add Gradle Files

###### Add following lines in project gradle file or settings.gralde file

```
repositories {
    google()
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

```

###### Add following dependency in app gradle file

```
  implementation 'com.github.orbitalsonic:SonicCryptography:1.0.1'
 
 ```
 
  # Example
           val myEncryptedMessage = SonicCryptography.encryptMessage(message,key)
           val myDecryptedMessage = SonicCryptography.decryptMessage(message,key)

# Note
Key must be 16 characters

# Screenshots
![alt text](https://github.com/orbitalsonic/SonicCryptography/blob/master/Screenshots/Screenshot_1.jpg?raw=true)

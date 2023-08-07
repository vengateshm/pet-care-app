package dev.vengateshm.petcareapp.platform

interface PreferenceProvider {
    fun getString(key: String): String
    fun putString(key: String, value: String)

    companion object {
        const val KEY_TOKEN = "kToken"
        const val KEY_USER = "kUser"
        const val KEY_USER_NAME = "kUserName"
    }
}
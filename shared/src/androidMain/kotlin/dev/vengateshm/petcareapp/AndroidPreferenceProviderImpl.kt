package dev.vengateshm.petcareapp

import android.content.Context
import dev.vengateshm.petcareapp.platform.PreferenceProvider

class AndroidPreferenceProviderImpl(private val context: Context) : PreferenceProvider {
    override fun getString(key: String): String {
        return context.getSharedPreferences("", Context.MODE_PRIVATE).getString(key, "") ?: ""
    }

    override fun putString(key: String, value: String) {
        context.getSharedPreferences("", Context.MODE_PRIVATE)
            .also {
                val editor = it.edit()
                editor.putString(key, value)
                editor.apply()
            }
    }
}
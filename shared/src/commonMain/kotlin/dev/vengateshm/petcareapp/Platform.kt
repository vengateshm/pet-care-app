package dev.vengateshm.petcareapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
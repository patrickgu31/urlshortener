package com.service

import jakarta.inject.Singleton
import java.net.URI

@Singleton
class UrlShortenerService {
    fun shortenUrl(url: URI): String {
        if (url.scheme != "http" && url.scheme != "https") {
            throw IllegalArgumentException("Only Http/Https URL are supported")
        }
        return url.toString()
    }

    fun generateUniqueRandomKey() {

    }

    fun generateRandomKey(){
    }
}
package com.service

import jakarta.inject.Singleton

@Singleton
class UrlShortenerService {
    fun shortenUrl(url: String): String {
        return url
    }
}
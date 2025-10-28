package com.service

import io.micronaut.context.annotation.Value
import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URI
import kotlin.random.Random

@Singleton
class UrlShortenerService {

    companion object{
        private val logger: Logger = LoggerFactory.getLogger(UrlShortenerService::class.java)
        private val urlLength = 7
        private val alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    }

    @Value("\${url.shortener.prefix}") private val prefix: String? = null

    fun shortenUrl(url: URI): String {
        if (url.scheme != "http" && url.scheme != "https") {
            throw IllegalArgumentException("Only Http/Https URL are supported")
        }
        return generateRandomUrl()
    }

    private fun generateRandomUrl(): String {
        logger.info("Generating random url")
        val randomUrl = StringBuilder(urlLength)
        repeat(urlLength) {
            val index = Random.nextInt(alphabet.length)
            randomUrl.append(alphabet[index])
        }
        return "$prefix/$randomUrl"
    }
}
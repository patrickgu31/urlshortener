package com

import com.service.UrlShortenerService
import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import jakarta.inject.Inject
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.net.URI

@Controller("/urlshortener")
class UrlShortenerController (
    @Inject private val urlShortenerService: UrlShortenerService,
){
    companion object{
        private val logger: Logger = LoggerFactory.getLogger(UrlShortenerController::class.java)
    }
    @Get("/hello")
    fun hello(): String = "Hello from Micronaut!"

    @Get("/shorten/{url}")
    fun shorten(@PathVariable url: String): HttpResponse<Any>? {
        logger.info("shortening: $url")
        try  {
            val test = URI.create(url)
            test.toURL()
        } catch (e: IllegalArgumentException){
            return HttpResponse.badRequest("Invalid URL")
        }
        val urlToEncode = URI.create(url)
        val response = urlShortenerService.shortenUrl(urlToEncode)
        return HttpResponse.ok(response)
    }
}
package com

import com.service.UrlShortenerService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import jakarta.inject.Inject

@Controller("/urlshortener")
class UrlShortenerController (
    @Inject private val urlShortenerService: UrlShortenerService
){

    @Get("/hello")
    fun hello(): String = "Hello from Micronaut!"

    @Get("/shorten/{url}")
    fun shorten(@PathVariable url: String): HttpResponse<Any>? {
        urlShortenerService.shortenUrl(url)
        return HttpResponse.ok(url)
    }
}
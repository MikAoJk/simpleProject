package no.kartveit.api

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.mustache.MustacheContent
import io.ktor.request.receiveParameters
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import no.kartveit.model.InputDetails


fun Routing.registerInputApi() {
    get("/input") {
        call.respond(MustacheContent("input.hbs", null))
    }
    post("/input") {
        val parameters = call.receiveParameters()
        val name = parameters["name"]
        val age = parameters["age"]

        if (!name.isNullOrEmpty() && !age.isNullOrEmpty()) {
            val inputDetails = InputDetails(name, age)
            call.respond(MustacheContent("output.hbs", mapOf("InputDetails" to inputDetails)))
        } else {
            call.respondText("Missing name or age", status = HttpStatusCode.InternalServerError)
        }


    }
}
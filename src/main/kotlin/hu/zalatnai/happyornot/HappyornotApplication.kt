package hu.zalatnai.happyornot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HappyornotApplication

fun main(args: Array<String>) {
    runApplication<HappyornotApplication>(*args)
}

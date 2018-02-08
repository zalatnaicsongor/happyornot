package hu.zalatnai.happyornotproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HappyornotApplication

fun main(args: Array<String>) {
    runApplication<HappyornotApplication>(*args)
}

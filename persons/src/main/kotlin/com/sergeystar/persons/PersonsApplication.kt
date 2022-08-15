package com.sergeystar.persons

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PersonsApplication

fun main(args: Array<String>) {
	runApplication<PersonsApplication>(*args)
}

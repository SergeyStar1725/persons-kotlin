package com.sergeystar.persons.controllers

import com.sergeystar.persons.models.Person
import com.sergeystar.persons.repo.PersonRepo
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(description = "Контроллер для работы с persons.")
@RestController
@RequestMapping("/api/persons")
class PersonRestController(repo: PersonRepo) : AbstractRestController<Person, PersonRepo>(repo)
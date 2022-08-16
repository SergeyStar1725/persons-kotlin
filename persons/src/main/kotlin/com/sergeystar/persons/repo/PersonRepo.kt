package com.sergeystar.persons.repo

import com.sergeystar.persons.models.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepo: JpaRepository<Person, Long> {
}
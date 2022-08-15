package com.sergeystar.persons.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    var id: Long,
    var name: String,
    var surname: String,
    var patronymic: String,
    var email: String,
    var telephone: Int) {}

package com.sergeystar.persons.utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MyUtilsTest {

    @Test
    fun copyProps() {
        data class DataOne(var propA: String, var propB: String)

        val data1 = DataOne("a", "b")
        var data2 = DataOne("","")

        println("Before")
        println(data1)
        println(data2)
        // this copies all matching properties
        MyUtils().copyProps(data1, data2)
        println("After")
        println(data1)
        println(data2)
        assertEquals(data1, data2)

        println("Ignore \"propA\"")
        data2 = DataOne("","")
        val data3 = DataOne("", "b")
        MyUtils().copyProps(data1, data2, "propA")
        assertEquals(data2, data3)
    }
}
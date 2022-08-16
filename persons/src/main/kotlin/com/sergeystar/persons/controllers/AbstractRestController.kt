package com.sergeystar.persons.controllers

import com.sergeystar.persons.utils.MyUtils
import io.swagger.annotations.ApiOperation
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*

abstract class AbstractRestController<Any : kotlin.Any, R: JpaRepository<Any, Long>>(_repo: R) {

    protected val repo: R
    init {
        repo = _repo
    }

    @ApiOperation("получение списка элементов")
    @GetMapping
    fun getAll(@PageableDefault pageable: Pageable): List<Any>{
        return repo.findAll(pageable).content
    }

    @ApiOperation("получение одного элемента")
    @GetMapping("{id}")
    fun getOne(@PathVariable("id") dbObj: Any): Any{
        return dbObj
    }

    @ApiOperation("добавление одного элемента")
    @PostMapping
    open fun addOne(@RequestBody obj: Any): Any {
        return repo.save(obj)
    }

    @ApiOperation("изменение элемента")
    @PutMapping("{id}")
    open fun updateOne(@PathVariable("id") dbObj: Any, @RequestBody obj: Any): Any {
        MyUtils().copyProps(obj, dbObj, "id")
        return repo.save(dbObj)
    }

    @ApiOperation("удаление элемента")
    @DeleteMapping("{id}")
    open fun deleteOne(@PathVariable("id") dbObj: Any) {
        repo.delete(dbObj)
    }
}
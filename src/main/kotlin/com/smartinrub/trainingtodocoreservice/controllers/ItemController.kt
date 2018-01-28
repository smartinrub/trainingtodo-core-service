package com.smartinrub.trainingtodocoreservice.controllers

import com.smartinrub.trainingtodocoreservice.models.Item
import com.smartinrub.trainingtodocoreservice.repositories.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class ItemController {

    @Autowired
    lateinit var repository: ItemRepository

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @GetMapping("/{name}")
    fun findByName(@PathVariable name: String)
            = repository.findByName(name)

    @PostMapping("/")
    fun addItem(@Valid @RequestBody item: Item)
            = repository.save(item)

    @DeleteMapping("/{id}")
    fun deleteItemById(@PathVariable id: Long)
            = repository.delete(id)

}

package controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import repositories.ItemRepository

@RestController
class ItemController {

    @Autowired
    lateinit var repository: ItemRepository

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @GetMapping("/{name}")
    fun findByName(@PathVariable name: String)
            = repository.findByName(name)
}

package repositories

import models.Item
import org.springframework.data.repository.CrudRepository

interface ItemRepository : CrudRepository<Item, Long> {
    fun findByName(name: String): List<Item>
}

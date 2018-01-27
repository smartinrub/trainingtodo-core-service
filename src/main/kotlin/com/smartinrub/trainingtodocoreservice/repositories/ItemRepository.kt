package com.smartinrub.trainingtodocoreservice.repositories

import com.smartinrub.trainingtodocoreservice.models.Item
import org.springframework.data.repository.CrudRepository

interface ItemRepository : CrudRepository<Item, Long> {
    fun findByName(name: String): List<Item>
}

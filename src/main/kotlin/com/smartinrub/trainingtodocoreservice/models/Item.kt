package com.smartinrub.trainingtodocoreservice.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "items")
data class Item(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0,
        var name: String = ""
)

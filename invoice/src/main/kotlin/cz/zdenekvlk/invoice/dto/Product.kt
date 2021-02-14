package cz.zdenekvlk.invoice.dto

import java.time.LocalDate

data class Product(
    val sku: String,

    val name: String,

    val validFrom: LocalDate,

    val quantity: Int,

    val price: Double
)

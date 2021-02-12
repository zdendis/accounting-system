package cz.zdenekvlk.invoice.model

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private val id: Long,

    private val sku: String,

    private val name: String,

    private val validFrom: LocalDate,

    private val validTo: LocalDate,

    @OneToMany(mappedBy = "product")
    private val orderProducts: Set<OrderProduct> = hashSetOf()
)
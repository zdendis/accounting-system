package cz.zdenekvlk.invoice.model

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,

    val sku: String,

    val name: String,

    val validFrom: LocalDate,

    val validTo: LocalDate?,

    @OneToMany(mappedBy = "product")
    val orderProducts: Set<OrderProduct> = hashSetOf()
)
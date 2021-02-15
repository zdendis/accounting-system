package cz.zdenekvlk.invoice.model

import org.hibernate.annotations.NaturalId
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "product_sequence", allocationSize = 1)
    val id: Long? = null,

    @NaturalId
    val sku: String,

    val name: String,

    val validFrom: LocalDate,

    val validTo: LocalDate? = null,

    @OneToMany(mappedBy = "product", cascade = [CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST], orphanRemoval = true)
    val orderProducts: List<OrderProduct> = listOf()
)
package cz.zdenekvlk.invoice.model

import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import org.hibernate.annotations.NaturalId
import org.hibernate.annotations.NaturalIdCache
import java.time.LocalDate
import javax.persistence.*

@Entity
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = -1,

    @NaturalId
    val sku: String,

    val name: String,

    val validFrom: LocalDate,

    val validTo: LocalDate? = null,

    @OneToMany(mappedBy = "product", cascade = [CascadeType.PERSIST], orphanRemoval = true)
    val orderProducts: List<OrderProduct> = listOf()
)
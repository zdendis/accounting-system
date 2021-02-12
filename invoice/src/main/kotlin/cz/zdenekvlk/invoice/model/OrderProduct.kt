package cz.zdenekvlk.invoice.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(
    indexes = [
        Index(columnList = "order_id, product_id")
    ]
)
data class OrderProduct(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "order_id")
    val order: CustomerOrder,

    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: Product,

    val quantity: Int,

    val price: Double
) : Serializable
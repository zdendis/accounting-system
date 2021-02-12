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
    private val id: Long,

    @ManyToOne
    @JoinColumn(name = "order_id")
    private val order: CustomerOrder,

    @ManyToOne
    @JoinColumn(name = "product_id")
    private val product: Product,

    private val quantity: Int,

    private val price: Double
): Serializable
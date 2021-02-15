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
    @EmbeddedId
    val id: OrderProductId,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    var order: CustomerOrder? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    val product: Product,

    val quantity: Int,

    val price: Double
)

@Embeddable
data class OrderProductId(
    @Column(name = "order_id")
    val orderId: Long? = null,

    @Column(name = "product_id")
    val productId: Long? = null
): Serializable
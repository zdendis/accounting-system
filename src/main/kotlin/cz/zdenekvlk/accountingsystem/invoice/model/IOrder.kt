package cz.zdenekvlk.accountingsystem.invoice.model

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class IOrder(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private val id: Long,

    private val referenceNumber: Int,

    private val date: LocalDateTime,

    private val currency: String,

    @Embedded
    private val customer: Customer,

    @OneToMany(mappedBy = "orderId")
    private val products: List<OrderProduct>,

    @OneToOne
    private val invoice: Invoice
)

@Embeddable
data class Customer(
    private val customerId: Long,

    private val customerName: String,

//    @Embedded
    private val customerAddress: String
)

//@Embeddable
//data class Address(
//    private val street: String,
//    private val streetNumber: String,
//    private val postalCode: String,
//    private val city: String,
//    private val country: String
//)

@Entity
data class OrderProduct(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private val orderId: Long,

    @Id
    private val productId: Long,

    private val quantity: Int,

    private val price: Double
): Serializable

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private val id: Long,

    private val sku: String,

    private val name: String,

    @OneToMany(mappedBy = "productId")
    private val orders: List<OrderProduct>
)
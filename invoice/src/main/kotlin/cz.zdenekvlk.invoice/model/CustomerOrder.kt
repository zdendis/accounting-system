package cz.zdenekvlk.invoice.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CustomerOrder(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private val id: Long,

    private val referenceNumber: Int,

    private val date: LocalDateTime,

    private val currency: String,

    @Embedded
    private val customer: Customer,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    private val orderProducts: Set<OrderProduct> = hashSetOf(),

    @OneToOne(cascade = [CascadeType.ALL])
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


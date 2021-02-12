package cz.zdenekvlk.invoice.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Invoice(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,

    val invoiceNumber: String,

    val dateCreated: LocalDateTime,

    val dueDate: LocalDateTime,

    val paidDate: LocalDateTime,

    val accountNumber: String,

    val sellerAddress: String,

    val paid: Boolean,

    @OneToOne(mappedBy = "invoice")
    val order: CustomerOrder

)



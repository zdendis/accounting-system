package cz.zdenekvlk.accountingsystem.invoice.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Invoice (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private val id: Long,

    private val invoiceNumber: String,

    private val dateCreated: LocalDateTime,

    private val dueDate: LocalDateTime,

    private val accountNumber: String,

    private val sellerAddress: String,

    @OneToOne(mappedBy = "invoice")
    private val order: InOrder

)



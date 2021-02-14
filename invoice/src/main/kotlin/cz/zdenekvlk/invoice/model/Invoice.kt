package cz.zdenekvlk.invoice.model

import org.hibernate.Session
import org.hibernate.annotations.GeneratorType
import org.hibernate.tuple.ValueGenerator
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Invoice(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = -1,

    @GeneratorType(type = InvoiceNumberGenerator::class)
    val invoiceNumber: Long = 0,

    val dateCreated: LocalDateTime = LocalDateTime.now(),

    val dueDate: LocalDateTime,

    val paidDate: LocalDateTime? = null,

    val accountNumber: String,

    val sellerAddress: String,

    val paid: Boolean = false,

    @OneToOne(mappedBy = "invoice")
    val order: CustomerOrder? = null
) {
    class InvoiceNumberGenerator : ValueGenerator<Long> {
        override fun generateValue(session: Session, owner: Any): Long {
            val em = session.entityManagerFactory.createEntityManager()

            val query = em.createQuery("select max(invoiceNumber) from Invoice")
            val result = query.singleResult
            var invoiceNumberMax: Long? = result as Long?
            em.close()

            if(invoiceNumberMax == null) invoiceNumberMax = 1000000

            return invoiceNumberMax.inc()
        }
    }
}



package cz.zdenekvlk.invoice.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import org.hibernate.annotations.NaturalId
import org.hibernate.annotations.NaturalIdCache
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
data class CustomerOrder(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = -1,

    @NaturalId
    val referenceNumber: Long,

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer::class)
    @JsonSerialize(using = LocalDateTimeSerializer::class)
    val dateCreated: LocalDateTime = LocalDateTime.now(),

    val currency: String,

    val customerId: Long,

    val customerName: String,

    val customerAddress: String,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    val orderProducts: MutableList<OrderProduct> = mutableListOf(),

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    val invoice: Invoice
)
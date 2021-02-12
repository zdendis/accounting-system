package cz.zdenekvlk.invoice.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CustomerOrder(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null,

    var referenceNumber: Int = 0,

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer::class)
    @JsonSerialize(using = LocalDateTimeSerializer::class)
    var dateCreated: LocalDateTime = LocalDateTime.now(),

    var currency: String = "",

    var customerId: Long = 0,

    var customerName: String = "",

    var customerAddress: String = "",

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    var orderProducts: Set<OrderProduct> = hashSetOf(),

    @OneToOne(cascade = [CascadeType.ALL])
    var invoice: Invoice? = null
)
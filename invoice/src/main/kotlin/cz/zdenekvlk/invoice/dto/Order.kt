package cz.zdenekvlk.invoice.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import java.time.LocalDateTime


/*{
"referenceNumber": "{{$randomInt}}{{$randomInt}}",
"dateCreated": "2021-02-12T18:04:48",
"currency": "CZK",
"customerId": 1,
"customerName": "Jana Trolova",
"customerAddress": "Pranicova 5, 122 03, Praha 2",
"products": [
{
"sku": "{{$timestamp}}",
"name": "Product{{$timestamp}}",
"validFrom": "2020-10-14",
"quantity": 2,
"price": 26.5
},
{
"sku": "{{$timestamp}}",
"name": "Product{{$timestamp}}",
"validFrom": "2020-10-15",
"quantity": 5,
"price": 1205.0
}
]
}*/

open class Order(
    val referenceNumber: Long,

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer::class)
    @JsonSerialize(using = LocalDateTimeSerializer::class)
    val dateCreated: LocalDateTime,

    val currency: String,

    val customerId: Long,

    val customerName: String,

    val customerAddress: String,

    val products: List<Product>
)

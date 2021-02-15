package cz.zdenekvlk.invoice.service

import cz.zdenekvlk.invoice.dto.Order
import cz.zdenekvlk.invoice.dto.Product
import cz.zdenekvlk.invoice.repository.CustomerOrderRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit


@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = ["listeners=PLAINTEXT://localhost:9092", "port=9092"])
@ActiveProfiles("kafka")
class CustomerOrderConsumerServiceTest(
    @Autowired
    private val customerOrderRepository: CustomerOrderRepository,
    @Autowired
    private val consumer: CustomerOrderConsumerService,
    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, Order>,
    @Value("\${test.topic}")
    private val topic: String
) {
    @Test
    @Throws(Exception::class)
    fun simpleKafkaTest() {
        val order = Order(
            referenceNumber = 4569798,
            dateCreated = LocalDateTime.now(),
            currency = "CZK",
            customerId = 1232,
            customerName = "Jake Troller",
            customerAddress = "Street 1, Prague 5",
            products = listOf(
                Product(
                    sku = "3213213213",
                    name = "Product 1",
                    validFrom = LocalDate.now(),
                    quantity = 6,
                    price = 1254.99
                )
            )
        )
        kafkaTemplate.send(topic, order)
        consumer.latch.await(10000, TimeUnit.MILLISECONDS);

        assertEquals(0L,consumer.latch.count)
        assertNotNull(consumer.createdOrder)
        assertEquals(order.customerName, consumer.createdOrder?.customerName)
        val dbOrder = customerOrderRepository.findByReferenceNumber(order.referenceNumber)
        assertFalse(dbOrder.isEmpty)
    }
}
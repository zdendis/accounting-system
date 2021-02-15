package cz.zdenekvlk.invoice.service

import cz.zdenekvlk.invoice.dto.Order
import cz.zdenekvlk.invoice.model.CustomerOrder
import org.springframework.context.annotation.Profile
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.util.concurrent.CountDownLatch


@Profile("kafka")
@Service
class CustomerOrderConsumerService(
    private val customerOrderService: CustomerOrderService
) {
    val latch = CountDownLatch(1)
    var createdOrder: CustomerOrder? = null

    @KafkaListener(topics = ["\${test.topic}"])
    fun saveOrderListener(order: Order) {
        createdOrder = customerOrderService.createOrUpdateOrder(order)
        latch.countDown()
    }
}
package cz.zdenekvlk.invoice.service

import cz.zdenekvlk.invoice.dto.Order
import cz.zdenekvlk.invoice.model.*
import cz.zdenekvlk.invoice.repository.CustomerOrderRepository
import cz.zdenekvlk.invoice.repository.OrderProductRepository
import cz.zdenekvlk.invoice.repository.ProductRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
@Transactional
class CustomerOrderService(
    private val customerOrderRepository: CustomerOrderRepository,
    private val orderProductRepository: OrderProductRepository,
    private val productRepository: ProductRepository,
    @Value("\${seller.account.number}")
    private val accountNumber: String,
    @Value("\${seller.address}")
    private val sellerAddress: String,
    @Value("\${invoice.duedate.period}")
    private val dueDatePeriod: Long
) {
    fun saveOrder(order: Order): CustomerOrder {
        val createdOrder = customerOrderRepository.save(
            CustomerOrder(
                referenceNumber = order.referenceNumber,
                currency = order.currency,
                customerId = order.customerId,
                customerName = order.customerName,
                customerAddress = order.customerAddress,
                invoice = Invoice(
                    accountNumber = accountNumber,
                    sellerAddress = sellerAddress,
                    dueDate = LocalDateTime.now().plusDays(dueDatePeriod)
                )
            )
        )

        val orderProducts: List<OrderProduct> = order.products.map {
            if(productRepository.existsBySku(it.sku)) {
                val product = productRepository.findBySku(it.sku).get()
                OrderProduct(
                    id = OrderProductId(createdOrder.id, product.id),
                    product = product,
                    quantity = it.quantity,
                    price = it.price,
                    order = createdOrder
                )
            } else {
                val product = productRepository.save(
                    Product(
                        sku = it.sku,
                        name = it.name,
                        validFrom = it.validFrom
                    )
                )
                OrderProduct(
                    id = OrderProductId(createdOrder.id, product.id),
                    quantity = it.quantity,
                    price = it.price,
                    order = createdOrder,
                    product = product
                )
            }
        }

        orderProductRepository.saveAll(orderProducts)

        return createdOrder
    }
}
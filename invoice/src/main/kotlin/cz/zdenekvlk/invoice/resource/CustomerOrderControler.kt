package cz.zdenekvlk.invoice.resource

import cz.zdenekvlk.invoice.dto.Order
import cz.zdenekvlk.invoice.model.CustomerOrder
import cz.zdenekvlk.invoice.repository.CustomerOrderRepository
import cz.zdenekvlk.invoice.repository.OrderProductRepository
import cz.zdenekvlk.invoice.repository.ProductRepository
import org.springframework.beans.BeanUtils
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.Link
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@RepositoryRestController
class CustomerOrderControler(
    private val customerOrderRepository: CustomerOrderRepository,
    private val orderProductRepository: OrderProductRepository,
    private val productRepository: ProductRepository
) {

    @PostMapping(value = ["/customerOrders"])
    fun createOrder(@RequestBody order: Order): EntityModel<CustomerOrder> {

        // Start the affordance with the "self" link, i.e. this method.
        val createdOrderLink: Link = linkTo(methodOn(CustomerOrderControler::class.java).createOrder(order)).withSelfRel()

        val customerOrder: CustomerOrder = CustomerOrder()
        BeanUtils.copyProperties(order, customerOrder)

        //TODO
//        save into DB
        return EntityModel.of(customerOrder)
    }
}

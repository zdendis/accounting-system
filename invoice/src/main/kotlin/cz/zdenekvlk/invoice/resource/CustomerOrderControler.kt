package cz.zdenekvlk.invoice.resource

import cz.zdenekvlk.invoice.dto.Order
import cz.zdenekvlk.invoice.service.CustomerOrderService
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.hateoas.EntityModel
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RepositoryRestController
class CustomerOrderControler(
    private val customerOrderService: CustomerOrderService
) {

    @PostMapping(value = ["/customerOrders"])
    fun createOrder(@RequestBody order: Order, persistentEntityResourceAssembler: PersistentEntityResourceAssembler): EntityModel<Any> =
        persistentEntityResourceAssembler.toFullResource(customerOrderService.saveOrder(order))
}

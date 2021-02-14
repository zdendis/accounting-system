package cz.zdenekvlk.invoice.resource

import cz.zdenekvlk.invoice.dto.Order
import cz.zdenekvlk.invoice.service.CustomerOrderService
import org.springframework.data.rest.webmvc.PersistentEntityResource
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.web.bind.annotation.*

@RestController
@RepositoryRestController
class CustomerOrderControler(
    private val customerOrderService: CustomerOrderService
) {

    @GetMapping(value = ["/customerOrders"])
    fun getOrders(persistentEntityResourceAssembler: PersistentEntityResourceAssembler) : CollectionModel<PersistentEntityResource> =
        persistentEntityResourceAssembler.toCollectionModel(customerOrderService.getOrders())

    @GetMapping(value = ["/customerOrders/{id}"])
    fun getOrder(@PathVariable id: Long, persistentEntityResourceAssembler: PersistentEntityResourceAssembler) : EntityModel<Any> =
        persistentEntityResourceAssembler.toFullResource(customerOrderService.getOrder(id))

    @PostMapping(value = ["/customerOrders"])
    fun createOrder(@RequestBody order: Order, persistentEntityResourceAssembler: PersistentEntityResourceAssembler): EntityModel<Any> =
        persistentEntityResourceAssembler.toFullResource(customerOrderService.saveOrder(order))

    @PutMapping(value = ["/customerOrders/{id}"])
    fun updateOrder(@PathVariable id: Long, @RequestBody order: Order, persistentEntityResourceAssembler: PersistentEntityResourceAssembler): EntityModel<Any> =
        persistentEntityResourceAssembler.toFullResource(customerOrderService.updateOrder(id, order))

    @DeleteMapping(value = ["/customerOrders/{id}"])
    fun deleteOrder(@PathVariable id: Long, persistentEntityResourceAssembler: PersistentEntityResourceAssembler): EntityModel<Any> =
        persistentEntityResourceAssembler.toFullResource(customerOrderService.deleteOrder(id))
}

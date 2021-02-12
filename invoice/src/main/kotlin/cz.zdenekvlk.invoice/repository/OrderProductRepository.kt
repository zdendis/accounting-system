package cz.zdenekvlk.invoice.repository

import cz.zdenekvlk.invoice.model.OrderProduct
import cz.zdenekvlk.invoice.model.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@Repository
@RepositoryRestResource(exported = false)
interface OrderProductRepository : CrudRepository<OrderProduct, Product>
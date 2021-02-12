package cz.zdenekvlk.invoice.repository

import cz.zdenekvlk.invoice.model.OrderProduct
import cz.zdenekvlk.invoice.model.Product
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(exported = false)
interface OrderProductRepository : PagingAndSortingRepository<OrderProduct, Product>
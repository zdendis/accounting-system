package cz.zdenekvlk.invoice.repository

import cz.zdenekvlk.invoice.model.OrderProduct
import cz.zdenekvlk.invoice.model.OrderProductId
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@Repository
@RepositoryRestResource(exported = false)
interface OrderProductRepository : PagingAndSortingRepository<OrderProduct, OrderProductId>
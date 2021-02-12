package cz.zdenekvlk.invoice.repository

import cz.zdenekvlk.invoice.model.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product, Long> {
    @RestResource(exported = false)
    override fun deleteById(id: Long)
    @RestResource(exported = false)
    override fun delete(product: Product)
    @RestResource(exported = false)
    override fun deleteAll(products: MutableIterable<Product>)
    @RestResource(exported = false)
    override fun deleteAll()
}
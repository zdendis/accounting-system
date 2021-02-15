package cz.zdenekvlk.invoice.repository

import cz.zdenekvlk.invoice.model.Product
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository : PagingAndSortingRepository<Product, Long> {
    fun findBySku(sku: String): Optional<Product>

    fun existsBySku(sku: String): Boolean

    @RestResource(exported = false)
    override fun deleteById(id: Long)

    @RestResource(exported = false)
    override fun delete(product: Product)

    @RestResource(exported = false)
    override fun deleteAll(products: MutableIterable<Product>)

    @RestResource(exported = false)
    override fun deleteAll()
}
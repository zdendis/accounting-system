package cz.zdenekvlk.invoice.repository

import cz.zdenekvlk.invoice.model.CustomerOrder
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CustomerOrderRepository : PagingAndSortingRepository<CustomerOrder, Long> {
    fun findByReferenceNumber(referenceNumber: Long): Optional<CustomerOrder>
}
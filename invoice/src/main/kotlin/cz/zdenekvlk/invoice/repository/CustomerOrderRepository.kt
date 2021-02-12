package cz.zdenekvlk.invoice.repository

import cz.zdenekvlk.invoice.model.CustomerOrder
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerOrderRepository : PagingAndSortingRepository<CustomerOrder, Long>
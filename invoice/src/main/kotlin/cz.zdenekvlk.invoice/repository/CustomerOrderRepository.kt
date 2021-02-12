package cz.zdenekvlk.invoice.repository

import cz.zdenekvlk.invoice.model.CustomerOrder
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerOrderRepository : CrudRepository<CustomerOrder, Long>
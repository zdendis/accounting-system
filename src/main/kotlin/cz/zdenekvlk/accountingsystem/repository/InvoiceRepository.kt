package cz.zdenekvlk.accountingsystem.repository

import cz.zdenekvlk.accountingsystem.invoice.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository : JpaRepository<Invoice, Long>
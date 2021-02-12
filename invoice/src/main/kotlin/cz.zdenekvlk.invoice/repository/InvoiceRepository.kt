package cz.zdenekvlk.invoice.repository

import cz.zdenekvlk.invoice.model.Invoice
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository : CrudRepository<Invoice, Long> {
    @RestResource(exported = false)
    override fun <S : Invoice?> save(invoice: S): S
    @RestResource(exported = false)
    override fun <S : Invoice?> saveAll(invoices: MutableIterable<S>): MutableIterable<S>
    @RestResource(exported = false)
    override fun deleteById(id: Long)
    @RestResource(exported = false)
    override fun delete(invoice: Invoice)
    @RestResource(exported = false)
    override fun deleteAll(invoices: MutableIterable<Invoice>)
    @RestResource(exported = false)
    override fun deleteAll()

}
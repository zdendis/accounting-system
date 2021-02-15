package cz.zdenekvlk.invoice.resource

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import cz.zdenekvlk.invoice.dto.Order
import cz.zdenekvlk.invoice.service.CustomerOrderService
import cz.zdenekvlk.invoice.util.createTestDtoCurrencyAndAddressUpdatedOrder
import cz.zdenekvlk.invoice.util.createTestDtoForDeleteOrder
import cz.zdenekvlk.invoice.util.createTestDtoForUpdateOrder
import cz.zdenekvlk.invoice.util.createTestDtoOrder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
class CustomerOrderControlerTest(
    @Autowired
    private val mockMvc: MockMvc,
    @Autowired
    private val service: CustomerOrderService
) {
    private val mapper: ObjectMapper = jacksonObjectMapper()
    private val order: Order = createTestDtoOrder()
    private val orderSerialized: String = mapper.writeValueAsString(order)

    @Test
    fun createOrder() {
        val returnedOrder = mockMvc.perform(post("/customerOrders")
            .contentType(MediaType.APPLICATION_JSON)
            .content(orderSerialized))
            .andExpect(status().isOk)
            .andReturn()
            .response
            .contentAsString


        assertTrue(returnedOrder.contains(order.customerName))
    }

    @Test
    fun updateOrder() {
        val orderForUpdate = createTestDtoForUpdateOrder()
        val orderForUpdateInDb = service.createOrUpdateOrder(orderForUpdate)
        val orderCurrencyAndAddressUpdated = createTestDtoCurrencyAndAddressUpdatedOrder()

        val orderCurrencyUpdatedSerialized: String = mapper.writeValueAsString(orderCurrencyAndAddressUpdated)

        val returnedOrder = mockMvc.perform(put("/customerOrders/{id}", orderForUpdateInDb.id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(orderCurrencyUpdatedSerialized))
            .andExpect(status().isOk)
            .andReturn()
            .response
            .contentAsString


        assertTrue(returnedOrder.contains(orderCurrencyAndAddressUpdated.currency))
        assertTrue(returnedOrder.contains(orderCurrencyAndAddressUpdated.customerAddress))

    }

    @Test
    fun deleteOrder() {
        val orderForDelete = createTestDtoForDeleteOrder()
        val orderForDeleteInDb = service.createOrUpdateOrder(orderForDelete)

        mockMvc.perform(delete("/customerOrders/{id}", orderForDeleteInDb.id))
            .andExpect(status().is2xxSuccessful)

        val exception = assertThrows(NoSuchElementException::class.java) {
            orderForDeleteInDb.id?.let { service.getOrder(it) }
        }
        assertEquals("No value present", exception.message)
    }

}
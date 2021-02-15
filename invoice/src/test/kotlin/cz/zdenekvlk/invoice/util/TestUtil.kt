package cz.zdenekvlk.invoice.util

import cz.zdenekvlk.invoice.dto.Order
import cz.zdenekvlk.invoice.dto.Product
import java.time.LocalDate
import java.time.LocalDateTime

fun createTestDtoOrder() =
    Order(
        referenceNumber = 456979778,
        dateCreated = LocalDateTime.now(),
        currency = "CZK",
        customerId = 1232,
        customerName = "Jake Troller",
        customerAddress = "Street 1, Prague 5",
        products = listOf(
            Product(
                sku = "3213213213",
                name = "Product 1",
                validFrom = LocalDate.now(),
                quantity = 6,
                price = 1254.99
            ),
            Product(
                sku = "321000003",
                name = "Product 2",
                validFrom = LocalDate.now(),
                quantity = 2,
                price = 500.0
            )
        )
    )

fun createTestDtoForUpdateOrder() =
    Order(
        referenceNumber = 55555555,
        dateCreated = LocalDateTime.now(),
        currency = "CZK",
        customerId = 1232,
        customerName = "Jake Troller2",
        customerAddress = "Street 2, Prague 5",
        products = listOf(
            Product(
                sku = "3213213266",
                name = "Product 3",
                validFrom = LocalDate.now(),
                quantity = 6,
                price = 1254.99
            ),
            Product(
                sku = "321000077",
                name = "Product 4",
                validFrom = LocalDate.now(),
                quantity = 2,
                price = 500.0
            )
        )
    )

fun createTestDtoForDeleteOrder() =
    Order(
        referenceNumber = 555556666,
        dateCreated = LocalDateTime.now(),
        currency = "CZK",
        customerId = 1232,
        customerName = "Jake Troller2",
        customerAddress = "Street 2, Prague 5",
        products = listOf(
            Product(
                sku = "3213213266",
                name = "Product 3",
                validFrom = LocalDate.now(),
                quantity = 6,
                price = 1254.99
            ),
            Product(
                sku = "321000077",
                name = "Product 4",
                validFrom = LocalDate.now(),
                quantity = 2,
                price = 500.0
            )
        )
    )

fun createTestDtoCurrencyAndAddressUpdatedOrder() =
    Order(
        referenceNumber = 55555555,
        dateCreated = LocalDateTime.now(),
        currency = "USD",
        customerId = 1232,
        customerName = "Jake Troller2",
        customerAddress = "Street 2666, Prague 5",
        products = listOf(
            Product(
                sku = "3213213266",
                name = "Product 3",
                validFrom = LocalDate.now(),
                quantity = 6,
                price = 1254.99
            ),
            Product(
                sku = "321000077",
                name = "Product 4",
                validFrom = LocalDate.now(),
                quantity = 2,
                price = 500.0
            )
        )
    )

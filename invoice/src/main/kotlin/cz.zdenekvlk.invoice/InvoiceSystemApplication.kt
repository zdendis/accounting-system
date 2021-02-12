package cz.zdenekvlk.invoice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class InvoiceSystemApplication

fun main(args: Array<String>) {
    runApplication<InvoiceSystemApplication>(*args)
}

package cz.zdenekvlk.invoice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.hateoas.config.EnableHypermediaSupport

@SpringBootApplication
@EnableHypermediaSupport(type = [EnableHypermediaSupport.HypermediaType.HAL])
class InvoiceSystemApplication

fun main(args: Array<String>) {
    runApplication<InvoiceSystemApplication>(*args)
}

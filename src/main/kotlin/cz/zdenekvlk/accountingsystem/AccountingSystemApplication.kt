package cz.zdenekvlk.accountingsystem

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AccountingSystemApplication

fun main(args: Array<String>) {
    runApplication<AccountingSystemApplication>(*args)
}

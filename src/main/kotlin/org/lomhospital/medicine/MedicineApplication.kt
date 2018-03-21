package org.lomhospital.medicine

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MedicineApplication

fun main(args: Array<String>) {
    runApplication<MedicineApplication>(*args)
}

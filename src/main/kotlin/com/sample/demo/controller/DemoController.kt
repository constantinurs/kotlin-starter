package com.sample.demo.controller

import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.time.Instant.now

@RestController
class DemoController(private val demoRepository: DemoRepository) {


    @PostMapping(path = ["/demo"])
    fun hello(): DemoEntity {
        val savedEntity = demoRepository.save(DemoEntity())
        println("Saved entity with id=${savedEntity.id}")
        return savedEntity
    }
}

@Entity(name = "demo_entity")
data class DemoEntity(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,
    val timestamp: Instant = now(),
)

@Repository
interface DemoRepository : CrudRepository<DemoEntity, Long>

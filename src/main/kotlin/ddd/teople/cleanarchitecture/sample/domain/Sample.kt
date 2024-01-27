package ddd.teople.cleanarchitecture.sample.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "sample")
class Sample(
    var name: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id : Long? = null
) {
    fun updateName(name: String) {
        this.name = name
    }
}
package com.anyulled.jpademo.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Cacheable
@Entity
data class Husband(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val name: String = "",
        @OneToOne(mappedBy = "husband", fetch = FetchType.LAZY)
        @JsonManagedReference
        var wife: Wife? = null
) {
    override fun toString(): String {
        return "[$id: $name ${wife?.name}]"
    }
}
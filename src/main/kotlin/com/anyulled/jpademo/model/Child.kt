package com.anyulled.jpademo.model

import javax.persistence.*

@Cacheable
@Entity
data class Child(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        val name: String = "",

        @ManyToOne
        @JoinColumn(name = "mother_id")
        var mother: Wife? = null
) {
    override fun toString(): String {
        return "[$id: $name ${mother?.name}]"
    }
}
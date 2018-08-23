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
        var mother: Wife
) {
    override fun toString(): String {
        return "[$id: $name ${mother.name}]"
    }
}
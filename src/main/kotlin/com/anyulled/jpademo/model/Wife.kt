package com.anyulled.jpademo.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Cacheable
@Entity
data class Wife(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val name: String = "",
        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "husband_id")
        @JsonBackReference
        var husband: Husband? = null
) {
    override fun toString(): String {
        return "[$id: $name ${husband?.name}]"
    }
}

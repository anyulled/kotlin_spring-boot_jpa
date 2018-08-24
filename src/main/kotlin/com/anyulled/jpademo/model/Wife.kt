package com.anyulled.jpademo.model

import com.fasterxml.jackson.annotation.JsonBackReference
import org.springframework.data.jpa.domain.AbstractPersistable_.id
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
        var husband: Husband? = null,

        @OneToMany
        var children: MutableCollection<Child>? = null
) {
    override fun toString(): String {
        return "[$id: $name ${husband?.name}]"
    }

    fun addChild(child1: Child) {
        children?.add(child1)
    }
}

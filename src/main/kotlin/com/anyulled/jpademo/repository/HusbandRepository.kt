package com.anyulled.jpademo.repository

import com.anyulled.jpademo.model.Husband
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HusbandRepository: JpaRepository<Husband, Long>
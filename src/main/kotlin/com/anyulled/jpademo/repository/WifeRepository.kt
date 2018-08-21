package com.anyulled.jpademo.repository

import com.anyulled.jpademo.model.Wife
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WifeRepository: JpaRepository<Wife, Long>
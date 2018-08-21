package com.anyulled.jpademo

import com.anyulled.jpademo.model.Husband
import com.anyulled.jpademo.model.Wife
import com.anyulled.jpademo.repository.HusbandRepository
import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension

private val logger = KotlinLogging.logger {}

@ExtendWith(SpringExtension::class)
@DataJpaTest
class HusbandRepositoryTest(@Autowired val husbandRepository: HusbandRepository, @Autowired val entityManager: TestEntityManager) {

    @Test
    fun `save and get husband by id`() {
        logger.info { "saving wife will increase sequence to 2" }
        val wife = Wife(0, "Wife", null)
        entityManager.persistAndFlush(wife)
        logger.info { "saving husband with persisted wife" }
        val husband = Husband(0, "Husband", wife)
        entityManager.persistAndFlush(husband)

        val foundHusband = husbandRepository.findById(2L)
        assertThat(foundHusband.get()).isEqualTo(husband)
    }
}
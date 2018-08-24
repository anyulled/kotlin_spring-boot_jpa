package com.anyulled.jpademo.service

import com.anyulled.jpademo.model.Child
import com.anyulled.jpademo.model.Husband
import com.anyulled.jpademo.model.Wife
import com.anyulled.jpademo.repository.HusbandRepository
import com.anyulled.jpademo.repository.WifeRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class HusbandWifeService(val husbandRepository: HusbandRepository, val wifeRepository: WifeRepository) {

    fun saveHusband(husband: Husband): Husband {
        logger.info("persisting husband")
        val wife = husband.wife
        if (wife != null) {
            logger.info { "wife present. Persisting" }
            wife.husband = husband
            val persistedWife = wifeRepository.save(wife)
            logger.info { "persisted wife $persistedWife" }
            logger.info { "updating husband" }
            husband.wife = persistedWife
            logger.info { "husband updated $husband" }
        }
        husbandRepository.save(husband)
        return husband
    }

    fun saveWife(wife: Wife): Wife {
        val persistedWife = wifeRepository.save(wife)
        val husband = wife.husband
        if (husband != null) {
            husband.wife = persistedWife
            val persistedHusband = husbandRepository.save(husband)
            persistedWife.husband = persistedHusband
            wifeRepository.save(persistedWife)
        }
        return persistedWife
    }

    fun getHusbands(): List<Husband> = husbandRepository.findAll()

    fun getWives(): List<Wife> = wifeRepository.findAll()

    fun getHusband(id: Long): Husband = husbandRepository.getOne(id)

    fun getWife(id: Long): Wife = wifeRepository.getOne(id)
}
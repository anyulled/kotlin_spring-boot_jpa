package com.anyulled.jpademo.controller

import com.anyulled.jpademo.model.Husband
import com.anyulled.jpademo.model.Wife
import com.anyulled.jpademo.service.HusbandWifeService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/api")
class HusbandWifeController(private val husbandWifeService: HusbandWifeService) {

    @PostConstruct
    fun initialize() {
        val husband = Husband(0, "Husband", null)
        husbandWifeService.saveHusband(husband)
        val wife = Wife(0, "Wife", null)
        husbandWifeService.saveWife(wife)
    }

    @GetMapping("/wives")
    fun getWives(): List<Wife> = husbandWifeService.getWives()

    @GetMapping("/husbands")
    fun getHusbands(): List<Husband> = husbandWifeService.getHusbands()

    @GetMapping("/husbands/{id}")
    fun getHusband(@PathVariable id:Long) = husbandWifeService.getHusband(id)

    @GetMapping("/wives/{id}")
    fun getWife(@PathVariable id: Long): Wife = husbandWifeService.getWife(id)

    @PostMapping("/husband")
    fun saveHusband(@RequestBody husband: Husband): Husband = husbandWifeService.saveHusband(husband)

    @PostMapping("/wife")
    fun saveWife(@RequestBody wife: Wife): Wife = husbandWifeService.saveWife(wife)
}
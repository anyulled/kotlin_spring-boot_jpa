package com.anyulled.jpademo.controller

import com.anyulled.jpademo.model.Husband
import com.anyulled.jpademo.model.Wife
import com.anyulled.jpademo.service.HusbandWifeService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import mu.KotlinLogging
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/api")
@Api(value = "husbandWife", description = "Operations pertaining the Husband / Wife Repository")
class HusbandWifeController(private val husbandWifeService: HusbandWifeService) {

    @PostConstruct
    fun initialize() {
        logger.info { "initializing controller" }
        val husband = Husband(0, "Husband", null)
        husbandWifeService.saveHusband(husband)
        val wife = Wife(0, "Wife", null)
        husbandWifeService.saveWife(wife)
    }

    /**
     * Shows a list of wives from the database
     * @return a list of [Wife]
     */
    @GetMapping("/wives", produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    @ApiOperation("view a list of wives")
    fun getWives(): List<Wife> = husbandWifeService.getWives()

    /**
     * Shows a list of husbands from the database
     * @return a List of [Husband]
     */
    @GetMapping("/husbands", produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    @ApiOperation("view a list of husbands")
    fun getHusbands(): List<Husband> = husbandWifeService.getHusbands()

    /**
     * Gets a husband by its id
     * @param id [Long] identifier
     * @return the [Husband] found
     */
    @GetMapping("/husbands/{id}", produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    @ApiOperation("view a Husband by its id")
    fun getHusband(@PathVariable id: Long) = husbandWifeService.getHusband(id)

    /**
     * Get wife by its id
     * @param id [Long] identifier
     * @return the [Wife] on the database
     */
    @GetMapping("/wives/{id}", produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    @ApiOperation("view a Wife by its id")
    fun getWife(@PathVariable id: Long): Wife = husbandWifeService.getWife(id)

    /**
     * saves a [Husband] on the database
     * @param husband [Husband] input husband
     * @return the [husband] found on the DB
     */
    @PostMapping("/husband", produces = [MediaType.APPLICATION_JSON_UTF8_VALUE], consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    @ApiOperation("save a Husband")
    fun saveHusband(@RequestBody husband: Husband): Husband = husbandWifeService.saveHusband(husband)

    /**
     * saves a wife
     * @param wife [Wife] the wife object
     * @return the [Wife] saved
     */
    @PostMapping("/wife", produces = [MediaType.APPLICATION_JSON_UTF8_VALUE], consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    @ApiOperation("save a Husband")
    fun saveWife(@RequestBody wife: Wife): Wife = husbandWifeService.saveWife(wife)
}
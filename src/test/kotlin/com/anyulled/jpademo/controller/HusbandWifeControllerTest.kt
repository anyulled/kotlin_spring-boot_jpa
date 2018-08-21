package com.anyulled.jpademo.controller

import com.anyulled.jpademo.model.Husband
import com.anyulled.jpademo.model.Wife
import com.anyulled.jpademo.repository.HusbandRepository
import com.anyulled.jpademo.repository.WifeRepository
import com.anyulled.jpademo.service.HusbandWifeService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@WebMvcTest
internal class HusbandWifeControllerTest(@Autowired val mockMvc: MockMvc) {

    private val mapper = jacksonObjectMapper()

    @MockBean
    private lateinit var husbandWifeService: HusbandWifeService

    @MockBean
    private lateinit var husbandRepository: HusbandRepository

    @MockBean
    private lateinit var wifeRepository: WifeRepository

    @Test
    fun `get wives`() {
        val wives = listOf(Wife(1L, "Wife 1", null), Wife(2L, "Wife 2", null), Wife(3L, "Wife 3", null))
        given(wifeRepository.findAll()).willReturn(wives)
        given(husbandWifeService.getWives()).willReturn(wives)

        mockMvc.perform(get("/api/wives").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                //.andDo { println(it.response.contentAsString) }
                .andExpect(jsonPath("\$.[0].name").value("Wife 1"))
                .andExpect(jsonPath("\$.[1].name").value("Wife 2"))
                .andExpect(jsonPath("\$.[2].name").value("Wife 3"))
    }

    @Test
    fun `get husbands`() {
        val husbands = listOf(Husband(1L, "Husband 1", null), Husband(2L, "Husband 2", null), Husband(3L, "Husband 3", null))
        given(husbandRepository.findAll()).willReturn(husbands)
        given(husbandWifeService.getHusbands()).willReturn(husbands)

        mockMvc.perform(get("/api/husbands").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                //.andDo { println(it.response.contentAsString) }
                .andExpect(jsonPath("\$.[0].name").value("Husband 1"))
                .andExpect(jsonPath("\$.[1].name").value("Husband 2"))
                .andExpect(jsonPath("\$.[2].name").value("Husband 3"))
    }

    @Test
    fun `get husband`() {
        val husband = Husband(3L, "Husband 3", null)
        given(husbandRepository.getOne(ArgumentMatchers.anyLong())).willReturn(husband)
        given(husbandWifeService.getHusband(ArgumentMatchers.anyLong())).willReturn(husband)

        mockMvc.perform(get("/api/husbands/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                //.andDo { println(it.response.contentAsString) }
                .andExpect(jsonPath("\$.name").value("Husband 3"))
                .andExpect(jsonPath("\$.id").value("3"))
    }

    @Test
    fun `get wife`() {
        val wife = Wife(3L, "Wife 3", null)
        given(wifeRepository.getOne(ArgumentMatchers.anyLong())).willReturn(wife)
        given(husbandWifeService.getWife(ArgumentMatchers.anyLong())).willReturn(wife)

        mockMvc.perform(get("/api/wives/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                //.andDo { println(it.response.contentAsString) }
                .andExpect(jsonPath("\$.name").value("Wife 3"))
                .andExpect(jsonPath("\$.id").value("3"))

    }

    @Test
    fun `save husband`() {
        val husband = Husband(1L, "husband", null)
        given(husbandWifeService.saveHusband(husband)).willReturn(husband)
        mockMvc.perform(post("/api/husband").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(mapper.writeValueAsString(husband)))
                .andExpect(status().isOk)
        //.andDo { println(it.response.contentAsString) }
    }

    @Test
    fun `save wife`() {
        val wife = Wife(1L, "husband", null)
        given(husbandWifeService.saveWife(wife)).willReturn(wife)
        mockMvc.perform(post("/api/wife").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(mapper.writeValueAsString(wife)))
                .andExpect(status().isOk)
        //.andDo { println(it.response.contentAsString) }
    }
}
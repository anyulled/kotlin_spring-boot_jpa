package com.anyulled.jpademo.service

import com.anyulled.jpademo.model.Husband
import com.anyulled.jpademo.model.Wife
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito.given
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
internal class HusbandWifeServiceTest {

    @MockBean
    private lateinit var husbandWifeService: HusbandWifeService

    @Test
    fun saveWife() {
        val persistedWife = Wife(1L, "wife", null)
        given(husbandWifeService.saveWife(Wife(0, "wife", null))).willReturn(persistedWife)
        assertThat(husbandWifeService.saveWife(Wife(0, "wife", null))).isEqualTo(persistedWife)
    }

    @Test
    fun saveHusband() {
        val persistedHusband = Husband(1L, "husband", null)
        given(husbandWifeService.saveHusband(Husband(0, "husband", null))).willReturn(persistedHusband)
        assertThat(husbandWifeService.saveHusband(Husband(0, "husband", null))).isEqualTo(persistedHusband)
    }

    @Test
    fun getHusbands() {
        val husbands = listOf(Husband(1L, "Husband 1", null), Husband(2L, "husband 2", null))
        given(husbandWifeService.getHusbands()).willReturn(husbands)
        assertThat(husbandWifeService.getHusbands()).isEqualTo(husbands)
    }

    @Test
    fun getWives() {
        val wives = listOf(Wife(1L, "Wife 1", null), Wife(2L, "Wife 2", null))
        given(husbandWifeService.getWives()).willReturn(wives)
        assertThat(husbandWifeService.getWives()).isEqualTo(wives)
    }

    @Test
    fun getHusband() {
        val expectedHusband = Husband(1L, "husband", null)
        given(husbandWifeService.getHusband(ArgumentMatchers.anyLong())).willReturn(expectedHusband)
        assertThat(husbandWifeService.getHusband(1)).isEqualTo(expectedHusband)
    }

    @Test
    fun getWife() {
        val expectedWife = Wife(1L, "Wife", null)
        given(husbandWifeService.getWife(ArgumentMatchers.anyLong())).willReturn(expectedWife)
        assertThat(husbandWifeService.getWife(1)).isEqualTo(expectedWife)
    }
}
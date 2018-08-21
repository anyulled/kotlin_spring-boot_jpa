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
    fun `save wife`() {
        val persistedWife = Wife(1L, "wife", null)
        given(husbandWifeService.saveWife(Wife(0, "wife", null))).willReturn(persistedWife)
        assertThat(husbandWifeService.saveWife(Wife(0, "wife", null))).isEqualTo(persistedWife)
    }

    @Test
    fun `save wife with husband`() {
        val wifeWithHusband = Wife(1L, "wife with husband", Husband(2L, "husband", null))
        given(husbandWifeService.saveWife(wifeWithHusband)).willReturn(wifeWithHusband)
        assertThat(husbandWifeService.saveWife(wifeWithHusband)).isEqualTo(wifeWithHusband)
    }

    @Test
    fun `save husband`() {
        val persistedHusband = Husband(1L, "husband", null)
        given(husbandWifeService.saveHusband(Husband(0, "husband", null))).willReturn(persistedHusband)
        assertThat(husbandWifeService.saveHusband(Husband(0, "husband", null))).isEqualTo(persistedHusband)
    }

    @Test
    fun `save husband with wife`() {
        val husbandWithWife = Husband(1L, "husband with wife", Wife(2L, "wife", null))
        given(husbandWifeService.saveHusband(husbandWithWife)).willReturn(husbandWithWife)
        assertThat(husbandWifeService.saveHusband(husbandWithWife)).isEqualTo(husbandWithWife)
    }

    @Test
    fun `get husbands`() {
        val husbands = listOf(Husband(1L, "Husband 1", null), Husband(2L, "husband 2", null))
        given(husbandWifeService.getHusbands()).willReturn(husbands)
        assertThat(husbandWifeService.getHusbands()).isEqualTo(husbands)
    }

    @Test
    fun `get wives`() {
        val wives = listOf(Wife(1L, "Wife 1", null), Wife(2L, "Wife 2", null))
        given(husbandWifeService.getWives()).willReturn(wives)
        assertThat(husbandWifeService.getWives()).isEqualTo(wives)
    }

    @Test
    fun `get husband`() {
        val expectedHusband = Husband(1L, "husband", null)
        given(husbandWifeService.getHusband(ArgumentMatchers.anyLong())).willReturn(expectedHusband)
        assertThat(husbandWifeService.getHusband(1)).isEqualTo(expectedHusband)
    }

    @Test
    fun `get wife`() {
        val expectedWife = Wife(1L, "Wife", null)
        given(husbandWifeService.getWife(ArgumentMatchers.anyLong())).willReturn(expectedWife)
        assertThat(husbandWifeService.getWife(1)).isEqualTo(expectedWife)
    }
}
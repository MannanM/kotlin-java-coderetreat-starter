package com.mannanlive.www.coderetreat

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import org.junit.jupiter.api.Test

class KotlinSampleTest {

    @Test
    fun `this is an example test`() {
        KotlinSample() shouldNotBeSameInstanceAs KotlinSample()
        1 + 1 shouldBe 2
    }

}

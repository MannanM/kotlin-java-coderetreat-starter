package com.mannanlive.www.coderetreat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleTest {

    @Test
    public void exampleTest() {
        assertThat(new Sample()).isNotEqualTo(new Sample());
        assertThat(1 + 1).isEqualTo(2);
    }

}

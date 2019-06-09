package com.baidu.df;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClimbingStairsTest {

    @Test
    public void climbing() {
        assertEquals(1, ClimbingStairs.entry(1));
        assertEquals(2, ClimbingStairs.entry(2));
        assertEquals(3, ClimbingStairs.entry(3));
        assertEquals(5, ClimbingStairs.entry(4));
        assertEquals(8, ClimbingStairs.entry(5));
        assertEquals(13, ClimbingStairs.entry(6));
        assertEquals(21, ClimbingStairs.entry(7));
    }
}
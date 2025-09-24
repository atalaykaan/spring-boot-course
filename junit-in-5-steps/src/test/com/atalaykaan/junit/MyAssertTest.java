package test.com.atalaykaan.junit;

import main.com.atalaykaan.junit.MyMath;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyAssertTest {

    private List<String> list = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    void testAsserts() {

        assertTrue(list.contains("AWS"));
        assertFalse(list.contains("GCP"));

        assertArrayEquals(new int[] {1, 2}, new int[] {1, 2});

        assertEquals(3, list.size());

    }
}
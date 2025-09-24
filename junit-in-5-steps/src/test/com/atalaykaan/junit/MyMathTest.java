package test.com.atalaykaan.junit;

import main.com.atalaykaan.junit.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    private MyMath myMath = new MyMath();

    @Test
    void calculateSum_ThreeMemberArray() {

        assertEquals(7, myMath.calculateSum(new int[] {1, 2, 3}));
    }

    @Test
    void calculateSum_ZeroMemberArray() {

        assertEquals(0, myMath.calculateSum(new int[] {}));
    }
}
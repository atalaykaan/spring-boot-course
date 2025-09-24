package main.com.atalaykaan.junit;

public class MyMath {

    public int calculateSum(int[] numbers) {

        int sum= 0;

        for(int i = 0; i < numbers.length; i++) {

            sum += numbers[i];
        }

        return sum;
    }
}
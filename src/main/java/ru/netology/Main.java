package ru.netology;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final int ARRAY_SIZE = 100_000_000;

    public static void main(String[] args) {
        int[] array = initArray();
        getArraySum(array);
        gerArraySumForkJoinPool(array);
    }

    private static int[] initArray() {
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
        }
        return array;
    }

    private static void getArraySum(int[] array) {
        System.out.println("Начинаю простое вычисление суммы.");
        long timeBeforeStart = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Сумма всех чисел массива = " + sum);
        long timeAfterStart = System.currentTimeMillis();
        System.out.println("Закончил простое вычисление суммы. Время выполнения = " + (timeAfterStart - timeBeforeStart) + " миллисекунд.");
    }

    private static void gerArraySumForkJoinPool(int[] array) {
        System.out.println("Начинаю вычисление суммы с помощью ForkJoinPool");
        long timeBeforeStart = System.currentTimeMillis();
        System.out.println("Сумма всех чисел массива = " + new ForkJoinPool().invoke(new ArraySumTask(array)));
        long timeAfterStart = System.currentTimeMillis();
        System.out.println("Закончил вычисление суммы массива с помощью ForkJoinPool. Время выполнения = " + (timeAfterStart - timeBeforeStart) + " миллисекунд.");
    }
}



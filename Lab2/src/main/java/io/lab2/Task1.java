package io.lab2;

import io.lab2.util.CommonTask;

import java.util.Random;
import java.util.Scanner;

/// Задание 1. Работа с массивом (Вариант 5).
/// Заполните массив (тип элементов “int”) случайными числами и
/// выполните задание в соответствии со своим вариантом. Найти сумму положительных элементов массива.

public class Task1 implements CommonTask {

    public void run() {
        System.out.println("=== Задание 1: Сумма положительных элементов (Вариант 5) ===");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов массива (n): ");

        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка ввода: ожидалось целое число.");
            return;
        }

        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Количество элементов не может быть отрицательным.");
            return;
        }

        // Создаем массив типа int
        int[] array = new int[n];
        Random random = new Random();
        long sum = 0;

        // Заполняем массив случайными числами полного диапазона int
        // Ищем сумму положительных элементов
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(200001) - 100000;
            if (array[i] > 0) {
                sum += array[i];
            }
        }

        // Используем StringBuilder для быстрой сборки строки, чтобы не вызывать print много раз
        StringBuilder sb = new StringBuilder();
        sb.append("Сформированный массив: [");

        for (int i = 0; i < n; i++) {
            sb.append(array[i]);
            if (i < n - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        System.out.println(sb.toString());

        System.out.println("Результат: Сумма положительных элементов = " + sum);
    }
}
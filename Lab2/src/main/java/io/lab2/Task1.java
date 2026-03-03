package io.lab2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;

/// Задание 1. Работа с массивом (Вариант 5).
/// Заполните массив (тип элементов “int”) случайными числами и
/// выполните задание в соответствии со своим вариантом. Найти сумму положительных элементов массива.

public class Task1 {

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
            array[i] = random.nextInt();
            if (array[i] > 0) {
                sum += array[i];
            }
        }

        // Используем BufferedWriter для быстрой записи в консоль
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            writer.write("Сформированный массив: [");

            for (int i = 0; i < n; i++) {
                writer.write(String.valueOf(array[i]));
                if (i < n - 1) {
                    writer.write(", ");
                }

                if (i % 10000 == 0) writer.flush();
            }

            writer.write("]");
            writer.newLine();

            writer.write("Результат: Сумма положительных элементов = " + sum);
            writer.newLine();

            writer.flush();

        } catch (IOException e) {
            System.err.println("Ошибка при выводе данных: " + e.getMessage());
        }
    }
}
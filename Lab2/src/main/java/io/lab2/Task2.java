package io.lab2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/// Задание 2. Работа со списками (Вариант 5).
/// Заполните список (тип "ArrayList<Double>") случайными числами и отсортируйте его.
/// Метод сортировки: Сортировка вставками (Insertion Sort) - вручную.

public class Task2 {

    public void run() {
        System.out.println("=== Задание 2: Сортировка вставками (Вариант 5) ===");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов списка (n): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка ввода: ожидалось целое число.");
            return;
        }
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Количество элементов не может быть отрицательным.");
            return;
        }

        ArrayList<Double> list = new ArrayList<>(n);
        Random random = new Random();

        // Генерируем числа в диапазоне [-1000.0, 1000.0]
        for (int i = 0; i < n; i++) {
            double value = (random.nextDouble() * 2000.0) - 1000.0;
            list.add(value);
        }

        System.out.println("\nИсходный список:");
        printList(list);

        // Сортировка вставками
        // Алгоритм: берем элемент начиная со второго (i=1) и вставляем его
        // в правильную позицию среди уже отсортированной части слева (0..i-1).
        for (int i = 1; i < list.size(); i++) {
            Double currentElement = list.get(i);
            int j = i - 1;

            // Сдвигаем элементы, которые больше текущего, на одну позицию вправо
            while (j >= 0 && list.get(j) > currentElement) {
                list.set(j + 1, list.get(j));
                j--;
            }
            // Вставляем текущий элемент на освободившееся место
            list.set(j + 1, currentElement);
        }

        System.out.println("\nОтсортированный список (по возрастанию):");
        printList(list);

        System.out.println();
    }

    // Метод для вывода списка
    private void printList(ArrayList<Double> list) {
        // Используем StringBuilder для формирования строки,
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(String.format("%.2f", list.get(i)));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        // Выводим готовую строку
        System.out.println(sb.toString());
    }
}
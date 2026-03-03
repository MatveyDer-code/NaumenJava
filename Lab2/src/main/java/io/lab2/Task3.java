package io.lab2;

import io.lab2.util.Employee;
import io.lab2.util.CommonTask;

import java.util.ArrayList;
import java.util.List;

/// 2. Необходимо реализовать предзаполненный список (тип
/// “ArrayList<Employee>”) с объектами класса “Employee”
/// , по которым будем
/// выполняться задание. Необходимо создать не менее 5 элементов списка.
/// 3. Выполнить задание в соответствии с вашим вариантом.
/// Определить, есть ли хотя бы один сотрудник с зарплатой более 100000.00.
public class Task3 implements CommonTask {

    public void run() {
        System.out.println("=== Задание 3: Stream API ===");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ivan Ivanov", 30, "IT", 50000.0));
        employees.add(new Employee("Petr Petrov", 25, "HR", 45000.0));
        employees.add(new Employee("Anna Smirnova", 28, "IT", 110000.00));
        employees.add(new Employee("Olga Ivanova", 35, "Finance", 60000.0));
        employees.add(new Employee("Sergey Sidorov", 40, "Management", 70000.0));

        System.out.println("\nИсходный список сотрудников:");
        employees.forEach(System.out::println);

        // Проверяем, есть ли хотя бы один сотрудник с зарплатой > 100000.00
        boolean hasHighSalary = employees.stream()
                .anyMatch(e -> e.getSalary() > 100000.00);

        System.out.println("\nЕсть ли сотрудник с зарплатой > 100000.00? " + hasHighSalary);
    }
}

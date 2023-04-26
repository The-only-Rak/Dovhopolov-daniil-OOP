package ua.khpi.oop.Dovhopolov13;

import java.util.Arrays;
//Лаба 13 Паралельне виконання. Multithreading
//Мета∗
//	Ознайомлення з моделлю потоків Java.
//  Організація паралельного виконання декількох частин програми
//Зробленно Довгополовом Даніїлом
public class Task13 {
    static Integer res = 0;

    public static void main(String[] args) throws InterruptedException {
        Integer[] randomArray = new Integer[10000];

        // Заполнение массива значениями от 0 до 999999
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = i;
        }

        // Создание объекта ParallelIteratorProcessor для обработки данных в многопоточном режиме
        var pIP = new ParallelIteratorProcessor<Integer>(Arrays.asList(randomArray).iterator(),5,1000000);

        // Обработка данных с использованием многопоточности
        pIP.process((Integer i,Object lock)->{
            synchronized(lock) {
                res += i;
            }
        });

        // Вывод результата вычислений на экран
        System.out.println(res);
    }
}
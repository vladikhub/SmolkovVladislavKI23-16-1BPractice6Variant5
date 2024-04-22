/*
Смольков Владислав Андреевич КИ23-16/1б Практика 6 Вариант 5
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static boolean running = true;
  public static String type = null;
  public static Scanner sc = new Scanner(System.in);
  public static SingleLinkedList<String> stringList;
  public static SingleLinkedList<Integer> intList;
  public static void main(String[] args) {
    // Выбор типа данных в списке
    String num;
    System.out.println("""
        Выберете тип данных коллекции:
        1 - String
        2 - Integer
        """);
    type = sc.nextLine();
    switch (type) {
      case "1":
        stringList = new SingleLinkedList<>();
        break;
      case "2":
        intList = new SingleLinkedList<>();
        break;
      default:
        System.out.println("Нужно ввести число от 1 до 2");
        type = sc.nextLine();
    }
    // Запуск меню
    while (running){
      System.out.println("""
          ___МЕНЮ___
          1. Проверить, список пуст/нет
          2. Установить указатель в начало списка
          3. Добавить элемент за указателем
          4. Удалить элемент за указателем
          5. Просмотреть элемент за указателем
          6. Переместить указатель вправо
          7. Обменять значения конца списка и элемента за указателем
          8. Обменять значения начала списка и элемента за указателем
          9. Вывод списка на экран
          10. Выход""");
      System.out.println("Выберете пункт: ");
      num = sc.nextLine();
      if (type.equals("1")){
        switch (num){
          case "10":
            // Завершение работы
            running = false;
            break;
          case "1":
            // проверка на пустой список
            if (stringList.isEmpty()){
              System.out.println("Список пуст");
            } else{
              System.out.println("Список не пуст");
            }
            break;
          case "2":
            // Установка указателя на начало
            stringList.setPointerAtStart();
            break;
          case "3":
            // Добавление элемента за указателем
            System.out.println("Введите новый элемент: ");
            stringList.addNext(sc.nextLine());
            break;
          case "4":
            // Удаление элемента за указателем
            stringList.removeNext();
            break;
          case "5":
            // Вывод элемента за указателем
            stringList.printNext();
            break;
          case "6":
            // Сдвиг указателя вправо
            stringList.replacePointerRight();
            break;
          case "7":
            // Обмен данных последнего и элемента за указателем
            stringList.exchangeLastAndNextData();
            break;
          case "8":
            // Обмен данных первого и элемента за указателем
            stringList.exchangeFirstAndNextData();
            break;
          case "9":
            stringList.printList();
            break;
          default:
            System.out.println("Введено неверное число");
        }
      } else{
        switch (num){
          case "10":
            // Завершение работы
            running = false;
            break;
          case "1":
            // проверка на пустой список
            if (intList.isEmpty()){
              System.out.println("Список пуст");
            } else{
              System.out.println("Список не пуст");
            }
            break;
          case "2":
            // Установка указателя на начало
            intList.setPointerAtStart();
            break;
          case "3":
            // Добавление элемента за указателем
            System.out.println("Введите новый элемент: ");
            int el = 0;
            try {
              el = sc.nextInt();
              intList.addNext(el);
            } catch (InputMismatchException ex){
              sc.nextLine();
              System.out.println("Нужно ввести число: ");
              el = sc.nextInt();
              intList.addNext(el);
            }
            sc.nextLine();
            break;
          case "4":
            // Удаление элемента за указателем
            intList.removeNext();
            break;
          case "5":
            // Вывод элемента за указателем
            intList.printNext();
            break;
          case "6":
            // Сдвиг указателя вправо
            intList.replacePointerRight();
            break;
          case "7":
            // Обмен данных последнего и элемента за указателем
            intList.exchangeLastAndNextData();
            break;
          case "8":
            // Обмен данных первого и элемента за указателем
            intList.exchangeFirstAndNextData();
            break;
          case "9":
            intList.printList();
            break;
          default:
            System.out.println("Введено неверное число");
        }
      }
    }
  }
}
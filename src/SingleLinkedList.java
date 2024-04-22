
public class SingleLinkedList<T> {
  /*
    Обобщенный класс, являющийся линейным однонаправленным списком
    Операции над списком:
    проверить, список пуст/не пуст;
    установить указатель в начало списка;
    добавить элемент за указателем;
    удалить элемент за указателем;
    просмотреть элемент за указателем;
    переместить указатель вправо;
    обменять значения конца списка и элемента за указателем;
    обменять значения начала списка и элемента за указателем;
    вывод списка на экран.
 */
  private Node<T> head; // голова списка
  private Node<T> pointer; // указатель списка

  public SingleLinkedList() {
    this.head = null;
    this.pointer = null;
  }

  public static class Node<T> {
    /*
    Класс (узел) который хранит информацию и ссылку на следующий узел
     */
    private T data;
    private Node<T> nextNode;
    public Node(T data){
      this.data = data;
      nextNode = null;
    }
  }

  /**
   * Метод добавления нового элемента после указателя
   * @param data
   */
  public void addNext(T data){
    Node<T> newNode = new Node<>(data);
    if (head == null){
      head = newNode;
      pointer = head;
      System.out.println("Элемент добавлен за указателем");
    } else{
      newNode.nextNode = pointer.nextNode;
      pointer.nextNode = newNode;
      System.out.println("Элемент добавлен за указателем");
    }
  }

  /**
   * Метод удаления элемента после указателя
   */
  public void removeNext(){
    if (pointer.nextNode == null){
      if (head == null) {
        System.out.println("Список пуст");
      } else{
        System.out.println("Указатель установлен в конце списка");
      }
    } else {
      pointer.nextNode = pointer.nextNode.nextNode;
      System.out.println("Элемент удален за указателем");

    }
  }

  /**
   * Метод вывода элемента за указателем
   */
  public void printNext(){
    if (head == null){
      System.out.println("Список пуст");
    } else if (pointer.nextNode == null) {
      System.out.println("null");
    }else {
      System.out.println(pointer.nextNode.data);
    }
  }

  /**
   * Метод сдвига указателя на один элемент вправо
   */
  public void replacePointerRight(){
    if (head == null){
      System.out.println("Список пуст");
    } else if (pointer.nextNode == null) {
      System.out.println("Указатель находится в конце списка");
    }else {
      pointer = pointer.nextNode;
      System.out.println("Указатель перемещен вправо");
    }
  }

  /**
   * Метод замены данных первого элемента и элемента за указателем
   */
  public void exchangeFirstAndNextData(){
    if (head == null){
      System.out.println("Список пуст");
    } else if (pointer.nextNode == null) {
      System.out.println("Указатель находится в конце списка");
    } else {
      T temp = head.data;
      head.data = pointer.nextNode.data;
      pointer.nextNode.data = temp;
      System.out.println("Значения успешно обменены");
    }
  }

  /**
   * Метод замены данных последнего элемента и элемента за указателем
   */
  public void exchangeLastAndNextData(){
    if (head == null){
      System.out.println("Список пуст");
    } else if (pointer.nextNode == null) {
      System.out.println("Указатель находится в конце списка");
    } else{
      Node<T> lastNode = head;
      while (lastNode.nextNode != null){
        lastNode = lastNode.nextNode;
      }
      if (pointer.nextNode == lastNode){
        System.out.println("Элемент за указателем является последним элементом");
      } else {
        T temp = lastNode.data;
        lastNode.data = pointer.nextNode.data;
        pointer.nextNode.data = temp;
        System.out.println("Значения успешно обменены");
      }
    }
  }

  /**
   * Проверка на пустой список
   * @return boolean
   */
  public boolean isEmpty(){
    return head == null;
  }

  /**
   * Метод вывода всех элементов на экран
   */
  public void printList(){
    if (head == null){
      System.out.println("Список пуст");
    }
    else {
      Node<T> currentNode = head;
      while (currentNode != null) {
        if (currentNode == pointer){
          System.out.print(currentNode.data + " (указатель) -> ");
        }else {
          System.out.print(currentNode.data + " -> ");
        }
        if (currentNode.nextNode == null) {
          System.out.println("null");
          break;
        }
        currentNode = currentNode.nextNode;
      }
    }
  }

  /**
   * Метод установки указателя на начало списка
   */
  public void setPointerAtStart(){
    if (head == null){
      System.out.println("Список пуст");
    } else {
      pointer = head;
      System.out.println("Указатель установлен вначало");
    }
  }
  
}

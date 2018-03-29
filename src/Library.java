//1. Сделать библиотеку, которая ведет учет книг. Должно быть как минимум два класса:
// Book и Library. Library имеет два метода: void put(Book book, int quantity) и
// int get(Book book, int quantity). Каждой книге в библиотеке соответствует счетчик,
// показывающий количество хранящихся книг, при добавлении книги - счетчик увеличивается,
// при извлечении - уменьшается на число quantity.
//Поля класса Book: author, title, pagesNum.
//Библиотека хранит ограниченное число книг, сколько - на ваше усмотрение.

public class Library {
   int c = 0;

    public void put (Book book, int quantity){
        if (this.c <= 100 && quantity <= 100) {
            c += quantity;
            book.value += quantity;
            System.out.println("Данного экземпляра в наличие " + book.value + " штук");
        } else System.out.println("Столько библиотека не вмещает");
     }

    public int get (Book book, int quantity){
        if (this.c > 0 && quantity <= book.value){
            c -= quantity;
            book.value -= quantity;
            System.out.println("Данного экземпляра осталось " + book.value + " штук");
        } else System.out.println("Такого количества нет");
        return quantity;
    }

    public static void main(String[] args) {
        Library Spb = new Library();
        Book print = new Book("Bob", "Start", 59);
        Spb.put(print, 40);
        Spb.get(print,39);
        Book comics = new Book("Pepe", "My little memes", 69);
        Spb.put(comics, 190);
        Spb.get(comics,36);
    }
}

class Book {
    String author;
    String title;
    int pagesNum;
    int value;
    public Book (String author, String title, int pagesNum){
        this.author = author;
        this.title = title;
        this.pagesNum = pagesNum;
    }
}

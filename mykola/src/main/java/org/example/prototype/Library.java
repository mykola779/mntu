package org.example.prototype;

// Клас, який представляє книгу та реалізує інтерфейс Cloneable
class Book implements Cloneable {
    private String title;
    private String author;
    private String genre;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void displayInfo() {
        System.out.println("Назва: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Жанр: " + genre);
    }

    // Метод клонування
    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

// Клас, який використовує прототип для створення книг
public class Library {
    public static void main(String[] args) {
        // Створюємо оригінальний об'єкт книги
        Book originalBook = new Book("Таємниці бібліотеки", "Іван Іванов", "Детектив");

        // Клонуємо оригінальний об'єкт за допомогою прототипу
        Book clonedBook = originalBook.clone();

        // Змінюємо деякі атрибути клонованого об'єкта
        clonedBook.setTitle("Нові таємниці бібліотеки");
        clonedBook.setAuthor("Петро Петров");
        clonedBook.setGenre("Фентезі");

        // Відображаємо інформацію про оригінальний об'єкт та клонований
        System.out.println("Оригінальний об'єкт:");
        originalBook.displayInfo();

        System.out.println("\nКлонований об'єкт:");
        clonedBook.displayInfo();
    }
}

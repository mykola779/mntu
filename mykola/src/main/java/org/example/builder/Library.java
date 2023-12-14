package org.example.builder;

// Клас, який представляє книгу
class Book {
    private String title;
    private String author;
    private String genre;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public void displayInfo() {
        System.out.println("Назва: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Жанр: " + genre);
    }
}

// Інтерфейс або абстрактний клас для будівництва книги
interface BookBuilder {
    void buildTitle(String title);
    void buildAuthor(String author);
    void buildGenre(String genre);
    Book getResult();
}

// Конкретний клас білдера для будівництва книги
class ConcreteBookBuilder implements BookBuilder {
    private String title;
    private String author;
    private String genre;

    @Override
    public void buildTitle(String title) {
        this.title = title;
    }

    @Override
    public void buildAuthor(String author) {
        this.author = author;
    }

    @Override
    public void buildGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public Book getResult() {
        return new Book(title, author, genre);
    }
}

// Клас, який використовує білдер для створення книги
class LibraryDirector {
    private BookBuilder bookBuilder;

    public LibraryDirector(BookBuilder bookBuilder) {
        this.bookBuilder = bookBuilder;
    }

    public void constructBook(String title, String author, String genre) {
        bookBuilder.buildTitle(title);
        bookBuilder.buildAuthor(author);
        bookBuilder.buildGenre(genre);
    }

    public Book getBook() {
        return bookBuilder.getResult();
    }
}

// Клас, який використовує паттерн Білдер
public class Library {
    public static void main(String[] args) {
        // Створюємо білдер для книги
        BookBuilder bookBuilder = new ConcreteBookBuilder();

        // Створюємо директора для використання білдера
        LibraryDirector libraryDirector = new LibraryDirector(bookBuilder);

        // Конструюємо книгу
        libraryDirector.constructBook("Таємниці бібліотеки", "Іван Іванов", "Детектив");

        // Отримуємо результат від білдера
        Book book = libraryDirector.getBook();

        // Відображаємо інформацію про книгу
        book.displayInfo();
    }
}

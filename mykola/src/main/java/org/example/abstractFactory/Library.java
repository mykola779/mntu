package org.example.abstractFactory;

// Абстрактний клас або інтерфейс для представлення книги
interface Book {
    void displayInfo();
}

// Два конкретних класи, що реалізують інтерфейс Book
class MysteryBook implements Book {
    @Override
    public void displayInfo() {
        System.out.println("Це книга з жанру детективу.");
    }
}

class FantasyBook implements Book {
    @Override
    public void displayInfo() {
        System.out.println("Це книга з жанру фентезі.");
    }
}

// Абстрактний клас або інтерфейс для фабрики створення книг
interface BookFactory {
    Book createBook();
}

// Два конкретних класи фабрик, що реалізують інтерфейс BookFactory
class MysteryBookFactory implements BookFactory {
    @Override
    public Book createBook() {
        return new MysteryBook();
    }
}

class FantasyBookFactory implements BookFactory {
    @Override
    public Book createBook() {
        return new FantasyBook();
    }
}

// Абстрактний клас або інтерфейс для фабрики створення книг та авторів
interface LibraryFactory {
    BookFactory createBookFactory();
    // Ще один метод для створення об'єкту Author, наприклад
    // Author createAuthor();
}

// Два конкретних класи фабрик для створення книг та авторів
class EnglishLibraryFactory implements LibraryFactory {
    @Override
    public BookFactory createBookFactory() {
        return new MysteryBookFactory();
    }

    // Реалізація методу створення автора може бути додана тут
}

class FantasyLibraryFactory implements LibraryFactory {
    @Override
    public BookFactory createBookFactory() {
        return new FantasyBookFactory();
    }

    // Реалізація методу створення автора може бути додана тут
}

// Клас, який використовує абстрактну фабрику для створення книг
public class Library {
    public static void main(String[] args) {
        // Вибираємо фабрику для англійської літератури
        LibraryFactory englishFactory = new EnglishLibraryFactory();
        // Використовуємо фабрику для створення книги
        BookFactory bookFactory = englishFactory.createBookFactory();
        // Створюємо книгу
        Book book = bookFactory.createBook();
        // Відображаємо інформацію про книгу
        book.displayInfo();
    }
}

package org.example.factoryMethod;

// Абстрактний клас або інтерфейс для представлення книги
interface Book {
    void displayInfo();
}

// Конкретна реалізація книги
class MysteryBook implements Book {
    @Override
    public void displayInfo() {
        System.out.println("Це книга з жанру детективу.");
    }
}

// Конкретна реалізація іншої книги
class FantasyBook implements Book {
    @Override
    public void displayInfo() {
        System.out.println("Це книга з жанру фентезі.");
    }
}

// Абстрактний клас або інтерфейс для фабричного методу
interface BookFactory {
    Book createBook();
}

// Конкретна реалізація фабричного методу для створення детективних книг
class MysteryBookFactory implements BookFactory {
    @Override
    public Book createBook() {
        return new MysteryBook();
    }
}

// Конкретна реалізація фабричного методу для створення книг у жанрі фентезі
class FantasyBookFactory implements BookFactory {
    @Override
    public Book createBook() {
        return new FantasyBook();
    }
}

// Клас, який використовує фабричний метод для створення книг
public class Library {
    public static void main(String[] args) {
        // Використовуємо фабричний метод для створення детективної книги
        BookFactory mysteryFactory = new MysteryBookFactory();
        Book mysteryBook = mysteryFactory.createBook();
        mysteryBook.displayInfo();

        // Використовуємо фабричний метод для створення книги у жанрі фентезі
        BookFactory fantasyFactory = new FantasyBookFactory();
        Book fantasyBook = fantasyFactory.createBook();
        fantasyBook.displayInfo();
    }
}


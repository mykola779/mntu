using System;

// Інтерфейс для створення об'єктів книг
interface IBook
{
    void Display();
}

// Конкретний клас книги
class MysteryBook : IBook
{
    public void Display()
    {
        Console.WriteLine("Це книга жанру Містика.");
    }
}

// Конкретний клас книги
class RomanceBook : IBook
{
    public void Display()
    {
        Console.WriteLine("Це книга жанру Романтика.");
    }
}

// Фабричний метод визначений у віддільному інтерфейсі
interface IBookFactory
{
    IBook CreateBook();
}

// Конкретна фабрика для створення книги жанру Містика
class MysteryBookFactory : IBookFactory
{
    public IBook CreateBook()
    {
        return new MysteryBook();
    }
}

// Конкретна фабрика для створення книги жанру Романтика
class RomanceBookFactory : IBookFactory
{
    public IBook CreateBook()
    {
        return new RomanceBook();
    }
}

class Program
{
    static void Main()
    {
        // Використання фабричних методів для створення об'єктів книг
        IBookFactory mysteryBookFactory = new MysteryBookFactory();
        IBook mysteryBook = mysteryBookFactory.CreateBook();
        mysteryBook.Display();

        IBookFactory romanceBookFactory = new RomanceBookFactory();
        IBook romanceBook = romanceBookFactory.CreateBook();
        romanceBook.Display();
    }
}

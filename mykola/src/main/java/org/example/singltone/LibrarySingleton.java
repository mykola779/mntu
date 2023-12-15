package org.example.singltone;

public class LibrarySingleton {
    // Єдиний екземпляр класу
    private static LibrarySingleton instance;

    // Приватний конструктор, щоб заборонити створення більше одного екземпляру
    private LibrarySingleton() {
        // Ініціалізація конструктора
    }

    // Метод для отримання єдиного екземпляру класу
    public static LibrarySingleton getInstance() {
        if (instance == null) {
            // Якщо екземпляр ще не створений, створюємо його
            instance = new LibrarySingleton();
        }
        return instance;
    }

    // Додаткові методи та властивості класу можуть бути додані тут
}
class Main{
    public static void main(String[] args) {
        // Отримуємо єдиний екземпляр класу LibrarySingleton
        LibrarySingleton library = LibrarySingleton.getInstance();

        // Використовуємо екземпляр класу
        System.out.println("Library instance created: " + library);

        // Отримуємо ще раз той же екземпляр класу
        LibrarySingleton anotherLibrary = LibrarySingleton.getInstance();

        // Порівнюємо два екземпляри, і вони повинні бути однаковими
        System.out.println("Are the instances the same? " + (library == anotherLibrary));
    }
}

package org.example.adapter;

public class LibraryClient {
    public static void main(String[] args) {
        // Створюємо екземпляр сторонньої бібліотеки
        ThirdPartyLibrary thirdPartyLibrary = new ThirdPartyLibrary();

        // Створюємо адаптер
        LibraryAdapter adapter = new Adapter(thirdPartyLibrary);

        // Викликаємо метод через адаптер
        adapter.request();
    }
}


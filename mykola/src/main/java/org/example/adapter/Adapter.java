package org.example.adapter;

public class Adapter implements LibraryAdapter {
    private ThirdPartyLibrary thirdPartyLibrary;

    public Adapter(ThirdPartyLibrary thirdPartyLibrary) {
        this.thirdPartyLibrary = thirdPartyLibrary;
    }

    @Override
    public void request() {
        // Викликаємо метод сторонньої бібліотеки з методу адаптера
        thirdPartyLibrary.thirdPartyRequest();
    }
}
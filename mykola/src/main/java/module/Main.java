package module;

class Car {
    private String brand;
    private String model;
    private int year;
    private String color;

    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }
}

interface CarBuilder {
    CarBuilder setBrand(String brand);
    CarBuilder setModel(String model);
    CarBuilder setYear(int year);
    CarBuilder setColor(String color);
    Car build();
}


class CarBuilderImpl implements CarBuilder {
    private String brand;
    private String model;
    private int year;
    private String color;

    @Override
    public CarBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public CarBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    @Override
    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public Car build() {
        return new Car(brand, model, year, color);
    }
}


class CarDirector {
    private CarBuilder carBuilder;

    public CarDirector(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car constructCar() {
        return carBuilder.setBrand("Toyota")
                .setModel("Camry")
                .setYear(2022)
                .setColor("Silver")
                .build();
    }
}


public class Main {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilderImpl();
        CarDirector carDirector = new CarDirector(carBuilder);

        Car car = carDirector.constructCar();
        System.out.println(car);
    }
}

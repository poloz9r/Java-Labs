// Glucometer.java
public class Glucometer {
    private String model;
    private double accuracy;

    // Конструктор по умолчанию
    public Glucometer() {
        this.model = "DefaultModel";
        this.accuracy = 0.0;
    }

    // Конструктор с параметрами
    public Glucometer(String model, double accuracy) {
        this.model = model;
        this.accuracy = accuracy;
    }

    // Геттер для модели
    public String getModel() {
        return model;
    }

    // Сеттер для модели
    public void setModel(String model) {
        this.model = model;
    }

    // Геттер для точности
    public double getAccuracy() {
        return accuracy;
    }

    // Сеттер для точности
    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    // Метод вычисления самой лучшей точности (пример)
    public double calculateBestAccuracy() {

        return accuracy;
    }
}

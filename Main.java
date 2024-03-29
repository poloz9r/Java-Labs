import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Glucometer[] glucometers = new Glucometer[5]; // Создание массива объектов
        String resultMessage = "";

        do {
            System.out.println("\nМеню:");
            System.out.println("1. Создать объекты");
            System.out.println("2. Отобразить значения свойств объектов");
            System.out.println("3. Изменить свойства объектов");
            System.out.println("4. Добавить объекты в массив");
            System.out.println("5. Удалить объекты из массива");
            System.out.println("6. Вычислить самую лучшую точность");
            System.out.println("7. Выход");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createObjects(glucometers);
                    break;
                case 2:
                    displayObjects(glucometers);
                    break;
                case 3:
                    modifyObjectProperties(glucometers);
                    break;
                case 4:
                    addObjectToArray(glucometers);
                    break;
                case 5:
                    removeObjectFromArray(glucometers);
                    break;
                case 6:
                    calculateBestAccuracy(glucometers);
                    break;
                case 7:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    break;
            }

            System.out.println("\n" + resultMessage);

        } while (choice != 7);
    }

    public static void createObjects(Glucometer[] glucometers) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < glucometers.length; i++) {
            System.out.println("Введите модель для глюкометра " + (i + 1) + ": ");
            String model = scanner.next();
            System.out.println("Введите точность для глюкометра " + (i + 1) + ": ");
            double accuracy = scanner.nextDouble();

            glucometers[i] = new Glucometer(model, accuracy);
        }
        System.out.println("Объекты успешно созданы и данные введены.");
    }

    public static void displayObjects(Glucometer[] glucometers) {
        System.out.println("---------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s |\n", "Индекс", "Модель", "Точность");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < glucometers.length; i++) {
            Glucometer glucometer = glucometers[i];
            if (glucometer != null) {
                System.out.printf("| %-10d | %-20s | %-10.2f |\n", i, glucometer.getModel(), glucometer.getAccuracy());
            }
        }
        System.out.println("---------------------------------------------------");
    }

    public static void modifyObjectProperties(Glucometer[] glucometers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер объекта для изменения свойств (0-4): ");
        int index = scanner.nextInt();
        if (index >= 0 && index < glucometers.length && glucometers[index] != null) {
            System.out.print("Введите новую модель: ");
            String newModel = scanner.next();
            System.out.print("Введите новую точность: ");
            double newAccuracy = scanner.nextDouble();

            glucometers[index].setModel(newModel);
            glucometers[index].setAccuracy(newAccuracy);
            System.out.println("Свойства объекта изменены.");
        } else {
            System.out.println("Неверный индекс объекта или объект не существует.");
        }
    }

    public static void addObjectToArray(Glucometer[] glucometers) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < glucometers.length; i++) {
            if (glucometers[i] == null) {
                System.out.println("Введите модель для нового глюкометра: ");
                String model = scanner.next();
                System.out.println("Введите точность для нового глюкометра: ");
                double accuracy = scanner.nextDouble();

                glucometers[i] = new Glucometer(model, accuracy);
                System.out.println("Объект успешно добавлен.");
                return;
            }
        }
        System.out.println("Массив объектов полон.");
    }

    public static void removeObjectFromArray(Glucometer[] glucometers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер объекта для удаления (0-4): ");
        int index = scanner.nextInt();
        if (index >= 0 && index < glucometers.length && glucometers[index] != null) {
            glucometers[index] = null;
            System.out.println("Объект успешно удален.");
        } else {
            System.out.println("Неверный индекс объекта или объект не существует.");
        }
    }

    public static void calculateBestAccuracy(Glucometer[] glucometers) {
        double bestAccuracy = 0.0;
        for (Glucometer glucometer : glucometers) {
            if (glucometer != null && glucometer.getAccuracy() > bestAccuracy) {
                bestAccuracy = glucometer.getAccuracy();
            }
        }
        System.out.println("Самая лучшая точность: " + bestAccuracy);
    }
}

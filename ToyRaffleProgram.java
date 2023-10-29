import java.io.*;

public class ToyRaffleProgram {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Добавляем игрушки в магазин
        toyStore.addToy(new Toy(1, "Кукла", 10, 20));
        toyStore.addToy(new Toy(2, "Мяч", 15, 30));
        toyStore.addToy(new Toy(3, "Конструктор", 5, 50));

        // Изменяем вес (частоту выпадения) игрушек
        toyStore.updateWeight(1, 15);
        toyStore.updateWeight(2, 25);
        toyStore.updateWeight(3, 60);

        // Розыгрыш игрушки
        Toy prizeToy = toyStore.getPrizeToy();

        if (prizeToy != null) {
            System.out.println("Выиграна игрушка: " + prizeToy.getName());

            // Записываем выигранную игрушку в файл с использованием правильной кодировки
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("prize.txt"), "UTF-8"))) {
                writer.write(prizeToy.getName());
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл.");
            }
        } else {
            System.out.println("Игрушки закончились.");
        }
    }
}

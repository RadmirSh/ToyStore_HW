import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        this.toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public Toy getPrizeToy() {
        int totalWeight = 0;

        // Вычисляем общий вес игрушек
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        // Генерируем случайное число в диапазоне от 0 до общего веса игрушек
        int randomNumber = (int) (Math.random() * totalWeight);

        // Находим игрушку, чей вес входит в диапазон случайного числа
        for (Toy toy : toys) {
            if (randomNumber < toy.getWeight()) {
                toy.setQuantity(toy.getQuantity() - 1);
                return toy;
            }
            randomNumber -= toy.getWeight();
        }

        // Если все игрушки закончились
        return null;
    }
}
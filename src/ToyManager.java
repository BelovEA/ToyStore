import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class ToyManager {
    private List<Toys> toys;
    private List<Toys> prizeToys;

    public ToyManager() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addToy(int id, String name, int quantity, int chanceToDrop) {
        Toys newToy = new Toys(id, name, quantity, chanceToDrop);
        toys.add(newToy);
    }

    public void selectPrizeToy() {
        double totalWeight = 0;
        for (Toys toy : toys) {
            totalWeight += toy.getChanceToDrop();
        }

        double randomWeight = Math.random() * totalWeight;
        double currentWeight = 0;

        for (Toys toy : toys) {
            currentWeight += toy.getChanceToDrop();
            if (currentWeight >= randomWeight) {
                prizeToys.add(toy);
                break;
            }
        }
    }

    public Toys getPrizeToy() {
        if (prizeToys.size() > 0) {
            Toys prizeToy = prizeToys.remove(0);
            writeToyToFile(prizeToy);
            return prizeToy;
        }
        return null;
    }

    private void writeToyToFile(Toys toy) {
        try (FileWriter writer = new FileWriter("prizeToys.txt", true)) {
            writer.write("ID: " + toy.getId() + ", Name: " + toy.getName() +
                    ", Quantity: " + toy.getQuantity() +
                    ", Chance to Drop: " + toy.getChanceToDrop() + "%\n");
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void displayToys() {
        for (Toys toy : toys) {
            System.out.println("ID: " + toy.getId() + ", Name: " + toy.getName() +
                    ", Quantity: " + toy.getQuantity());
        }
    }
}


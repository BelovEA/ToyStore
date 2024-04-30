//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ToyManager manager = new ToyManager();
        manager.addToy(1, "Teddy Bear", 100, 20);
        manager.addToy(2, "Lego Set", 50, 15);
        manager.addToy(3, "Rubber Duck", 200, 5);

        manager.selectPrizeToy();
        Toys prize = manager.getPrizeToy();
        if (prize != null) {
            System.out.println("Prize toy: " + prize.getName());
        }

        manager.displayToys();
    }
}


//pullrequest
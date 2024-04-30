import java.util.ArrayList;
import java.util.List;

public class Toys {
    private int id;
    private String name;
    private int quantity;
    private int chanceToDrop;

    public Toys(int id, String name, int quantity, int chanceToDrop) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.chanceToDrop = chanceToDrop;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getChanceToDrop() {
        return chanceToDrop;
    }
}


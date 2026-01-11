import java.util.List;
import java.util.Map;

class Product {
    private String name;
    private double price;

    private  int sku;


    Product(String name, double price, int sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }
}

class ProductFactory {
    public static Product createProduct(int sku) {
        // In reality product comes from DB
        String name;
        double price;

        if (sku == 101) {
            name  = "Apple";
            price = 20;
        }
        else if (sku == 102) {
            name  = "Banana";
            price = 10;
        }
        else if (sku == 103) {
            name  = "Chocolate";
            price = 50;
        }
        else if (sku == 201) {
            name  = "T-Shirt";
            price = 500;
        }
        else if (sku == 202) {
            name  = "Jeans";
            price = 1000;
        }
        else {
            name  = "Item" + sku;
            price = 100;
        }
        return new Product( name, price, sku);
    }
}

interface InventoryStore {
    void addProduct(Product prod, int qty);
    void removeProduct(int sku, int qty);
    int checkStock(int sku);
    List<Product> listAvailableProducts();
}

class DbinventoryStore implements InventoryStore {
    // Simulating DB operations
    @Override
    public void addProduct(Product prod, int qty) {
        System.out.println("DB: Added " + qty + " of " + prod.getName());
    }

    @Override
    public void removeProduct(int sku, int qty) {
        System.out.println("DB: Removed " + qty + " of SKU " + sku);
    }

    @Override
    public int checkStock(int sku) {
        System.out.println("DB: Checking stock for SKU " + sku);
        return 100; // Dummy stock
    }

    @Override
    public List<Product> listAvailableProducts() {
        System.out.println("DB: Listing all available products");
        return List.of(); // Dummy list
    }
}
class InventoryManager {
    private InventoryStore store;

    public InventoryManager(InventoryStore store) {
        this.store = store;
    }

    public void addStock(int sku, int qty) {
        Product prod = ProductFactory.createProduct(sku);
        store.addProduct(prod, qty);
        System.out.println("[InventoryManager] Added SKU " + sku + " Qty " + qty);
    }

    public void removeStock(int sku, int qty) {
        store.removeProduct(sku, qty);
    }

    public int checkStock(int sku) {
        return store.checkStock(sku);
    }

    public List<Product> getAvailableProducts() {
        return store.listAvailableProducts();
    }
}

interface ReplenishStrategy {
    void replenish(InventoryManager manager, Map<Integer,Integer> itemsToReplenish);
}

class ThresholdReplenishStrategy implements ReplenishStrategy {
    private int threshold;
    private int replenishQty;

    public ThresholdReplenishStrategy(int threshold, int replenishQty) {
        this.threshold = threshold;
        this.replenishQty = replenishQty;
    }

    @Override
    public void replenish(InventoryManager manager, Map<Integer, Integer> itemsToReplenish) {
        for (Map.Entry<Integer, Integer> entry : itemsToReplenish.entrySet()) {
            int sku = entry.getKey();
            int currentStock = entry.getValue();
            if (currentStock < threshold) {
                manager.addStock(sku, replenishQty);
                System.out.println("Replenished SKU " + sku + " by " + replenishQty);
            }
        }
    }
}

class DarkStore {
    private InventoryManager inventoryManager;
    private ReplenishStrategy replenishStrategy;

    public DarkStore(InventoryManager inventoryManager, ReplenishStrategy replenishStrategy) {
        this.inventoryManager = inventoryManager;
        this.replenishStrategy = replenishStrategy;
    }

    public void checkAndReplenish(Map<Integer, Integer> itemsToReplenish) {
        replenishStrategy.replenish(inventoryManager, itemsToReplenish);
    }
}

public class ZeptoClone {


}

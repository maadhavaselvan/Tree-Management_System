package Flora.Tree;
import Management.Sellable;
import Management.InvalidSaleException;
import Management.InvalidHarvestException;
public class FruitBearingTree extends Tree implements Sellable {

    private final String fruitName;
    private int stockKg;
    private final double pricePerKg;

    public FruitBearingTree(String name, String location, int age, double height, String fruitName, int stockKg, double pricePerKg) {
        super(name, location, age, height);
        this.fruitName = fruitName;
        this.stockKg = stockKg;
        this.pricePerKg = pricePerKg;
    }
    @Override
    public String getTreeType()
    {
        return "Fruit-Bearing Tree";
    }
    @Override
    public double getSalePrice()
    {
        return pricePerKg;
    }
    @Override
    public String getProductName()
    {
        return fruitName;
    }
    @Override
    public int getAvailableStock()
    {
        return stockKg;
    }
    public boolean isSellable() { return true; }
    @Override
    public void sell(int qty) throws InvalidSaleException {
        if (qty <= 0)
            throw new InvalidSaleException("Quantity must be > 0.");
        if (qty > stockKg)
            throw new InvalidSaleException("Stock insufficient. Available: " + stockKg + " kg.");
        stockKg -= qty;
        System.out.println("  Sold " + qty + " kg of " + fruitName + " @ Rs " + pricePerKg + "/kg  =  Rs " + (qty * pricePerKg));
    }

    public void harvest(int kg) throws InvalidHarvestException {
        if (kg <= 0)
            throw new InvalidHarvestException("Harvest must be > 0 kg.");
        stockKg += kg;
        System.out.println("  Harvested " + kg + " kg of " + fruitName + ". Total stock: " + stockKg + " kg.");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Fruit     : " + fruitName + "  Stock: " + stockKg + " kg  Price: Rs " + pricePerKg + "/kg");
    }
}
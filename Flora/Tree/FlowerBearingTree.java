package Flora.Tree;
import Management.Sellable;
import Management.InvalidSaleException;
public class FlowerBearingTree extends Tree implements Sellable {

    private final String flowerName;
    private int stockGarlands;
    private final double pricePerGarland;

    public FlowerBearingTree(String name, String location, int age, double height, String flowerName, int stockGarlands, double pricePerGarland)
    {
        super(name, location, age, height);
        this.flowerName = flowerName;
        this.stockGarlands = stockGarlands;
        this.pricePerGarland = pricePerGarland;
    }
    @Override
    public String getTreeType()
    {
        return "Flower-Bearing Tree";
    }
    @Override
    public double getSalePrice()
    {
        return pricePerGarland;
    }
    @Override
    public String getProductName()
    {
        return flowerName;
    }
    @Override
    public int getAvailableStock()
    {
        return stockGarlands;
    }
    @Override
    public void sell(int qty) throws InvalidSaleException {
        if (qty <= 0)
            throw new InvalidSaleException("Quantity must be > 0.");
        if (qty > stockGarlands)
            throw new InvalidSaleException(
                    "Only " + stockGarlands + " garlands of " + flowerName + " available.");
        stockGarlands -= qty;
        System.out.println("  Sold " + qty + " garlands of " + flowerName + " @ Rs " + pricePerGarland + " each  =  Rs " + (qty * pricePerGarland));
    }
    public boolean isSellable() { return true; }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Flower    : " + flowerName + "  Stock: " + stockGarlands + " garlands  Price: Rs " + pricePerGarland + "/garland");
    }
}
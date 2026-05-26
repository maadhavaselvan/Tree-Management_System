package Flora.LargeTree;
import Management.Sellable; 
import Management.InvalidSaleException;
public class FlowerBearingTree extends LargeTree implements Sellable {

    private final String flowerName;
    private       int    stockGarlands;
    private final double pricePerGarland;

    public FlowerBearingTree(String name, String location, int age, double height,
                              double canopy, String rootType,
                              String flowerName, int stockGarlands, double pricePerGarland) {
        super(name, location, age, height, canopy, rootType);
        this.flowerName      = flowerName;
        this.stockGarlands   = stockGarlands;
        this.pricePerGarland = pricePerGarland;
    }

    @Override public String getTreeType()     { return "Flower-Bearing Large Tree"; }
    @Override public double getSalePrice()    { return pricePerGarland; }
    @Override public String getProductName()  { return flowerName; }
    @Override public int    getAvailableStock(){ return stockGarlands; }

    @Override
    public void sell(int qty) throws InvalidSaleException {
        if (qty <= 0)           throw new InvalidSaleException("Quantity must be > 0.");
        if (qty > stockGarlands) throw new InvalidSaleException(
                "Only " + stockGarlands + " garlands of " + flowerName + " available.");
        stockGarlands -= qty;
        System.out.printf("  Sold %d garlands of %-12s @ Rs %.2f each  =  Rs %.2f%n",
                qty, flowerName, pricePerGarland, qty * pricePerGarland);
    }
    public boolean isSellable() { return true; }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("  Flower    : %-12s  Stock: %d garlands  Price: Rs %.2f/garland%n",
                flowerName, stockGarlands, pricePerGarland);
    }
}

package Flora.Plant;
import Management.Sellable;
import Management.InvalidSaleException;
public class FlowerBearingPlant extends Plant implements Sellable {

    private final String flowerName;
    private int stockBunches;
    private final double pricePerBunch;
    private final String bloomSeason;

    public FlowerBearingPlant(String name, String location, int age, double height, String species, boolean potted,
                              String flowerName, int stockBunches, double pricePerBunch, String bloomSeason) {
        super(name, location, age, height, species, potted);
        this.flowerName = flowerName;
        this.stockBunches = stockBunches;
        this.pricePerBunch = pricePerBunch;
        this.bloomSeason = bloomSeason;
    }
    @Override
    public String getTreeType()
    {
        return "Flower-Bearing Plant";
    }
    @Override
    public double getSalePrice()
    {
        return pricePerBunch;
    }
    @Override
    public String getProductName()
    {
        return flowerName;
    }
    @Override
    public int getAvailableStock()
    {
        return stockBunches;
    }
    @Override
    public String getCareInstructions() {
        return "Water daily; add compost weekly. Peak bloom: " + bloomSeason + ".";
    }
    @Override
    public void sell(int qty) throws InvalidSaleException {
        if (qty <= 0)
            throw new InvalidSaleException("Quantity must be > 0.");
        if (qty > stockBunches)
            throw new InvalidSaleException("Only " + stockBunches + " bunches of " + flowerName + " in stock.");
        stockBunches -= qty;
        System.out.println("  Sold " + qty + " bunches of " + flowerName + " @ Rs " + pricePerBunch + " each  =  Rs " + (qty * pricePerBunch));
    }
    public void bloom(int bunches) {
        stockBunches += bunches;
        System.out.println("  " + flowerName + " bloomed! +" + bunches + " bunches. Stock: " + stockBunches + ".");
    }
    public boolean isSellable() { return true; }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Flower : " + flowerName + "  Stock: " + stockBunches + " bunches  Price: Rs " + pricePerBunch + "/bunch");
        System.out.println("  Bloom : " + bloomSeason);
    }
}
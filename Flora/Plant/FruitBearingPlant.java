package Flora.Plant;
import Management.Sellable; 
import Management.InvalidSaleException; 
import Management.InvalidHarvestException;
public class FruitBearingPlant extends Plant implements Sellable {

    private final String fruitName;
    private       int    stockKg;
    private final double pricePerKg;
    private final int    harvestStart;   
    private final int    harvestEnd;

    public FruitBearingPlant(String name, String location, int age, double height,
                              String species, boolean potted,
                              String fruitName, int stockKg, double pricePerKg,
                              int harvestStart, int harvestEnd) {
        super(name, location, age, height, species, potted);
        this.fruitName    = fruitName;
        this.stockKg      = stockKg;
        this.pricePerKg   = pricePerKg;
        this.harvestStart = harvestStart;
        this.harvestEnd   = harvestEnd;
    }

    @Override public String getTreeType()     { return "Fruit-Bearing Plant"; }
    @Override public double getSalePrice()    { return pricePerKg; }
    @Override public String getProductName()  { return fruitName; }
    @Override public int    getAvailableStock(){ return stockKg; }
    public boolean isSellable() { return true; }

    @Override
    public String getCareInstructions() {
        return "Water every 2 days; fertilize monthly (months "
                + harvestStart + "–" + harvestEnd + ").";
    }

    @Override
    public void sell(int qty) throws InvalidSaleException {
        if (qty <= 0)      throw new InvalidSaleException("Quantity must be > 0.");
        if (qty > stockKg) throw new InvalidSaleException(
                "Only " + stockKg + " kg of " + fruitName + " available.");
        stockKg -= qty;
        System.out.printf("  Sold %d kg of %-12s @ Rs %.2f/kg  =  Rs %.2f%n",
                qty, fruitName, pricePerKg, qty * pricePerKg);
    }

    public void harvest(int kg) throws InvalidHarvestException {
        if (kg <= 0) throw new InvalidHarvestException("Harvest amount must be > 0.");
        stockKg += kg;
        System.out.println("  Harvested " + kg + " kg of " + fruitName
                + ". New stock: " + stockKg + " kg.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("  Fruit     : %-12s  Stock: %d kg  Price: Rs %.2f/kg%n",
                fruitName, stockKg, pricePerKg);
    }
}

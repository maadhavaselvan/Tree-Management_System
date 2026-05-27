package Flora.Plant;
import Management.InvalidSaleException;
import Management.InvalidHarvestException;
public class FruitBearingPlant extends Plant  {

    private final String fruitName;
    private int stockKg;
    private double pricePerKg;
    private final int harvestStart;
    private final int harvestEnd;

    public FruitBearingPlant(String name, String location, int age, double height, boolean potted,
                             String fruitName, int stockKg, double pricePerKg, int harvestStart, int harvestEnd) {
        super(name, location, age, height, potted);
        this.fruitName = fruitName;
        this.stockKg = stockKg;
        this.pricePerKg = pricePerKg;
        this.harvestStart = harvestStart;
        this.harvestEnd = harvestEnd;
    }

    @Override public String getTreeType()
    {
        return "Fruit-Bearing Plant";
    }
    @Override
    public String getCareInstructions() {
        return "Water every 2 days; fertilize monthly (months "+ harvestStart + " - " + harvestEnd + ").";
    }
    @Override
    public double getSalePrice()
    {
        if(newPrice!=0)
            return newPrice;
        return pricePerKg;
    }
        public void price()
    {
        pricePerKg=newPrice;
    }
    @Override public String getProductName()
    {
        return fruitName;
    }
    @Override public int getAvailableStock()
    {
        return stockKg;
    }
    @Override
    public void sell(int qty) throws InvalidSaleException {
        if (qty <= 0)
            throw new InvalidSaleException("Quantity must be > 0.");
        if (qty > stockKg)
            throw new InvalidSaleException("Only " + stockKg + " kg of " + fruitName + " available.");
        stockKg -= qty;
        System.out.println("  Sold " + qty + " kg of " + fruitName + " @ Rs " + pricePerKg + "/kg  =  Rs " + (qty * pricePerKg));
    }
    public boolean isSellable() {
        return true;
    }
    public void harvest(int kg) throws InvalidHarvestException {
        if (kg <= 0)
            throw new InvalidHarvestException("Harvest amount must be > 0.");
        stockKg += kg;
        System.out.println("  Harvested " + kg + " kg of " + fruitName + ". New stock: " + stockKg + " kg.");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Fruit : " + fruitName + "  Stock: " + stockKg + " kg  Price: Rs " + pricePerKg + "/kg");
    }
}
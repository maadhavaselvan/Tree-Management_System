package Flora.LargeTree;
import Management.Sellable; 
import Management.InvalidSaleException;
public class FlowerBearingTree extends LargeTree implements Sellable {

    private final String flowerName;
    private int stockGarlands;
    private final double pricePerGarland;

    public FlowerBearingTree(String name, String location, int age, double height,
                              double canopy, String rootType,
                              String flowerName, int stockGarlands, double pricePerGarland) {
        super(name, location, age, height, canopy, rootType);
        this.flowerName = flowerName;
        this.stockGarlands = stockGarlands;
        this.pricePerGarland = pricePerGarland;
    }

    public String getTreeType() 
    { 
        return "Flower-Bearing Large Tree"; 
    }
    public double getSalePrice() 
    { 
        return pricePerGarland; 
    }
    public String getProductName()
    { 
        return flowerName; 
    }
    public int getAvailableStock()
    { 
        return stockGarlands; 
    }

    public void sell(int qty) throws InvalidSaleException {
        if (qty <= 0) 
            throw new InvalidSaleException("Quantity must be > 0.");
        if (qty > stockGarlands) 
            throw new InvalidSaleException(
                "Only " + stockGarlands + " garlands of " + flowerName + " available.");
        stockGarlands -= qty;
        System.out.println("  Sold " + qty + " garlands of " + flowerName + " @ Rs " + pricePerGarland + " each  =  Rs " + (qty * pricePerGarland));
    }
    
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Flower    : " + flowerName + "  Stock: " + stockGarlands + " garlands  Price: Rs " + pricePerGarland + "/garland");
    }
}

package Flora;
import Management.Sellable;
import Management.Waterable;
import java.util.Scanner;
public abstract class Flora implements Waterable,Sellable {

    private final int treeId;
    private String name;
    private String location;
    private int ageYears;
    private double heightMeters;
    private static int idCounter = 0;
    protected double newPrice=0;
    public Flora(String name, String location, int ageYears, double heightMeters) {
        this.name = name;
        this.location = location;
        this.ageYears = ageYears;
        this.heightMeters = heightMeters;
        this.treeId = ++idCounter;
    }
    public abstract String getTreeType();
    public abstract String getCareInstructions();
    public abstract double estimatedGrowthPerYear();

    public void harvest(int amount) throws Management.InvalidHarvestException {
        throw new Management.InvalidHarvestException( getName() + " does not produce harvestable fruit.");
    }
    public void sell(int qty) throws Management.InvalidSaleException {
        throw new Management.InvalidSaleException(getName() + " has no sellable produce.");
    }
    
    public boolean isSellable(){ 
        return false; 
    }
    public String  getProductName(){ 
        return "";
    }
    public double  getSalePrice(){ 
        return 0.0;
    }
    public int getAvailableStock() { 
        return 0;
    }
    public void changeSalePrice()
    {
        System.out.print("Enter the price of product:");
        Scanner sc=new Scanner(System.in);
        this.newPrice=sc.nextDouble();
        price();
    }
    public void price()
    {

    }
    public void displayInfo() {
        System.out.println(" ID : " + treeId);
        System.out.println(" Name : " + name);
        System.out.println(" Type : " + getTreeType());
        System.out.println(" Location : " + location);
        System.out.println(" Age : " + ageYears + " yrs");
        System.out.println(" Height : " + heightMeters + " m");
        System.out.println(" Care : " + getCareInstructions());
        System.out.println(" Growth/yr : " + estimatedGrowthPerYear() + " m");
        System.out.println(" Water need: every " + getWaterFrequencyDays() + " day(s), " + getWaterRequirementLiters() + " L/session");
    }
    public int getTreeId()
    {
        return treeId;
    }
    public String getName()
    {
        return name;
    }
    public String getLocation()
    {
        return location;
    }
    public double getHeightMeters()
    {
        return heightMeters;
    }
    public void setName(String n)
    {
        this.name = n;
    }
    public void setLocation(String l)
    {
        this.location = l;
    }
    public static int  getTotalCreated()
    {
        return idCounter;
    }
}

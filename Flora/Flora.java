package Flora;
import Management.Waterable;
public abstract class Flora implements Waterable {

    private final int treeId;
    private String name;
    private String location;
    private int ageYears;
    private double heightMeters;
    private static int idCounter = 0;

    public Flora(String name, String location, int ageYears, double heightMeters) {
        this.name = name;
        this.location = location;
        this.ageYears = ageYears;
        this.heightMeters = heightMeters;
        this.treeId = ++idCounter;
    }
    public void harvest(int amount) throws Management.InvalidHarvestException {
        System.out.println("  [!] " + getName() + " does not produce harvestable fruit.");
    }
    public void sell(int qty) throws Management.InvalidSaleException {
        throw new Management.InvalidSaleException(getName() + " has no sellable produce.");
    }
    public abstract String getTreeType();
    public abstract String getCareInstructions();
    public abstract double estimatedGrowthPerYear();
    public boolean isSellable(){ return false; }
    public String  getProductName(){ return ""; }
    public double  getSalePrice(){ return 0.0; }
    public int getAvailableStock() { return 0; }
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
    public int getAgeYears()
    {
        return ageYears;
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
    public void setAgeYears(int a)
    {
        this.ageYears = a;
    }
    public void setHeightMeters(double h)
    {
        this.heightMeters = h;
    }
    public static int  getTotalCreated()
    {
        return idCounter;
    }
    public static void resetIdCounter()
    {
        idCounter = 0;
    }
}
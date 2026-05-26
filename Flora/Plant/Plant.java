package Flora.Plant;
import Flora.Tree; 
import Management.InsufficientWaterException;
public class Plant extends Tree {

    private final String  species;
    private final boolean isPotted;
    private       double  totalWaterGiven;

    public Plant(String name, String location, int age, double height,
                 String species, boolean isPotted) {
        super(name, location, age, height);
        this.species    = species;
        this.isPotted   = isPotted;
    }

    @Override public String getTreeType()           { return "Plant"; }
    @Override public double estimatedGrowthPerYear(){ return 0.3; }
    @Override public double getWaterFrequencyDays() { return isPotted ? 1.0 : 2.0; }
    @Override public double getWaterRequirementLiters() { return 0.5; }

    @Override
    public String getCareInstructions() {
        return isPotted
                ? "Water daily; keep under partial sunlight."
                : "Water every 2 days; weed bed weekly.";
    }

    @Override
    public void water(double liters) throws InsufficientWaterException {
        if (liters <= 0)
            throw new InsufficientWaterException("Water amount must be > 0.");
        if (liters < getWaterRequirementLiters())
            throw new InsufficientWaterException(
                    getName() + " needs at least " + getWaterRequirementLiters() + " L.");
        totalWaterGiven += liters;
        System.out.println("  Watered " + getName() + " with " + liters + " L.");
    }

    @Override
    public String getWaterStatus() {
        return "Total water supplied: " + totalWaterGiven + " L";
    }

    
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Species   : " + species);
        System.out.println("  Potted    : " + isPotted);
        System.out.println("  " + getWaterStatus());
    }

    public void displayInfo(boolean showCost) {
        displayInfo();
        if (showCost)
            System.out.println("  Maintenance cost: approx Rs 200/month");
    }


}

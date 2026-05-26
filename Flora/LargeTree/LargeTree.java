package Flora.LargeTree;
import Flora.Flora;
import Management.InsufficientWaterException;
public class LargeTree extends Flora {

    private final double canopySpreadMeters;
    private final String rootType;
    private double totalWaterGiven;

    public LargeTree(String name, String location, int age, double height, double canopy, String rootType) {
        super(name, location, age, height);
        this.canopySpreadMeters = canopy;
        this.rootType = rootType;
    }
    @Override
    public String getTreeType()
    {
        return "Large Tree";
    }
    @Override
    public double estimatedGrowthPerYear()
    {
        return 1.2;
    }
    @Override
    public double getWaterFrequencyDays()
    {
        return 7.0;
    }
    @Override
    public double getWaterRequirementLiters()
    {
        return 20.0;
    }
    @Override
    public String getCareInstructions()
    {
        return "Deep-water weekly; prune annually; inspect for pests monthly.";
    }
    @Override
    public void water(double liters) throws InsufficientWaterException {
        if (liters <= 0)
            throw new InsufficientWaterException("Water must be positive.");
        if (liters < getWaterRequirementLiters())
            throw new InsufficientWaterException( getName() + " requires at least " + getWaterRequirementLiters() + " L.");
        totalWaterGiven += liters;
        System.out.println("  Watered " + getName() + " (Large) with " + liters + " L.");
    }
    @Override
    public String getWaterStatus()
    {
        return "Total water supplied: " + totalWaterGiven + " L";
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Canopy    : " + canopySpreadMeters + " m spread");
        System.out.println("  Root type : " + rootType);
        System.out.println("  " + getWaterStatus());
    }

    public void displayInfo(boolean showGrowth) {
        displayInfo();
        if (showGrowth)
            System.out.println("  Projected height in 5 yrs: " + (getHeightMeters() + 5 * estimatedGrowthPerYear()) + " m");
    }
}
package Flora.Tree;
public class ShadeTree extends Tree {

    private double canopy;
    public ShadeTree(String name, String location, int age, double height, double canopy) {
        super(name, location, age, height);
        this.canopy=canopy;
    }
    private double AreaShade()
    {
        return 3.14*canopy*canopy;
    }
    @Override
    public String getTreeType()
    {
        return "Shade Tree";
    }
    @Override
    public double estimatedGrowthPerYear()
    {
        return 0.8;
    }
    @Override
    public String getCareInstructions() {
        return "Prune lower branches yearly; remove dead wood.";
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Area of Shade given by Tree : " + AreaShade()+"(m^2)");
    }
}
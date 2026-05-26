package Flora.LargeTree;
public class ShadeTree extends LargeTree {

    private final String beneficiary;   
    private final int    benchesNearby;
    public ShadeTree(String name, String location, int age, double height,
                     double canopy, String rootType,
                     String beneficiary, int benchesNearby) {
        super(name, location, age, height, canopy, rootType);
        this.beneficiary   = beneficiary;
        this.benchesNearby = benchesNearby;
    }

    @Override public String getTreeType()           { return "Shade Tree"; }
    @Override public double estimatedGrowthPerYear(){ return 0.8; }

    @Override
    public String getCareInstructions() {
        return "Prune lower branches yearly; remove dead wood. Shades: " + beneficiary + ".";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Shades    : " + beneficiary);
        System.out.println("  Benches   : " + benchesNearby + " nearby");
    }
}

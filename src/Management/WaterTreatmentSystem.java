package Management;
import Flora.Tree;

public class WaterTreatmentSystem {

    private double   reservoirCapacityL;
    private double   availableL;
    private double   usedTodayL;
    private String[] zones;
    private double[] zoneAllocationL;

    public WaterTreatmentSystem(double capacityL, String[] zones, double[] allocations) {
        this.reservoirCapacityL = capacityL;
        this.availableL         = capacityL;
        this.usedTodayL         = 0;
        this.zones              = zones;
        this.zoneAllocationL    = allocations;
    }

    public void waterTree(Tree tree) throws InsufficientWaterException {
        double needed = tree.getWaterRequirementLiters();
        checkSupply(tree.getName(), needed);
        tree.water(needed);
        availableL  -= needed;
        usedTodayL  += needed;
    }

    public void waterTree(Tree tree, double extraLiters) throws InsufficientWaterException {
        double total = tree.getWaterRequirementLiters() + extraLiters;
        checkSupply(tree.getName(), total);
        tree.water(total);
        availableL -= total;
        usedTodayL += total;
    }

    public void waterTree(Tree[] trees, int count, String treeName)
            throws InsufficientWaterException, TreeNotFoundException {
        for (int i = 0; i < count; i++) {
            if (trees[i].getName().equals(treeName)) {
                waterTree(trees[i]);
                return;
            }
        }
        throw new TreeNotFoundException("Tree '" + treeName + "' not found for watering.");
    }

    private void checkSupply(String name, double needed) throws InsufficientWaterException {
        if (needed > availableL)
            throw new InsufficientWaterException("Reservoir low! Cannot water " + name + ". Need " + needed + " L, have " + availableL + " L.");
    }

    public void refillReservoir(double liters) {
        availableL = Math.min(availableL + liters, reservoirCapacityL);
        System.out.printf("  Reservoir refilled by %.1f L. Now at %.1f / %.1f L.%n", liters, availableL, reservoirCapacityL);
    }

    public void displayWaterReport() {
        System.out.println("       WATER TREATMENT REPORT          ");
        System.out.println("  Reservoir Capacity : " + reservoirCapacityL + " L");
        System.out.println("  Available          : " + availableL + " L");
        System.out.println("  Used Today         : " + usedTodayL + " L");
        System.out.println("  Zone Allocations:                    ");
        for (int i = 0; i < zones.length; i++)
        {
            System.out.println("    " + zones[i] + " : " + zoneAllocationL[i] + " L    ");
        }
    }

    public double getAvailableL() { return availableL; }
}

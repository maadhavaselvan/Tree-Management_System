package Management;
import Flora.Tree; 
import Flora.LargeTree.FruitBearingTree; 
import Flora.Plant.FruitBearingPlant; 
import Management.InsufficientWaterException;
public class CampusTreeManager {

    private final String               campusName;
    private final Tree[]               trees;
    private       int                  count;
    private final WaterTreatmentSystem waterSystem;

    public CampusTreeManager(String campusName, int capacity, WaterTreatmentSystem ws) {
        this.campusName  = campusName;
        this.trees       = new Tree[capacity];
        this.count       = 0;
        this.waterSystem = ws;
    }

    public void addTree(Tree t) {
        if (count >= trees.length) {
            System.out.println("  [!] Campus tree capacity reached. Cannot add " + t.getName());
            return;
        }
        trees[count++] = t;
        System.out.printf("  [+] Registered: %-20s (ID: %d)  Type: %s%n",
                t.getName(), t.getTreeId(), t.getTreeType());
    }

    public Tree findTreeById(int id) throws TreeNotFoundException {
        for (int i = 0; i < count; i++)
            if (trees[i].getTreeId() == id) return trees[i];
        throw new TreeNotFoundException("No tree found with ID " + id + ".");
    }

    public void listAllTrees() {
        System.out.println("\n┌────┬──────────────────────┬──────────────────────────┬────────────────────┐");
        System.out.println("│ ID │ Name                 │ Type                     │ Location           │");
        System.out.println("├────┼──────────────────────┼──────────────────────────┼────────────────────┤");
        for (int i = 0; i < count; i++)
            System.out.printf("│ %2d │ %-20s │ %-24s │ %-18s │%n",
                    trees[i].getTreeId(),
                    trees[i].getName(),
                    trees[i].getTreeType(),
                    trees[i].getLocation());
        System.out.println("└────┴──────────────────────┴──────────────────────────┴────────────────────┘");
        System.out.println("  Total trees on campus: " + count);
    }

    public void listAllTrees(String filterType) {
        System.out.println("\n  Trees matching type: \"" + filterType + "\"");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (trees[i].getTreeType().toLowerCase().contains(filterType.toLowerCase())) {
                System.out.printf("    [%d] %s @ %s%n",
                        trees[i].getTreeId(), trees[i].getName(), trees[i].getLocation());
                found = true;
            }
        }
        if (!found) System.out.println("  No trees matched.");
    }

    public void listAllTrees(String zone, boolean byLocation) {
        if (!byLocation) { listAllTrees(zone); return; }
        System.out.println("\n  Trees in zone: \"" + zone + "\"");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (trees[i].getLocation().toLowerCase().contains(zone.toLowerCase())) {
                System.out.printf("    [%d] %-20s – %s%n",
                        trees[i].getTreeId(), trees[i].getName(), trees[i].getTreeType());
                found = true;
            }
        }
        if (!found) System.out.println("  No trees in that zone.");
    }

    public void waterAllTrees() {
        System.out.println("\n  --- Watering all trees ---");
        for (int i = 0; i < count; i++) {
            try {
                waterSystem.waterTree(trees[i]);
            } catch (InsufficientWaterException e) {
                System.out.println("  [!] " + e.getMessage());
            }
        }
    }

    public void sellFromTree(int treeId, int quantity) {
        try {
            Tree t = findTreeById(treeId);
            if (!(t instanceof Sellable))
                throw new InvalidSaleException(t.getName() + " has no sellable produce.");
            ((Sellable) t).sell(quantity);
        } catch (TreeNotFoundException | InvalidSaleException e) {
            System.out.println("  [Sale Error] " + e.getMessage());
        }
    }

    public void harvestFromTree(int treeId, int amount) {
        try {
            Tree t = findTreeById(treeId);
            if (t instanceof FruitBearingTree)
                ((FruitBearingTree) t).harvest(amount);
            else if (t instanceof FruitBearingPlant)
                ((FruitBearingPlant) t).harvest(amount);
            else
                System.out.println("  [!] " + t.getName() + " does not produce harvestable fruit.");
        } catch (TreeNotFoundException | InvalidHarvestException e) {
            System.out.println("  [Harvest Error] " + e.getMessage());
        }
    }

    public void displayAllTreeInfo() {
        System.out.println("\n======= Full Campus Tree Report =======");
        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Tree " + (i + 1) + " of " + count + " ---");
            trees[i].displayInfo();
        }
    }

    public void displaySalesInventory() {
        System.out.println("\n  ====== Sellable Produce Inventory ======");
        System.out.printf("  %-4s %-20s %-22s %8s %12s%n",
                "ID", "Tree Name", "Product", "Stock", "Price (Rs)");
        System.out.println("  " + "─".repeat(70));
        for (int i = 0; i < count; i++) {
            if (trees[i] instanceof Sellable) {
                Sellable s = (Sellable) trees[i];
                System.out.printf("  %-4d %-20s %-22s %8d %12.2f%n",
                        trees[i].getTreeId(),
                        trees[i].getName(),
                        s.getProductName(),
                        s.getAvailableStock(),
                        s.getSalePrice());
            }
        }
    }

    public int    getCount()      { return count; }
    public String getCampusName() { return campusName; }
    WaterTreatmentSystem getWaterSystem() { return waterSystem; }
}
package Management;
import Flora.Flora;
public class CampusTreeManager
{
    private final String campusName;
    private final Flora[] trees;
    private int count;
    private final WaterTreatmentSystem waterSystem;
    public CampusTreeManager(String campusName, int capacity, WaterTreatmentSystem ws) {
        this.campusName=campusName;
        this.trees=new Flora[capacity];
        this.count=0;
        this.waterSystem=ws;
    }
    public void addTree(Flora t) {
        if (count>=trees.length) {
            System.out.println("Campus tree capacity reached. Cannot add " + t.getName());
            return;
        }
        trees[count++] = t;
        System.out.println("Registered: " +t.getName()+" (ID: " + t.getTreeId() + ")  Type: " + t.getTreeType());
    }
    public Flora findTreeById(int id) throws TreeNotFoundException {
        for (int i = 0; i < count; i++) {
            if (trees[i].getTreeId() == id)
                return trees[i];
        }
        throw new TreeNotFoundException("No tree found with ID " + id + ".");
    }
    public void listAllTrees() {
        System.out.println("\n ----- ---------------------- -------------------------- -------------------- ");
        System.out.println("| ID | Name                 | Type                     | Location           |");
        System.out.println("|----|----------------------|--------------------------|--------------------|");
        for(int i=0;i<count;i++)
        {
            System.out.printf("|%4d|%22s|%26s|%20s|%n",trees[i].getTreeId(),trees[i].getName(),trees[i].getTreeType(),trees[i].getLocation());
        }
        System.out.println(" ---- ---------------------- -------------------------- --------------------");
        System.out.println("Total trees on campus: " + count);
    }
    public void listAllTrees(String filterType) {
        System.out.println("\nTrees matching type: \"" + filterType + "\"");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (trees[i].getTreeType().toLowerCase().equals(filterType.toLowerCase()))
            {
                System.out.println("    [" + trees[i].getTreeId() + "] " + trees[i].getName() + " @ " + trees[i].getLocation());
                found = true;
            }
        }
        if (!found)
            System.out.println("No trees matched.");
    }
    public void FruitTrees() {
        System.out.println("\nTrees which can be harvested: \"" );
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (trees[i].getTreeType().equals("Fruit-Bearing Plant") ||trees[i].getTreeType().equals("Fruit-Bearing Tree") )
            {
                System.out.println("    [" + trees[i].getTreeId() + "] " + trees[i].getName() + " @ " + trees[i].getLocation());
                found = true;
            }
        }
    if (!found)
        System.out.println("No trees matched.");
    }
    public void listAllTrees(int type) {
        String filterType="";
        switch (type)
        {
            case 1:
                filterType="Fruit-Bearing Plant";
                break;
            case 2:
                filterType="Flower-Bearing Plant";
                break;
            case 3:
                filterType="Fruit-Bearing Tree";
                break;
            case 4:
                filterType="Flower-Bearing Tree";
                break;
            case 5:
                filterType="Shade Tree";
                break;
            case 6:
                filterType="Medicinal Tree";
                break;
        }
        listAllTrees(filterType);
    }
    public void listAllTrees(String zone, boolean byLocation) {
        if (!byLocation) 
        { 
            listAllTrees(zone); 
            return; 
        }
        System.out.println("\nTrees in zone: \"" + zone + "\"");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (trees[i].getLocation().toLowerCase().equals(zone.toLowerCase())) {
                System.out.println("    [" + trees[i].getTreeId() + "] " + trees[i].getName() + " - " + trees[i].getTreeType());
                found = true;
            }
        }
        if (!found) 
            System.out.println("No trees in that zone.");
    }

    public void waterAllTrees() {
        System.out.println("\n Watering all trees");
        for (int i = 0; i < count; i++) {
            try
            {
                waterSystem.waterTree(trees[i]);
            } 
            catch (InsufficientWaterException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void sellFromTree(int treeId, int quantity) {
        try
        {
            Flora t = findTreeById(treeId);
            t.sell(quantity);
        }
        catch ( InvalidSaleException e) {
            System.out.println("[Sale Error]" + e.getMessage());
        }
        catch (TreeNotFoundException e){
            System.out.println("[Tree Not Found Error]" + e.getMessage());
        }
    }
    public void harvestFromTree(int treeId, int amount) {
        try {
            Flora t = findTreeById(treeId);
            t.harvest(amount); 
        }
        catch ( InvalidHarvestException e) {
            System.out.println("[Harvest Error]" + e.getMessage());
        }
        catch (TreeNotFoundException e){
            System.out.println("[Tree Not Found Error]" + e.getMessage());
        }
    }

    public void displayAllTreeInfo() {
        System.out.println("\nFull Campus Tree Report");
        for (int i = 0; i < count; i++) {
            System.out.println("\nTree " + (i + 1) + " of " + count );
            trees[i].displayInfo();
        }
    }

    public void displaySalesInventory() {
        System.out.println("\n Sellable Produce Inventory ");
        System.out.println("    ID             Tree Name                    Product  Stock  Price (Rs)  ");
        for (int i = 0; i < count; i++) {
            if (trees[i].isSellable()) {
                System.out.printf("%6s %21s %25s %7d %10f %n",trees[i].getTreeId(),trees[i].getName(),trees[i].getProductName(),trees[i].getAvailableStock(),trees[i].getSalePrice());
            }
        }
    }
    public WaterTreatmentSystem getWaterSystem()
    { 
        return waterSystem; 
    }
}

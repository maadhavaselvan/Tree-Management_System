import Flora.*;
import Flora.LargeTree.*;
import Flora.Plant.*;
import Management.*;
public class CampusTreeManagement {
    private static void addTreeInteractively(Scanner sc, CampusTreeManager mgr) {

        System.out.println("\n  ┌─────────────────────────────────────┐");
        System.out.println("  │         ADD A NEW TREE              │");
        System.out.println("  ├─────────────────────────────────────┤");
        System.out.println("  │  1. Fruit-Bearing Plant             │");
        System.out.println("  │  2. Flower-Bearing Plant            │");
        System.out.println("  │  3. Fruit-Bearing Tree (large)      │");
        System.out.println("  │  4. Flower-Bearing Tree (large)     │");
        System.out.println("  │  5. Shade Tree                      │");
        System.out.println("  │  6. Medicinal Tree                  │");
        System.out.println("  └─────────────────────────────────────┘");
        System.out.print("  Choose tree type (1-6): ");

        int type;
        try {
            type = Integer.parseInt(sc.nextLine().trim());
            if (type < 1 || type > 6) {
                System.out.println("  [!] Invalid type. Choose 1–6.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("  [!] Invalid input.");
            return;
        }

        System.out.print("  Tree name        : ");
        String name = sc.nextLine().trim();

        System.out.print("  Location / zone  : ");
        String location = sc.nextLine().trim();

        int age;
        try {
            System.out.print("  Age (years)      : ");
            age = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("  [!] Age must be a whole number.");
            return;
        }

        double height;
        try {
            System.out.print("  Height (metres)  : ");
            height = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("  [!] Height must be a number.");
            return;
        }

        try {
            switch (type) {

                case 1: {
                    System.out.print("  Species          : ");
                    String species = sc.nextLine().trim();

                    System.out.print("  Potted? (y/n)    : ");
                    boolean potted = sc.nextLine().trim().equalsIgnoreCase("y");

                    System.out.print("  Fruit name       : ");
                    String fruitName = sc.nextLine().trim();

                    int stockKg;
                    try {
                        System.out.print("  Initial stock (kg): ");
                        stockKg = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Stock must be a whole number.");
                        return;
                    }

                    double price;
                    try {
                        System.out.print("  Price per kg (Rs): ");
                        price = Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Price must be a number.");
                        return;
                    }

                    int hStart, hEnd;
                    try {
                        System.out.print("  Harvest start month (1-12): ");
                        hStart = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("  Harvest end   month (1-12): ");
                        hEnd   = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Month must be a whole number.");
                        return;
                    }

                    mgr.addTree(new FruitBearingPlant(
                            name, location, age, height,
                            species, potted,
                            fruitName, stockKg, price, hStart, hEnd));
                    break;
                }

                case 2: {
                    System.out.print("  Species          : ");
                    String species = sc.nextLine().trim();

                    System.out.print("  Potted? (y/n)    : ");
                    boolean potted = sc.nextLine().trim().equalsIgnoreCase("y");

                    System.out.print("  Flower name      : ");
                    String flowerName = sc.nextLine().trim();

                    int stockBunches;
                    try {
                        System.out.print("  Initial stock (bunches): ");
                        stockBunches = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Stock must be a whole number.");
                        return;
                    }

                    double price;
                    try {
                        System.out.print("  Price per bunch (Rs): ");
                        price = Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Price must be a number.");
                        return;
                    }

                    System.out.print("  Bloom season     : ");
                    String season = sc.nextLine().trim();

                    mgr.addTree(new FlowerBearingPlant(
                            name, location, age, height,
                            species, potted,
                            flowerName, stockBunches, price, season));
                    break;
                }

                case 3: {
                    double canopy;
                    try {
                        System.out.print("  Canopy spread (m): ");
                        canopy = Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Canopy must be a number.");
                        return;
                    }

                    System.out.print("  Root type        : ");
                    String rootType = sc.nextLine().trim();

                    System.out.print("  Fruit name       : ");
                    String fruitName = sc.nextLine().trim();

                    int stockKg;
                    try {
                        System.out.print("  Initial stock (kg): ");
                        stockKg = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Stock must be a whole number.");
                        return;
                    }

                    double price;
                    try {
                        System.out.print("  Price per kg (Rs): ");
                        price = Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Price must be a number.");
                        return;
                    }

                    mgr.addTree(new FruitBearingTree(
                            name, location, age, height,
                            canopy, rootType,
                            fruitName, stockKg, price));
                    break;
                }

                case 4: {
                    double canopy;
                    try {
                        System.out.print("  Canopy spread (m): ");
                        canopy = Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Canopy must be a number.");
                        return;
                    }

                    System.out.print("  Root type        : ");
                    String rootType = sc.nextLine().trim();

                    System.out.print("  Flower/garland name: ");
                    String flowerName = sc.nextLine().trim();

                    int stockGarlands;
                    try {
                        System.out.print("  Initial stock (garlands): ");
                        stockGarlands = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Stock must be a whole number.");
                        return;
                    }

                    double price;
                    try {
                        System.out.print("  Price per garland (Rs): ");
                        price = Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Price must be a number.");
                        return;
                    }

                    mgr.addTree(new FlowerBearingTree(
                            name, location, age, height,
                            canopy, rootType,
                            flowerName, stockGarlands, price));
                    break;
                }

                case 5: {
                    double canopy;
                    try {
                        System.out.print("  Canopy spread (m): ");
                        canopy = Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Canopy must be a number.");
                        return;
                    }

                    System.out.print("  Root type        : ");
                    String rootType = sc.nextLine().trim();

                    System.out.print("  Area it shades   : ");
                    String beneficiary = sc.nextLine().trim();

                    int benches;
                    try {
                        System.out.print("  Benches nearby   : ");
                        benches = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Benches must be a whole number.");
                        return;
                    }

                    mgr.addTree(new ShadeTree(
                            name, location, age, height,
                            canopy, rootType,
                            beneficiary, benches));
                    break;
                }

                case 6: {
                    double canopy;
                    try {
                        System.out.print("  Canopy spread (m): ");
                        canopy = Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Canopy must be a number.");
                        return;
                    }

                    System.out.print("  Root type        : ");
                    String rootType = sc.nextLine().trim();

                    int numUses;
                    try {
                        System.out.print("  Number of medicinal uses: ");
                        numUses = Integer.parseInt(sc.nextLine().trim());
                        if (numUses < 1) {
                            System.out.println("  [!] Must have at least 1 use.");
                            return;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Must be a whole number.");
                        return;
                    }

                    String[] uses = new String[numUses];
                    for (int i = 0; i < numUses; i++) {
                        System.out.print("  Use " + (i + 1) + "           : ");
                        uses[i] = sc.nextLine().trim();
                    }

                    System.out.print("  Managing dept    : ");
                    String dept = sc.nextLine().trim();

                    mgr.addTree(new MedicinalTree(
                            name, location, age, height,
                            canopy, rootType,
                            uses, dept));
                    break;
                }

                default:
                    System.out.println("  [!] Unknown type.");
            }

        } catch (Exception e) {
            System.out.println("  [!] Unexpected error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] zones       = { "Science Block", "Arts Block", "Sports Ground", "Garden Zone", "Central Campus" };
        double[] allocations = {   800.0,           600.0,        500.0,           1000.0,         400.0 };
        WaterTreatmentSystem wts = new WaterTreatmentSystem(10_000.0, zones, allocations);

        CampusTreeManager mgr = new CampusTreeManager("Green Valley College", 25, wts);

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║   Campus Tree Management System v1.0    ║");
        System.out.println("║   Green Valley College                   ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println("\n  Registering campus trees...\n");

        mgr.addTree(new FruitBearingPlant(
                "Guava Bush",  "Garden Zone",   3, 1.8, "Psidium guajava", false,
                "Guava",       40,  60.0, 7, 10));

        mgr.addTree(new FruitBearingPlant(
                "Banana Plant","Sports Ground", 2, 2.5, "Musa acuminata",  false,
                "Banana",      80,  30.0, 3,  9));

        mgr.addTree(new FlowerBearingPlant(
                "Rose Bush",   "Arts Block",    1, 0.9, "Rosa",            true,
                "Rose",        50,  15.0, "Spring"));

        mgr.addTree(new FlowerBearingPlant(
                "Marigold",    "Garden Zone",   1, 0.6, "Tagetes erecta",  false,
                "Marigold",   100,  10.0, "Winter"));

        mgr.addTree(new FruitBearingTree(
                "Mango Tree",      "Science Block",  20, 12.0, 8.0, "Taproot",
                "Mango",      200,  80.0));

        mgr.addTree(new FruitBearingTree(
                "Jackfruit Tree",  "Garden Zone",    15, 10.0, 6.5, "Taproot",
                "Jackfruit",  100,  50.0));

        mgr.addTree(new FlowerBearingTree(
                "Gulmohar Tree",   "Arts Block",     25, 15.0, 10.0, "Lateral",
                "Gulmohar Flower", 60,  20.0));

        mgr.addTree(new FlowerBearingTree(
                "Jasmine Climber", "Garden Zone",    10,  5.0,  3.5, "Fibrous",
                "Jasmine Garland", 80,  25.0));

        mgr.addTree(new ShadeTree(
                "Banyan Tree",     "Central Campus", 50, 20.0, 25.0, "Prop Roots",
                "Main Quadrangle", 6));

        mgr.addTree(new ShadeTree(
                "Neem Tree",       "Sports Ground",  30, 16.0, 12.0, "Taproot",
                "Sports Pavilion", 4));

        mgr.addTree(new MedicinalTree(
                "Tulsi Grove",     "Science Block",   5,  1.2,  2.0, "Fibrous",
                new String[]{"Immunity booster", "Cough remedy", "Antiseptic"},
                "Pharmacy Dept"));

        mgr.addTree(new MedicinalTree(
                "Ashwagandha",     "Garden Zone",     4,  1.5,  1.5, "Taproot",
                new String[]{"Stress relief", "Anti-inflammatory"},
                "Life Sciences Dept"));

        boolean running = true;
        while (running) {
            System.out.println("\n┌──────────────────────────────────────┐");
            System.out.println("│              MAIN  MENU              │");
            System.out.println("├──────────────────────────────────────┤");
            System.out.println("│  1. List all trees                   │");
            System.out.println("│  2. View tree details by ID          │");
            System.out.println("│  3. Filter trees by type             │");
            System.out.println("│  4. Filter trees by zone             │");
            System.out.println("│  5. Sellable produce inventory       │");
            System.out.println("│  6. Sell produce from a tree         │");
            System.out.println("│  7. Harvest fruit from a tree        │");
            System.out.println("│  8. Water all trees                  │");
            System.out.println("│  9. Refill water reservoir           │");
            System.out.println("│ 10. Water treatment report           │");
            System.out.println("│ 11. Full campus tree report          │");
            System.out.println("│ 12. Add a new tree                   │");
            System.out.println("│ 13. Exit                             │");
            System.out.println("└──────────────────────────────────────┘");
            System.out.print("  Enter choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  [!] Invalid input – enter a number from the menu.");
                continue;
            }

            switch (choice) {
                case 1:
                    mgr.listAllTrees();
                    break;

                case 2:
                    System.out.print("  Enter Tree ID: ");
                    try {
                        int id = Integer.parseInt(sc.nextLine().trim());
                        Tree t = mgr.findTreeById(id);
                        System.out.println();
                        t.displayInfo();
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Invalid ID.");
                    } catch (TreeNotFoundException e) {
                        System.out.println("  [!] " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("  Enter type keyword (e.g. Fruit, Flower, Shade, Medicinal): ");
                    mgr.listAllTrees(sc.nextLine().trim());
                    break;

                case 4:
                    System.out.print("  Enter zone keyword (e.g. Garden, Science, Arts, Sports, Central): ");
                    mgr.listAllTrees(sc.nextLine().trim(), true);
                    break;

                case 5:
                    mgr.displaySalesInventory();
                    break;

                case 6:
                    mgr.displaySalesInventory();
                    System.out.print("  Enter Tree ID to sell from: ");
                    try {
                        int id  = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("  Enter quantity: ");
                        int qty = Integer.parseInt(sc.nextLine().trim());
                        mgr.sellFromTree(id, qty);
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Invalid number.");
                    }
                    break;

                case 7:
                    mgr.listAllTrees("Fruit");
                    System.out.print("  Enter Fruit Tree ID: ");
                    try {
                        int id  = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("  Enter kg to harvest: ");
                        int kg  = Integer.parseInt(sc.nextLine().trim());
                        mgr.harvestFromTree(id, kg);
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Invalid number.");
                    }
                    break;

                case 8:
                    mgr.waterAllTrees();
                    break;

                case 9:
                    System.out.print("  Enter litres to add to reservoir: ");
                    try {
                        double liters = Double.parseDouble(sc.nextLine().trim());
                        mgr.getWaterSystem().refillReservoir(liters);
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Invalid amount.");
                    }
                    break;

                case 10:
                    mgr.getWaterSystem().displayWaterReport();
                    break;

                case 11:
                    mgr.displayAllTreeInfo();
                    break;

                case 12:
                    addTreeInteractively(sc, mgr);
                    break;

                case 13:
                    System.out.println("\n  Exiting... Total trees ever registered: "
                            + Tree.getTotalCreated());
                    System.out.println("  Goodbye!\n");
                    running = false;
                    break;

                default:
                    System.out.println("  [!] Invalid choice. Choose 1–13.");
            }
        }

        sc.close();
    }
}
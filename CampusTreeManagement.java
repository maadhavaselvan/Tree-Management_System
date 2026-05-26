import Flora.*;
import Flora.LargeTree.*;
import Flora.Plant.*;
import Management.*;

import java.util.InputMismatchException;
import java.util.Scanner;
public class CampusTreeManagement {
    private static int readInt(Scanner sc, String prompt)
    {
        while (true) {
            System.out.print(prompt);
            try {
                int value = sc.nextInt(); sc.nextLine();
                return value;
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a whole number.");
                sc.nextLine();
            }
        }
    }

    private static double readDouble(Scanner sc, String prompt)
    {
        while (true) {
            System.out.print(prompt);
            try {
                double val = sc.nextDouble(); sc.nextLine();
                return val;
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a number.");
                sc.nextLine();
            }
        }
    }
    private static void addTreeInteractively(Scanner sc, CampusTreeManager mgr)
    {
        System.out.println("           ADD A NEW TREE");
        System.out.println("1. Fruit-Bearing Plant");
        System.out.println("2. Flower-Bearing Plant");
        System.out.println("3. Fruit-Bearing Tree (large) ");
        System.out.println("4. Flower-Bearing Tree (large)");
        System.out.println("5. Shade Tree");
        System.out.println("6. Medicinal Tree");
        System.out.print("Choose tree type (1-6) : ");
        int type;
        try {
            type = sc.nextInt();
            sc.nextLine();
            if (type < 1 || type > 6) {
                System.out.println("Invalid type. Choose 1–6.");
                return;
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            sc.nextLine();
            return;
        }

        System.out.print("Tree name : ");
        String name = sc.nextLine();
        System.out.print("Location / zone : ");
        String location = sc.nextLine();

        int age=readInt(sc,"Enter the age");
        double height=readDouble(sc,"Enter your Height(meters)");
        try {
            switch (type) {
                case 1: {
                    System.out.print("Species : ");
                    String species = sc.nextLine();
                    System.out.print("Potted? (y/n) : ");
                    String pot = sc.nextLine();
                    boolean potted = false;
                    if(pot.equals("y")|| pot.equals("Y"))
                    {
                        potted=true;
                    }    
                    System.out.print("Fruit name : ");
                    String fruitName = sc.nextLine();
                    int stockKg=readInt(sc,"Enter stock in Kg : ");
                    double price=readDouble(sc,"Price per kg (Rs) : ");
                    int hStart=readInt(sc,"Harvest start month (1-12) : ");
                    int hEnd=readInt(sc,"Harvest end month (1-12) : ");
                    mgr.addTree(new FruitBearingPlant(
                            name, location, age, height,
                            species, potted,
                            fruitName, stockKg, price, hStart, hEnd));
                    break;
                }
                case 2: {
                    System.out.print("Species : ");
                    String species = sc.nextLine();
                    System.out.print("Potted? (y/n) : ");
                    String pot = sc.nextLine();
                    boolean potted = false;
                    if(pot.equals("y")|| pot.equals("Y"))
                    {
                        potted=true;
                    }
                    System.out.print("Flower name : ");
                    String flowerName = sc.nextLine();
                    int stockBunches=readInt(sc,"Initial stock (bunches) : ");
                    double price=readDouble(sc,"Price per bunch (Rs) : ");
                    System.out.print("Bloom season : ");
                    String season = sc.nextLine();
                    mgr.addTree(new FlowerBearingPlant(
                            name, location, age, height,
                            species, potted,
                            flowerName, stockBunches, price, season));
                    break;
                }
                case 3: {
                    double canopy=readDouble(sc,"Canopy spread (m) : ");
                    System.out.print("Root type : ");
                    String rootType = sc.nextLine();
                    System.out.print("Fruit name : ");
                    String fruitName = sc.nextLine();
                    int stockKg=readInt(sc,"Initial stock (kg) : ");
                    double price=readDouble(sc,"Price per kg (Rs) : ");
                    mgr.addTree(new FruitBearingTree(
                            name, location, age, height,
                            canopy, rootType,
                            fruitName, stockKg, price));
                    break;
                }

                case 4: {
                    double canopy=readDouble(sc,"Canopy spread (m) : ");
                    System.out.print("Root type : ");
                    String rootType = sc.nextLine();
                    System.out.print("Flower/garland name : ");
                    String flowerName = sc.nextLine();

                    int stockGarlands=readInt(sc,"Initial stock (garlands) : ");
                    double price=readDouble(sc,"Price per garland (Rs) : ");
                    mgr.addTree(new FlowerBearingTree(
                            name, location, age, height,
                            canopy, rootType,
                            flowerName, stockGarlands, price));
                    break;
                }

                case 5: {
                    double canopy=readDouble(sc,"Canopy spread (m) : ");
                    System.out.print("Root type : ");
                    String rootType = sc.nextLine();

                    System.out.print("Area it shades : ");
                    String beneficiary = sc.nextLine();

                    int benches=readInt(sc,"Benches nearby : ");

                    mgr.addTree(new ShadeTree(
                            name, location, age, height,
                            canopy, rootType,
                            beneficiary, benches));
                    break;
                }

                case 6: {
                    double canopy=readDouble(sc,"Canopy spread (m) : ");
                    System.out.print("Root type : ");
                    String rootType = sc.nextLine();

                    int numUses=readInt(sc,"Number of medicinal uses : ");

                    String[] uses = new String[numUses];
                    for (int i = 0; i < numUses; i++) {
                        System.out.print("  Use " + (i + 1) + " : ");
                        uses[i] = sc.nextLine();
                    }
                    System.out.print("Managing dept : ");
                    String dept = sc.nextLine();

                    mgr.addTree(new MedicinalTree(
                            name, location, age, height,
                            canopy, rootType,
                            uses, dept));
                    break;
                }

                default:
                    System.out.println("Unknown type.");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] zones = { "Academic Block", "Krishna Hostel", "Tungabhadra Hostel", "Bheema Hostel", "Play Area" };
        double[] allocations = {1500,1250,1250,2000,4000 };
        WaterTreatmentSystem wts = new WaterTreatmentSystem(10000.0,zones,allocations);

        CampusTreeManager mgr = new CampusTreeManager("INDIAN INSTITUTE OF INFORMATION TECHNOLOGY RAICHUR", 25, wts);

        System.out.println("    Tree Management System");
        System.out.println("   INDIAN INSTITUTE OF INFORMATION TECHNOLOGY RAICHUR");
        System.out.println("\n  Registering campus trees...\n");

        mgr.addTree(new FruitBearingPlant("Guava Bush", "Garden Zone", 3, 1.8, "Psidium guajava", false, "Guava", 40, 60.0, 7, 10));

        mgr.addTree(new FruitBearingPlant("Banana Plant", "Sports Ground", 2, 2.5, "Musa acuminata", false, "Banana", 80, 30.0, 3, 9));

        mgr.addTree(new FlowerBearingPlant("Rose Bush", "Arts Block", 1, 0.9, "Rosa", true, "Rose", 50, 15.0, "Spring"));

        mgr.addTree(new FlowerBearingPlant("Marigold", "Garden Zone", 1, 0.6, "Tagetes erecta", false, "Marigold", 100, 10.0, "Winter"));

        mgr.addTree(new FruitBearingTree("Mango Tree", "Science Block", 20, 12.0, 8.0, "Taproot", "Mango", 200, 80.0));

        mgr.addTree(new FruitBearingTree("Jackfruit Tree", "Garden Zone", 15, 10.0, 6.5, "Taproot", "Jackfruit", 100, 50.0));

        mgr.addTree(new FlowerBearingTree("Gulmohar Tree", "Arts Block", 25, 15.0, 10.0, "Lateral", "Gulmohar Flower", 60, 20.0));

        mgr.addTree(new FlowerBearingTree("Jasmine Climber", "Garden Zone", 10, 5.0, 3.5, "Fibrous", "Jasmine Garland", 80, 25.0));

        mgr.addTree(new ShadeTree("Banyan Tree", "Central Campus", 50, 20.0, 25.0, "Prop Roots", "Main Quadrangle", 6));

        mgr.addTree(new ShadeTree("Neem Tree", "Sports Ground", 30, 16.0, 12.0, "Taproot", "Sports Pavilion", 4));

        mgr.addTree(new MedicinalTree("Tulsi Grove", "Science Block", 5, 1.2, 2.0, "Fibrous", new String[]{"Immunity booster", "Cough remedy", "Antiseptic"}, "Pharmacy Dept"));

        mgr.addTree(new MedicinalTree("Ashwagandha", "Garden Zone", 4, 1.5, 1.5, "Taproot",new String[]{"Stress relief", "Anti-inflammatory"}, "Life Sciences Dept"));

        while (true) {
            System.out.println("              MAIN  MENU");
            System.out.println("1. List all trees");
            System.out.println("2. View tree details by ID ");
            System.out.println("3. Filter trees by type");
            System.out.println("4. Filter trees by zone");
            System.out.println("5. Sellable produce inventory");
            System.out.println("6. Sell produce from a tree");
            System.out.println("7. Harvest fruit from a tree");
            System.out.println("8. Water all trees");
            System.out.println("9. Refill water reservoir");
            System.out.println("10. Water treatment report");
            System.out.println("11. Full campus tree report");
            System.out.println("12. Add a new tree");
            System.out.println("13. Exit");

            int choice = readInt(sc,"Enter choice: ");

            switch (choice) {
                case 1:
                    mgr.listAllTrees();
                    break;
                case 2:
                    int id=readInt(sc,"Enter Tree ID: ");
                    try {
                        Flora t = mgr.findTreeById(id);
                        System.out.println();
                        t.displayInfo();
                    }
                    catch (TreeNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter type keyword (e.g. Fruit, Flower, Shade, Medicinal): ");
                    mgr.listAllTrees(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter zone keyword (e.g. Garden, Science, Arts, Sports, Central): ");
                    mgr.listAllTrees(sc.nextLine(), true);
                    break;

                case 5:
                    mgr.displaySalesInventory();
                    break;

                case 6:
                    mgr.displaySalesInventory();
                    id=readInt(sc,"Enter Tree ID to sell from: ");
                    System.out.print("Enter quantity: ");
                    int qty = readInt(sc,"Enter quantity: ");
                    mgr.sellFromTree(id, qty);
                    break;

                case 7:
                    mgr.listAllTrees("Fruit");
                    id=readInt(sc,"Enter Fruit Tree ID: ");
                    int kg  = readInt(sc,"Enter kg to harvest: ");
                    mgr.harvestFromTree(id, kg);
                    break;

                case 8:
                    mgr.waterAllTrees();
                    break;

                case 9:
                    double liters=readDouble(sc,"Enter litres to add to reservoir: ");
                    mgr.getWaterSystem().refillReservoir(liters);
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
                    System.out.println("\nExiting... Total trees ever registered: " + Flora.getTotalCreated());
                    System.out.println("Goodbye!\n");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Choose 1–13.");
            }
        }

        sc.close();
    }
}

package Flora.LargeTree;
public class MedicinalTree extends LargeTree {

    private final String[] medicinalUses;
    private final String   contactDept;   
    public MedicinalTree(String name, String location, int age, double height,
                         double canopy, String rootType,
                         String[] medicinalUses, String contactDept) {
        super(name, location, age, height, canopy, rootType);
        this.medicinalUses = medicinalUses;
        this.contactDept   = contactDept;
    }

    @Override public String getTreeType()           { return "Medicinal Tree"; }
    @Override public double estimatedGrowthPerYear(){ return 0.9; }

    @Override
    public String getCareInstructions() {
        return "Organic care only; no pesticides. Contact " + contactDept + " before pruning.";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.print("  Uses      : ");
        for (int i = 0; i < medicinalUses.length; i++) {
            System.out.print(medicinalUses[i]);
            if (i < medicinalUses.length - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.println("  Managed by: " + contactDept);
    }
}

package Flora.Tree;
public class MedicinalTree extends Tree {

    private final String[] medicinalUses;
    public MedicinalTree(String name, String location, int age, double height, String[] medicinalUses) {
        super(name, location, age, height);
        this.medicinalUses = medicinalUses;
    }
    @Override
    public String getTreeType()
    {
        return "Medicinal Tree";
    }
    @Override
    public double estimatedGrowthPerYear()
    {
        return 0.9;
    }
    @Override
    public String getCareInstructions() {
        return "Organic care only; no pesticides.";
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.print("Uses  : ");
        for (int i = 0; i < medicinalUses.length; i++) {
            System.out.print(medicinalUses[i]);
            if (i < medicinalUses.length - 1)
                System.out.print(", ");
        }
        System.out.println();
    }
}
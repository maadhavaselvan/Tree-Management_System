package Management;
public interface Waterable {
    void   water(double liters) throws InsufficientWaterException;
    double getWaterFrequencyDays();
    double getWaterRequirementLiters();
    String getWaterStatus();
}
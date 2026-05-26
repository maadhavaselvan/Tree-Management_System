package Management;
public interface Sellable {
    double  getSalePrice();
    String  getProductName();
    int     getAvailableStock();
    void    sell(int quantity) throws InvalidSaleException;
}
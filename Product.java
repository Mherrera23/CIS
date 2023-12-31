package groupLab4;


/**
 * Represents a product with various attributes.
 *
 * @author Mohammed Asgar
 * @author Brandon Evangelista
 * @author Manuel Herrera
 */
public class Product {
    int productID;
    String productName;
    float productRating;
    double price;

    
    /**
     * Constructs a new Product object.
     *
     * @param productID    The unique identifier for this product.
     * @param productName  The name of this product.
     * @param productRating The rating of this product.
     * @param price        The price of this product.
     */
    public Product(int productID, String productName, float productRating, double price) {
        this.productID = productID;
        this.productName = productName;
        this.productRating = productRating;
        this.price = price;
    }



}
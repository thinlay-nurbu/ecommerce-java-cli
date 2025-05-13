package CLI;

import ECommerce.*;

import java.util.Scanner;

public class AddToCart implements Actionable{
    private Product product;

    public AddToCart(Product product){
        this.product = product;
    }

    @Override
    public String getLabel() {
        return "Add to Cart";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if(!(user instanceof Client)){
            System.out.println("Only client can add to cart");
            return;
        }

        Cart cart = ((Client) user).getCart();
        if(cart == null){
            cart = new Cart();
        }

        new ShowProductDetails(this.product).execute(scanner, user, dataManager);
        System.out.print("Enter quantity: ");
        int qty = Input.readInt(scanner);
        CartProduct cartProduct = new CartProduct(this.product, qty);

        if(cartProduct.canAddToCart()){
            cart.getProducts().add(cartProduct);
            this.product.setStockQuantity(this.product.getStockQuantity()-qty);
            System.out.println("Product is added to cart successfully");
        } else {
            System.out.println("Product couldn't add to cart :(");
        }
    }
}

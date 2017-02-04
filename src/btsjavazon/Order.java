package btsjavazon;

import java.text.NumberFormat;
import java.util.Arrays;

/**
 * @author Bryan
 */
public class Order {

    private Customer orderCustomer;
    private Clerk orderClerk;
    private Product[] orderProduct;
    private int[] orderQuantity;

    private double subtotal;
    private double tax;
    private double total;

    private static double TAX_RATE = 0.0825;

    private int productCount;

    public Order() {
        orderProduct = new Product[1];
        orderQuantity = new int[1];
    }

    public void setOrderCustomer(Customer aCustomer) {
        orderCustomer = aCustomer;
    }

    public void setOrderClerk(Clerk aClerk) {
        orderClerk = aClerk;
    }

    public void setOrderProduct(Product aProduct, int aQty) {
        //TODO
        //EACH TIME A USER ADDS A PRODUCT TO THE ORDER
        //IF IT IS THE FIRST PRODUCT ADDED TO THE ORDER THEN
        //STORE IT IN THE orderProduct ARRAY
        if ((orderProduct.length == 1 && orderProduct[0] == null) &&
                (orderQuantity.length == 1 && orderQuantity[0] == 0)) {
            orderProduct[0] = aProduct;
            orderQuantity[0] = aQty;
        } else {
            orderProduct = Arrays.copyOf(orderProduct, orderProduct.length + 1);
            orderProduct[orderProduct.length - 1] = aProduct;
            orderQuantity = Arrays.copyOf(orderQuantity, orderQuantity.length + 1);
            orderQuantity[orderQuantity.length - 1] = aQty;
        }

        //IF MORE PRODUCTS ARE ADDED, YOU HAVE TO RESIZE THE
        //orderProduct and orderQuantity arrays.
        //the way to do that is to the the Arrays.copyOf method or
        //to create temp array for each
        //copy the current arrays into temp arrays
        //resize the current arrays
        //put back the temp arrays in the current arrays
        //in the newly sized arrays
        //add the new product
        //add the quantity
    }

    public void calcSubtotal() {
        //TODO
        //FOR LOOP THROUGH THE orderProduct array
        //get the price
        //get the quantity from the orderQuantity array
        //STORE IT IN subtotal VARIABLE
        subtotal = 0;
        for (int i = 0; i < orderProduct.length; i++) {
            total = orderProduct[i].getPrice();
            productCount += orderQuantity[i];
            //subtotal += orderProduct[i].getPrice();
            subtotal += total * productCount;
        }
    }

    public void calcTax() {
        //TODO
        //CALCULATE THE TAX
        //STORE IT IN tax VARIABLE
        tax = subtotal * TAX_RATE;
    }

    public void calcTotal() {
        //TODO
        //CALCULATE THE TOTAL
        //STORE IT IN total VARIABLE
        total = subtotal + tax;
    }

    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        String result = "";
        String purchaseList = "";

        for (int i = 0; i < orderProduct.length; i++) {
            purchaseList += orderQuantity[i] + " @ " + orderProduct[i].getPrice() + " = " +
                    orderQuantity[i] * orderProduct[i].getPrice() + "\n  " +
                    orderProduct[i].getDescription() + "\n\n";
        }

        result += "CASHIER @ REGISTER\n" + orderClerk.getFirstName() + " " + orderClerk.getLastName() + " @ " +
                orderClerk.getRegisterNbr() + "\n\n";
        //TODO
        //ADD REST OF SUMMARY TO RESULT
        //SEE LINE ABOVE FOR EXAMPLE OF HOW TO GET INFORMATION FROM
        //OTHER OBJECTS THAT ARE AVAILABLE WITHIN THE ORDER CLASS
        //SEE PROJECT HANDOUT TO GET IDEA OF HOW YOUR SUMMARY SHOULD LOOK LIKE
        result += "CUSTOMER INFO\n" + orderCustomer.toString() + "\n";
        result += "NUMBER OF ITEMS SOLD = " + productCount + "\n\n";
        result += purchaseList;
        result += "TOTALS\n" + "Subtotal: " + nf.format(subtotal) + "\n" + "Tax: " + nf.format(tax) + "\n" + "Total: " + nf.format(total);

        return result;
    }

    public int getNumberItemsSold() {
        int totalQty = 0;
        for (int i = 0; i < orderQuantity.length; i++) {
            totalQty += orderQuantity[i];
        }

        return totalQty;
    }
}

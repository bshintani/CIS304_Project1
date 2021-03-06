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

    //Adds Product and Quantity to first index of their respective arrays if it is the first item being added
    //Otherwise, resizes array using .copyOf and adds items and quantities respectively
    public void setOrderProduct(Product aProduct, int aQty) {
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
    }

    //Loops through orderProduct and orderQuantity array to calculate subtotal
    public void calcSubtotal() {
        subtotal = 0;
        for (int i = 0; i < orderProduct.length; i++) {
            total = orderProduct[i].getPrice();
            productCount = orderQuantity[i];
            subtotal += total * productCount;
        }
    }

    //Calculates tax
    public void calcTax() {
        tax = subtotal * TAX_RATE;
    }

    //Calculates total
    public void calcTotal() {
        total = subtotal + tax;
    }

    //Displays the dynamic portion of the receipt
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        String result = "";
        String purchaseList = "";

        //Loop to the products purchased, quantities, individual prices,
        //and subtotal of different items purchased to a String purchaseList
        for (int i = 0; i < orderProduct.length; i++) {
            double itemSubtotal = orderQuantity[i] * orderProduct[i].getPrice();
            purchaseList += orderQuantity[i] + " @ " + nf.format(orderProduct[i].getPrice()) + " = " +
                            nf.format(itemSubtotal) + "\n  " + orderProduct[i].getDescription() + "\n\n";
        }

        result += "CASHIER @ REGISTER\n" + orderClerk.getFirstName() + " " + orderClerk.getLastName() + " @ " +
                orderClerk.getRegisterNbr() + "\n\n";
        result += "CUSTOMER INFO\n" + orderCustomer.toString() + "\n";
        result += "NUMBER OF ITEMS SOLD = " + getNumberItemsSold() + "\n\n";
        result += purchaseList;
        result += "TOTALS\n" + "Subtotal: " + nf.format(subtotal) + "\n" + "Tax: " + nf.format(tax) + "\n" + "Total: " + nf.format(total);

        return result;
    }

    //Loops through orderQuantity array
    //Returns total number of items sold
    public int getNumberItemsSold() {
        int totalQty = 0;
        for (int i = 0; i < orderQuantity.length; i++) {
            totalQty += orderQuantity[i];
        }

        return totalQty;
    }
}

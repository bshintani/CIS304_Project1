package btsjavazon;
/**
 *
 * @author Bryan
 */
public class Customer extends Person {
    private String membershipID;
    
    //OBJECT CONSTRUCTOR
    public Customer(String firstName, String lastName, String anAddress, String city, String state, String zip,
                    String phone, String aMembershipID) {

        super(firstName, lastName, anAddress, city, state, zip, phone);

        membershipID = aMembershipID;
    }
    
    //METHOD TO RETURN SUMMARY ABOUT OBJECT
    public String toString() {
        String result = "";

        result += "Member ID: " + membershipID + "\n";
        result += super.toString();

        return result;
    }

}

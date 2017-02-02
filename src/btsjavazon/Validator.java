package btsjavazon;

import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class Validator {

    //TODO - CODE THE VALIDATOR
    public static String getValidFirstName(String anInput) {
        while (isValidFirstName(anInput) == false) {
            anInput = JOptionPane.showInputDialog(null, "Please re-enter first name\n\n" + anInput + " is invalid.");
        }
        return anInput;
    }

    private static boolean isValidFirstName(String anInput) {
        boolean result = true;

        if (anInput.length() == 0) {
            result = false;
        }
        return result;
    }

    public static String getValidLastName(String anInput) {
        while (isValidLastName(anInput) == false) {
            anInput = JOptionPane.showInputDialog(null, "Please re-enter last name\n\n" + anInput + " is invalid.");
        }
        return anInput;
    }

    private static boolean isValidLastName(String anInput) {
        boolean result = true;

        if (anInput.length() == 0) {
            result = false;
        }
        return result;
    }

    public static String getValidAddress(String anInput) {
        while (isValidAddress(anInput) == false) {
            anInput = JOptionPane.showInputDialog(null, "Please re-enter address\n\n" + anInput + " is invalid.");
        }
        return anInput;
    }

    private static boolean isValidAddress(String anInput) {
        boolean result = true;

        if (anInput.length() == 0) {
            result = false;
        }
        return result;
    }

    public static String getValidCity(String anInput) {
        while (isValidCity(anInput) == false) {
            anInput = JOptionPane.showInputDialog(null, "Please re-enter your city\n\n" + anInput + " is invalid.");
        }
        return anInput;
    }

    private static boolean isValidCity(String anInput) {
        boolean result = true;

        if (anInput.length() == 0) {
            result = false;
        }
        return result;
    }

    public static String getValidState(String anInput) {
        while (isValidState(anInput) == false) {
            anInput = JOptionPane.showInputDialog(null, "Please re-enter your state (2 letters)\n\n" + anInput + " is invalid.");
        }
        return anInput;
    }

    private static boolean isValidState(String anInput) {
        boolean result = true;

        if (anInput.length() == 0 || anInput.length() > 2) {
            result = false;
        }
        return result;
    }

    public static String getValidZip(String anInput) {
        while (isValidZip(anInput) == false) {
            anInput = JOptionPane.showInputDialog(null, "Please re-enter your 5 digit ZIP code\n\n" + anInput + " is invalid.");
        }
        return anInput;
    }

    private static boolean isValidZip(String anInput) {
        boolean result = true;

        try {
            int zipCode = Integer.parseInt(anInput);
            if (anInput.length() != 5) {
                result = false;
            }
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public static String getValidPhone(String anInput) {
        while (isValidPhone(anInput) == false) {
            anInput = JOptionPane.showInputDialog(null, "Please re-enter your 10 digit phone number\n\n" + anInput + " is invalid.");
        }
        return anInput;
    }

    private static boolean isValidPhone(String anInput) {

        try {

            if (anInput.length() == 10) {

                for (int i = 0; i < anInput.length(); i++) {
                    char number = anInput.charAt(i);
                    if (!Character.isDigit(number)) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static String getValidMembership(String anInput) {
        while (isValidMembership(anInput) == false) {
            anInput = JOptionPane.showInputDialog(null, "Please re-enter membership ID\n\n" + anInput + " is invalid.");
        }
        return anInput;
    }

    private static boolean isValidMembership(String anInput) {

        try {
            if (anInput.length() == 6) {
                
                for (int i = 0; i < 2; i++) {
                    char letter = anInput.charAt(i);
                    if (!Character.isLetter(letter)) {
                        return false;
                    }
                }

                for (int i = 2; i < anInput.length(); i++) {
                    char number = anInput.charAt(i);
                    if(!Character.isDigit(number)) {
                        return false;
                    }
                }

            } else {
                return false;
            }

        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static String getValidQuantity(String anInput) {
        while (isValidQuantity(anInput) == false) {
            anInput = JOptionPane.showInputDialog(null, "Please re-enter product quantity\n\n" + anInput + " is invalid.");
        }
        return anInput;
    }

    private static boolean isValidQuantity(String anInput) {
        boolean result = true;

        try {
            int quantity = Integer.parseInt(anInput);
            if (quantity < 1 || quantity > 10) {
                result = false;
            }
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }
}

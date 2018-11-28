/**
 * Transaction System
 * A transaction system which can store a list of products, compute total
 * amount of purchase, and print a receipt.
 * @author Muhamad Amien Bin Abu Hassan Sha'ari - B01180003
 * @version 1.0
 */

package transactionSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransactionSystem {
    String name;
    LinkedList<Item> itemList;
    static DateTimeFormatter dtf = 
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    public TransactionSystem(String name) {
        this.name = name;
        itemList = new LinkedList(Arrays.asList(
                new Item(null, 0f),
                new Item("Shoe", 34.55f),
                new Item("Shirts", 44.29f),
                new Item("Pants", 64.35f),
                new Item("Jeans", 84.25f),
                new Item("Fan", 51.59f),
                new Item("Iron", 24.45f),
                new Item("Tray", 51.99f),
                new Item("Rice", 24.76f)));
    }
    
    public TransactionSystem(String name, Collection c) {
        this.name = name;
        itemList.addAll(c);
    }
    
    public TransactionSystem() {
        name = "Transaction System";
        itemList = new LinkedList(Arrays.asList(
                new Item(null, 0f),
                new Item("Shoe", 34.55f),
                new Item("Shirts", 44.29f),
                new Item("Pants", 64.35f),
                new Item("Jeans", 84.25f),
                new Item("Fan", 51.59f),
                new Item("Iron", 24.45f),
                new Item("Tray", 51.99f),
                new Item("Rice", 24.76f)));
    }
    
    public class Item {
        String name;
        float price;
        
        public Item(String name, float price) {
            this.name = name;
            this.price = price;
        }
        
        public String getName() {
            return name;
        }
        
        public float getPrice() {
            return price;
        }
        
        @Override
        public String toString() {
            return "Item{" + "name=" + name + ", price=" + price + '}';
        }
    }
    
    public String getList() {
        return itemList.toString();
    }
    
    public void addItem(String name, float price) {
        itemList.add(new Item(name, price));
    }
    
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        int membership;
        int discount = 0;
        int totalDiscount;
        int itemQuantity = 0;
        int quantity;
        float total = 0;
        float rebate = 0;
        float totalPayable;
        float amountPaid;
        float price;
        float productTotal;
        
        // Initialize new JTextFields
        JTextField productCode = new JTextField(5);
        JTextField productQuantity = new JTextField(5);   
        
        // Initialize new JPanel
        JPanel productPanel = new JPanel();

        // Add components into new JPanel
        productPanel.add(new JLabel("Product code:"));
        productPanel.add(productCode);
        productPanel.add(Box.createHorizontalStrut(10));
        productPanel.add(new JLabel("Quantity:"));
        productPanel.add(productQuantity);

        TransactionSystem unimyTS = new TransactionSystem("UNIMY Supermarket");
        membership = JOptionPane.showConfirmDialog(null, 
                "Do you have a UNIMY membership card?", 
                "Membership Confirmation", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);
        
        /*
        ==================================================
        Code    Name        Price    Quantity    Total    
        ==================================================
        0002    Shirt       44.29    004         RM 177.16
        0001    Shoe        34.55    005         RM 172.75
        0006    Iron        24.45    004         RM  97.80
        */
        
        System.out.printf("%53s", unimyTS.name + "\n");
        System.out.print(
                "====================================================\n" +
                "Code    Name        Price      Quantity    Total    \n" +
                "====================================================\n");
        String temp = JOptionPane.showInputDialog(null, 
                "Enter the number of products you would like to purchase: ", 
                "Number of Products", 
                JOptionPane.QUESTION_MESSAGE);
        int noOfProducts = Integer.parseInt(temp); // Loop counter
        
        for (int i = 0; i < noOfProducts; i++) {
            // Reset text fields
            productCode.setText("0");
            productQuantity.setText("0");
            
            // Show Product dialog, prompts user to input productCode and 
            // productQuantity
            do {
                if (!isInteger(productQuantity.getText()) || !isInteger(productCode.getText())) {
                    JOptionPane.showMessageDialog(null, 
                            "Invalid input!", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showConfirmDialog(null, 
                        productPanel, 
                        "Product " + (i+1), 
                        JOptionPane.DEFAULT_OPTION, 
                        JOptionPane.PLAIN_MESSAGE);
                
            } while (!isInteger(productQuantity.getText()) || !isInteger(productCode.getText()));
            
            price = unimyTS.itemList.get(Integer.parseInt(productCode.getText())).price;
            quantity = Integer.parseInt(productQuantity.getText());
            
            // Add to total
            productTotal = price * quantity;
            itemQuantity += Integer.parseInt(productQuantity.getText());
            total += productTotal;
            
            // Print to receipt
            System.out.printf("%03d"
                    + "%-5s"
                    + "%-11s "
                    + "RM%7.2f  "
                    + "%3d"
                    + "%9s"
                    + "RM%7.2f\n", 
                    Integer.parseInt(productCode.getText()),
                    "", 
                    unimyTS.itemList.get(Integer.parseInt(productCode.getText())).name, 
                    price,
                    Integer.parseInt(productQuantity.getText()),
                    "    ",
                    productTotal);
            
            // Add to rebate
            if ((   Integer.parseInt(productCode.getText()) == 1  ||
                    Integer.parseInt(productCode.getText()) == 3  ||
                    Integer.parseInt(productCode.getText()) == 4) &&
                    productTotal > 200) {
                rebate += 25;
            }
        }
        
        // Add to discount
        if (total > 2000) discount = 50;
        else if (total > 1000) discount = 30;
        else if (total > 500) discount = 20;
        else if (total > 200) discount = 10;
        
        if (membership == JOptionPane.OK_OPTION) totalDiscount = discount + 10;
        else totalDiscount = discount;
        
        // Compute total payable
        totalPayable = total * (1.06f - (totalDiscount / 100f)) - rebate;
        
        // Print full receipt
        System.out.printf(
                  "====================================================\n"
                + "Items quantity             : %d\n"
                + "Membership                 : " 
                + ((membership == JOptionPane.OK_OPTION) ? "Yes" : "No") +"\n"
                + "Membership discount        : " 
                + ((membership == JOptionPane.OK_OPTION) ? "10%%" : "N/A") + "\n"
                + "Total purchased            : RM %7.2f\n"
                + "Rebates                    : RM %7.2f\n"
                + "Discount                   : %d%%\n"
                + "GST(Government Service Tax): 6%%\n"
                + "====================================================\n"
                + "Net purchased              : RM %7.2f\n", 
                itemQuantity, total, rebate, discount, totalPayable);
        
        // Prompt user for amount paid
        do {
            temp = JOptionPane.showInputDialog(null, 
                    "Please enter the amount paid: ", 
                    "Payment", 
                    JOptionPane.PLAIN_MESSAGE);
            if (!isInteger(temp)) 
                JOptionPane.showMessageDialog(null, 
                        "Invalid value!", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
            else if (Integer.parseInt(temp) < totalPayable) 
                JOptionPane.showMessageDialog(null, 
                        "Amount paid is less than the net purchased!", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
        } while (!isInteger(temp));
        amountPaid = Integer.parseInt(temp);
        
        // Print change and time
        System.out.printf(
                  "Amount paid (Cash)         : RM %7.2f" + "\n"
                + "Change                     : RM %7.2f" + "\n"
                + "====================================================\n"
                + "%52s\n", 
                amountPaid, 
                amountPaid - totalPayable, 
                dtf.format(LocalDateTime.now()));
    }
}
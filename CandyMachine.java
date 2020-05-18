 //Candy Machine Program

package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CandyMachine extends JFrame implements ActionListener{	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static final int WIDTH = 300;
   private static final int HEIGHT = 300;

        //Instance variables
   private CashRegister cashRegister = new CashRegister();
   private DIspenser candy = new DIspenser(100, 50);
   private DIspenser chips = new DIspenser(100, 65);
   private DIspenser gum = new DIspenser(75, 45);
   private DIspenser cookies = new DIspenser(100, 85);

   private JLabel headingMainL;
   private JLabel selectionL;

   private JButton exitB, candyB, chipsB, gumB, cookiesB;
  
   public CandyMachine(){
      setTitle("Candy Machine");      
      setSize(WIDTH, HEIGHT);        

      Container pane  = getContentPane();  
      pane.setLayout(new GridLayout(7,1));

     headingMainL = new JLabel("WELCOME TO SHELLY'S CANDY SHOP",
                              SwingConstants.CENTER);
                                                  
      selectionL = new JLabel("To Make a Selection, "
                            + "Click on the Product Button",
                              SwingConstants.CENTER); 
                                             

      pane.add(headingMainL);   
      pane.add(selectionL);     

      candyB = new JButton("Candy"); 
      
      candyB.addActionListener(this);   
                                            
                                             
      chipsB = new JButton("Chips"); 
                                      
      chipsB.addActionListener(this);  
                                            
                                            
      gumB = new JButton("Gum");     
      gumB.addActionListener(this); 
                                          

      cookiesB = new JButton("Cookies"); 
                                           
      cookiesB.addActionListener(this); 
                              

      exitB = new JButton("Exit");   
      exitB.addActionListener(this); 
                                          

      pane.add(candyB);  
      pane.add(chipsB);     
      pane.add(gumB);      
      pane.add(cookiesB);   
      pane.add(exitB);    

      setVisible(true);  
      setDefaultCloseOperation(EXIT_ON_CLOSE);

   } //end constructor

          //class to handle button events
        public void actionPerformed (ActionEvent e){
          if (e.getActionCommand().equals("Exit"))
              System.exit(0);
          else if (e.getActionCommand().equals("Candy"))
              sellProduct(candy, "Candy");
          else if (e.getActionCommand().equals("Chips"))
              sellProduct(chips, "Chips");
          else if (e.getActionCommand().equals("Gum"))
              sellProduct(gum, "Gum");
          else if (e.getActionCommand().equals("Cookies"))
              sellProduct(cookies, "Cookies");
      }
        //Method to sell a product
   private void sellProduct(DIspenser product, String productName){
     int coinsInserted = 0;
     int price;
     int coinsRequired = product.getProductCost();
     int change = coinsInserted - product.getProductCost();
     
     String str;
     
     try {
     if (product.getCount() > 0){
        price = product.getProductCost();
        coinsRequired = price - coinsInserted;
        

        while (coinsRequired > 0){
            str = JOptionPane.showInputDialog("To buy "
                                  + productName
                                  + " please insert "
                                  + coinsRequired + " cents");
            coinsInserted = coinsInserted
                            + Integer.parseInt(str);
            coinsRequired = price - coinsInserted;
            change = coinsInserted - price;
        }

        CashRegister.acceptAmount(coinsInserted);
        product.makeSale();
        	
        if (change == 1)
        	JOptionPane.showMessageDialog(null,"Your change is " + change + " cent. " + "Please pick up your "
                               + productName + " and enjoy!",
                                "Thank you!",
                               JOptionPane.PLAIN_MESSAGE);
        
        else if (change > 0)
        	JOptionPane.showMessageDialog(null,"Your change is " + change + " cents. " + "Please pick up your "
                               + productName + " and enjoy!",
                                "Thank you!",
                               JOptionPane.PLAIN_MESSAGE);
        
        else 
        	JOptionPane.showMessageDialog(null,"Please pick up your "
                    + productName + " and enjoy!",
                     "Thank you!",
                    JOptionPane.PLAIN_MESSAGE);

  
     }
     else           //dispenser is empty
        JOptionPane.showMessageDialog(null,"Sorry "
                               + productName
                               + " is sold out\n" +
                               "Make another selection",
                               "Thank you!",
                               JOptionPane.PLAIN_MESSAGE);}
     catch (Exception e) {
    	 JOptionPane.showInputDialog(null,"Error: incorrect input. To buy "
                 + productName
                 + " please insert " + coinsRequired +
                 " cents. ",
                 JOptionPane.PLAIN_MESSAGE);}
     }
 
   public static void main(String[] args){
        CandyMachine candyShop = new CandyMachine();
	
}
}
package lab;

public class DIspenser{
    private int numberOfItems;   
    
    private int cost;    

        //Default constructor to set the cost and number of
        //items to the default values
      
    public DIspenser(){
         numberOfItems = 50;
         cost = 50;
    }

        //Constructor with parameters to set the cost and number
        //of items in the dispenser specified by the user
       
    public DIspenser(int setNoOfItems, int setCost){
         if (setNoOfItems >= 0)
             numberOfItems = setNoOfItems;
         else
             numberOfItems = 50;

         if (setCost >= 0)
             cost = setCost;
         else
             cost = 50;
    }

        //Method to show the number of items in the dispenser
     
    public int getCount(){
         return numberOfItems;
    }

        //Method to show the cost of the item
      
    public int getProductCost(){
         return cost;
    }

        //Method to reduce the number of items by 1
      
    public void makeSale(){
        numberOfItems--;
    }
}
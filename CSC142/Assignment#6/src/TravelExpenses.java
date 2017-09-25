import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.DecimalFormat;


/** 
   The TravelExpenses class create the GUI for the 
   Travel Cost calculations.
*/

public class TravelExpenses extends JFrame
{
   private JPanel expensePanel;       //Expenses Panel
   private JPanel buttonPanel; //Button Panel
   private JTextField travTxtField, airTxtField, carTxtField, milTxtField, parkTxtField, 
           taxTxtField, confTxtField, lodgTxtField;
   private JLabel days, airfare,carRental,miles,parkingFees,taxiFees,confReg,lodging;
   private JLabel totExpenses,totAllowed,amtBack;
   private JButton calcButton; //To calculate expenses
   private JButton resetButton;//To reset textFields to empty
   
   private final int WINDOW_WIDTH = 400;  //Set width of GUI
   private final int WINDOW_HEIGHT = 300; //Set height of GUI
   
   /** 
         Constructor
   */
   
   public TravelExpenses()
   {
      //Display the title.
      setTitle("Travel Expenses");
      
      //Specify GUI size
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      //Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
      buildExpensePanel();        //Create expenses panel
      buildButtonPanel();  //Create button panel
      
      //Add the components to the content page.
      add(expensePanel);    
      add(buttonPanel, BorderLayout.SOUTH);
      
      //Pack the contents of the window and display it.
      pack();
      setVisible(true);
   }
   
   /**
      The buildPanel method buils the expenses panel
   */
   private void buildExpensePanel()
   {
      
      days = new JLabel("Number of Days on the trip: ");
      travTxtField = new JTextField(10);
      airfare = new JLabel("Amount of Airfare:");
      airTxtField = new JTextField(10);
      carRental = new JLabel("Amount of car rental:");
      carTxtField = new JTextField(10);
      miles = new JLabel("Miles driven:");
      milTxtField = new JTextField(10);
      parkingFees = new JLabel("Parking fees:");
      parkTxtField = new JTextField(10);
      taxiFees = new JLabel("Taxi Fees:");
      taxTxtField = new JTextField(10);
      confReg = new JLabel("Conference Regisstration:");
      confTxtField = new JTextField(10);
      lodging = new JLabel("Lodging charges per night:");
      lodgTxtField = new JTextField(10);
      
      expensePanel = new JPanel(new GridLayout(9,2));
      
      expensePanel.add(days);
      expensePanel.add(travTxtField);
      expensePanel.add(airfare);
      expensePanel.add(airTxtField);
      expensePanel.add(carRental);
      expensePanel.add(carTxtField);
      expensePanel.add(miles);
      expensePanel.add(milTxtField);
      expensePanel.add(parkingFees);
      expensePanel.add(parkTxtField);
      expensePanel.add(taxiFees);
      expensePanel.add(taxTxtField);
      expensePanel.add(confReg);
      expensePanel.add(confTxtField);
      expensePanel.add(lodging);
      expensePanel.add(lodgTxtField);
   }
   
   private void buildButtonPanel()
   {
      //Create a panel for the buttons
      buttonPanel = new JPanel();
      //Create the buttons
      calcButton = new JButton("Calculate Reimbursement");
      resetButton = new JButton("Reset");
      //Register the action listeners
      calcButton.addActionListener(new CalcButtonListener());
      resetButton.addActionListener(new ResetButtonListener());
      //Add the buttons to the button panel
      buttonPanel.add(calcButton);
      buttonPanel.add(resetButton);
   }
   
   private class CalcButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         String sDays, sAir, sCar, sMiles, sPark, sTaxi, sConf, sLodg;
         double totalExpenses,totalOwed,numOfDays,airFares,carRent,
                milesCost,milesDriven,parkFee,taxiFee,confReg, lodgingFee;
                
         final double TOTAL_ALLOWED = 2091.0;
         final double MILES_FEE = .381;
         
         sDays = travTxtField.getText();
         numOfDays = Double.parseDouble(sDays);
         
         sAir = airTxtField.getText();
         airFares = Double.parseDouble(sAir);
         
         sCar = carTxtField.getText();
         carRent = Double.parseDouble(sCar);
         //Convert miles driven to double
         sMiles = milTxtField.getText();
         milesDriven = Double.parseDouble(sMiles);
         //Convert parking fee to double
         sPark = parkTxtField.getText();
         parkFee = Double.parseDouble(sPark);
         //convert taxi fee to double
         sTaxi = taxTxtField.getText();
         taxiFee = Double.parseDouble(sTaxi);
         //convert conference registration to double
         sConf = confTxtField.getText();
         confReg = Double.parseDouble(sConf);
         //convert lodging fee to double
         sLodg = lodgTxtField.getText();
         lodgingFee = Double.parseDouble(sLodg);
         
         milesCost = milesDriven * MILES_FEE;
         totalExpenses = (numOfDays * lodgingFee) + airFares + carRent+parkFee+taxiFee+confReg+milesCost;
         
         if(totalExpenses > TOTAL_ALLOWED)
            totalOwed = totalExpenses - TOTAL_ALLOWED;
         else
            totalOwed = 0;
            
         DecimalFormat formatter = new DecimalFormat("#,###.00");
         //DecimalFormat formatter2 = new DecimalFormat("00.00");
            
         JOptionPane.showMessageDialog(null,"Total expenses: $" + formatter.format(totalExpenses) + "\nAllowable expenses: $" 
                                   + formatter.format(TOTAL_ALLOWED) + "\n\nAmount to be paid back: $" + formatter.format(totalOwed));         
      }
           
   }
   
   private class ResetButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         travTxtField.setText("");
         airTxtField.setText(""); 
         carTxtField.setText(""); 
         milTxtField.setText(""); 
         parkTxtField.setText(""); 
         taxTxtField.setText(""); 
         confTxtField.setText(""); 
         lodgTxtField.setText("");
      }
   }
   
   public static void main(String[] args)
   {
      new TravelExpenses();
   }
}
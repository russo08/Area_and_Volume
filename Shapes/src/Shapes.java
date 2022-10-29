import javax.swing.JOptionPane;

public class Shapes {
	

	public static void main(String [] args)
	{
		
		String calc, shapeArea, shapeVol; // user inputs
		double area, volume; // calculated values
		
		calc = chooseCalc(); // user chooses the calculation
		
		if(calc.equals("1")) // First choice, Area
		{
			shapeArea = chooseAreaShape(); // user chooses area shape
			area = calcArea(shapeArea); // Area is calculated based on user choice
			displayArea(shapeArea, area); // Area is displayed
			
		}
		
		else if (calc.equals("2")) // Second choice, Volume
		{
			shapeVol = chooseVolShape(); // user chooses volume shape
			volume = calcVol(shapeVol); // Volume is calculated based on user choice
			displayVol (shapeVol, volume); // volume is displayed
		}
		
	}
	

//**************************************************************************************************************
// This section deals with all of the user input prompts
	
	// Prompt user to select what they want to calculate
	public static String chooseCalc()
	{
		String calc_choice = null; // user input
		boolean isValid = false; // choice validity
		
		while(!isValid) // loop until user input is valid
		{
		calc_choice = JOptionPane.showInputDialog(null,"Please type the number of what you would like to calculate:\n" 
				                                  + "1 - Area\n" + "2 - Volume", "Choose a Calculation!",
				                                  JOptionPane.INFORMATION_MESSAGE);
		
		cancelButton(calc_choice);// Exit the program if "Cancel" button is selected

			if(calc_choice.equals("1") || calc_choice.equals("2")) // check if user input is valid
			{
				isValid = true;
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Not a valid option, please try again.", "Warning", 
						  					 JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		return calc_choice; // return user selection as a String
	}
	
	// Prompt the user to select a shape for Area calculation
	public static String chooseAreaShape()
	{
		String area_choice = null; // User input as string
		boolean isValid = false; // choice validity
		boolean isNum = false; // number verification
		int num_choice; // User input as integer
		
		while(!isValid || !isNum) // loop until user input is valid
		{
			area_choice = JOptionPane.showInputDialog(null, "Please type your number selection from the following shapes:\n" +
											  "1 - Triangle\n" + "2 - Parallelogram\n" + "3 - Rectangle\n"
											   + "4 - Trapezoid\n" + "5 - Circle" , "Choose a Shape!", 
											   JOptionPane.INFORMATION_MESSAGE );
		
			cancelButton(area_choice); // Exits the program if "Cancel" button is selected
			isNum = isNumber(area_choice); // Checks if user input is a number
			
			if (isNum)
			{
				num_choice = Integer.parseInt(area_choice); // convert from string to integer
				
				if ((num_choice > 0) && (num_choice <= 5)) // check if user input is within allowed range
				{
					isValid = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Not a valid option, please try again.", "Warning",
												 JOptionPane.INFORMATION_MESSAGE);
				}
			}

		
		}
		return area_choice; // return user selection as a String
	}
			
	
	// Prompt the user to select a shape for Volume calculation
	public static String chooseVolShape()
	{
		String vol_choice = null; // user input as a String
		boolean isValid = false; // input choice validity
		boolean isNum = false; // number verification
		int num_choice; // user input as an integer
		
		while(!isValid || !isNum) // loop until user input is valid
		{
			vol_choice = JOptionPane.showInputDialog(null, "Please type your number selection from the following shapes:\n" +
											  "1 - Cone\n" + "2 - Cylinder\n" + "3 - Rectangular Prism\n"
											   + "4 - Trapeziod Prism\n" + "5 - Sphere", "Choose a Shape!",
											   JOptionPane.INFORMATION_MESSAGE);
		
			cancelButton(vol_choice); // Exit the program if "Cancel" button is selected
			isNum = isNumber(vol_choice); // Check if user input is a number
			
			if (isNum)
			{
				num_choice = Integer.parseInt(vol_choice);
				
				if ((num_choice > 0) && (num_choice <= 5)) // check if user input is within allowed range
				{
					isValid = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Not a valid option, please try again.", "Warning",
												 JOptionPane.INFORMATION_MESSAGE);
				}
			}

		
		}
		return vol_choice; // return user selection as a String
	}

	
//**************************************************************************************************************
// This section deals with the Area of the selected shapes
	
	  /* Take user selected shape as argument and prompt user to 
	   * enter shape dimensions and calculate the corresponding Area
	   */
	public static double calcArea(String choice)
	{
		String height, width, radius, base1, base2, length; // user inputs as a String
		double h = 0, w = 0, r = 0, b1 = 0, b2 = 0, l = 0; // input as a double
		double area = 0; // calculated shape area
		boolean isPos = false; // positive number verification
		boolean isNum = false; // number verification
		
		switch(choice)
		{
		case "1": // First choice Triangle
			while(!isPos || !isNum) // loop until user input is valid
			{
				base1 = JOptionPane.showInputDialog("Enter the Triangle's base in inches.");
				cancelButton(base1);
				isNum = isNumber(base1);
				if(isNum)
				{
					b1 = Double.parseDouble(base1);
					isPos = isPositive(b1);
				}
			
			}
			isPos = false; // reset
			isNum = false; // reset
			
			while(!isPos || !isNum)
			{
				height = JOptionPane.showInputDialog("Enter the Triangle's height in inches");
				cancelButton(height);
				isNum =isNumber(height);
				if(isNum)
				{
					h = Double.parseDouble(height);
					isPos = isPositive (h);
				}
			}
			
			area = (b1 * h) / 2.0; // area calculation of Triangle
			break;
			
		case "2": // Second choice Parallelogram
			while (!isPos || !isNum)
			{
				base1 = JOptionPane.showInputDialog("Enter the Parallelogram's base in inches.");
				cancelButton(base1);
				isNum = isNumber(base1);
				if(isNum)
				{
					b1 = Double.parseDouble(base1);
					isPos = isPositive(b1);
				}
			}
			isNum = false; // reset
			isPos = false; // reset
			
			while (!isPos || !isNum)
			{
				height = JOptionPane.showInputDialog("Enter the Parallelogram's height in inches.");
				cancelButton(height);
				isNum = isNumber(height);
				if (isNum)
				{
					h = Double.parseDouble(height);
					isPos = isPositive(h);
				}
			}
			
			area = b1 * h; // area calculation of Parallelogram
			break;
			
		case "3": // Third choice Rectangle
			while(!isPos || !isNum)
			{
				width = JOptionPane.showInputDialog("Enter the Rectangle's width in inches.");
				cancelButton(width);
				isNum = isNumber(width);
				if (isNum)
				{
					w = Double.parseDouble(width);
					isPos = isPositive(w);
				}
			}
			isPos = false; // reset
			isNum = false; // reset
			
			while(!isPos || !isNum)
			{
				length = JOptionPane.showInputDialog("Enter the Rectangle's length in inches.");
				cancelButton(length);
				isNum = isNumber(length);
				if (isNum)
				{
					l = Double.parseDouble(length);
					isPos = isPositive(l);
				}
			}
			
			area = l * w; // area calculation of Rectangle
			break;
			
		case "4": // Fourth choice Trapezoid 
			while(!isPos || !isNum)
			{
				base1 = JOptionPane.showInputDialog("Enter the Trapezoid's base 1 in inches.");
				cancelButton(base1);
				isNum = isNumber(base1);
				if(isNum)
				{
					b1 = Double.parseDouble(base1);
					isPos = isPositive(b1);
				}
			}
			isNum = false; // reset
			isPos = false; // reset
			
			while(!isPos || !isNum)
			{
				base2 = JOptionPane.showInputDialog("Enter the Trapezoid's base 2 in inches.");
				cancelButton(base2);
				isNum = isNumber(base2);
				if (isNum)
				{
					b2 = Double.parseDouble(base2);
					isPos = isPositive(b2);
				}
			}
			isPos = false; // reset
			isNum = false; // reset
			
			while(!isPos || !isNum)
			{
				height = JOptionPane.showInputDialog("Enter the Trapezoid's height in inches.");
				cancelButton(height);
				isNum = isNumber(height);
				if (isNum)
				{
					h = Double.parseDouble(height);
					isPos = isPositive(h);
				}
			}
			
			area = ((b1 + b2) / 2.0) * h; // area calculation of Trapezoid
			break;
			
		case "5": // Fifth choice Circle
			while(!isPos || !isNum)
			{
				radius = JOptionPane.showInputDialog("Enter the Circle's radius in inches");
				cancelButton(radius);
				isNum = isNumber(radius);
				if (isNum)
				{
					r = Double.parseDouble(radius);
					isPos = isPositive(r);
				}
			}
			
			area = Math.PI * r * r; // area calculated of Circle
			break;
		}
		
		return area; // area calculation of Circle
			
	}
	
	// Display the calculated area along with the name of the selected shape
	public static void displayArea(String choice, double Area)
	{
		switch(choice)
		{
		
		case "1": // First choice Triangle
			JOptionPane.showMessageDialog(null, "The Triangle's area is " + Area + " inches squared.",
											"Calculated Area", JOptionPane.INFORMATION_MESSAGE);
			break;
			
		case "2":  // Second choice Parallelogram
			JOptionPane.showMessageDialog(null, "The Parallelogram's area is " + Area + " inches squared.",
											"Calculated Area", JOptionPane.INFORMATION_MESSAGE);
			break;
			
		case "3": // Third choice Rectangle
			JOptionPane.showMessageDialog(null, "The Rectangle's area is " + Area + " inches squared", 
											"Calculated Area", JOptionPane.INFORMATION_MESSAGE);
			break;
			
		case "4": // Fourth choice Trapezoid
			JOptionPane.showMessageDialog(null, "The Trapezoid's area is " + Area + " inches squared.",
											"Calculated Area", JOptionPane.INFORMATION_MESSAGE);
			break;
			
		case "5": // Fifth choice Circle
			JOptionPane.showMessageDialog(null, "The Circle's area is " + Area + " inches squared.", 
											"Calculated Area", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		
	}
	
//**************************************************************************************************************
// This section deals with the Volume of the selected shapes
  
  /* Take user selected shape as argument and prompt user to 
   * enter shape dimensions and calculate the corresponding Volume
   */
  public static double calcVol(String choice)
  {
	  String height, width, radius, base1, base2, length; // user inputs
	  double h = 0, w = 0, r = 0, b1 = 0, b2 = 0, l = 0; // inputs as type double
	  double vol = 0; // calculated volume
	  boolean isPos = false; // positive number verification
	  boolean isNum = false; // number verification
	  
	  switch (choice)
	  {
	  case "1": // First choice Cone
		  while(!isPos || !isNum) // loop until user input is valid
		  {
			  height = JOptionPane.showInputDialog("Enter the height of the Cone in inches.");
			  cancelButton(height); // check if "Cancel button is selected
			  isNum = isNumber(height); // check if user input is a number
			  if (isNum)
			  {
				  h = Double.parseDouble(height);
				  isPos = isPositive(h);
			  }
		  }
		  isNum = false; // reset
		  isPos = false; // reset
		  
		  while(!isPos || !isNum) // loop until user input is valid
		  {
			  radius = JOptionPane.showInputDialog("Enter the radius of the Cone in inches.");
			  cancelButton(radius);
			  isNum = isNumber(radius);
			  if (isNum)
			  {
				  r = Double.parseDouble(radius);
				  isPos = isPositive(r);
			  }
		  }
		  
		  vol = Math.PI * r * r * (h / 3.0); // volume calculation for Cone
		  break;
		  
	  case "2": // Second choice Cylinder
		  while(!isPos || !isNum)
		  {
			  height = JOptionPane.showInputDialog("Enter the height of the Cylinder in inches.");
			  cancelButton(height);
			  isNum = isNumber(height);
			  if (isNum)
			  {
				  h = Double.parseDouble(height);
				  isPos = isPositive(h);
			  }
		  }
		  isPos = false; // reset
		  isNum = false; // reset
		
		  while(!isPos || !isNum)
		  {
			  radius = JOptionPane.showInputDialog("Enter the radius of the Cylinder in inches.");
			  cancelButton(radius);
			  isNum = isNumber(radius);
			  if (isNum)
			  {
				  r = Double.parseDouble(radius);
				  isPos = isPositive(r);
			  }
		  }
		  
		  vol  =  Math.PI * r * r * h; // volume calculation for Cylinder
		  break;
		  
	  case "3": // Third choice Rectangular Prism
		  while(!isPos || !isNum)
		  {
			  width = JOptionPane.showInputDialog("Enter the Rectangular Prism's width in inches.");
			  cancelButton(width);
			  isNum = isNumber(width);
			  if (isNum)
			  {
				  w = Double.parseDouble(width);
				  isPos = isPositive(w);
			  }
		  }
		  isNum = false; // reset
		  isPos = false; // reset
		  
		  while(!isPos || !isNum)
		  {
			  length = JOptionPane.showInputDialog("Enter the Rectangular Prism's length in inches.");
			  cancelButton(length);
			  isNum = isNumber(length);
			  if (isNum)
			  {
				  l = Double.parseDouble(length);
				  isPos = isPositive(l);
			  }
		  }
		  isNum = false; // reset
		  isPos = false; // reset
		  
		  while(!isPos || !isNum)
		  {
			  height = JOptionPane.showInputDialog("Enter the Rectangular Prism's height in inches.");
			  cancelButton(height);
			  isNum = isNumber (height);
			  if (isNum)
			  {
				  h = Double.parseDouble(height);
				  isPos = isPositive(h);
			  }
		  }
		  
		  vol = w * l * h; // volume calculation for Rectangular Prism
		  break;
		  
	  case "4": // Fourth choice Trapezoidal Prism
		  while(!isPos || !isNum)
		  {
			  base1 = JOptionPane.showInputDialog("Enter the Trapezoidal Prism's base 1 in inches.");
			  cancelButton(base1);
			  isNum = isNumber (base1);
			  if (isNum)
			  {
				  b1 = Double.parseDouble(base1);
				  isPos = isPositive(b1);
			  }
		  }
		  isNum = false; // reset
		  isPos = false; // reset
		  
		  while(!isPos || !isNum)
		  {
			  base2 = JOptionPane.showInputDialog("Enter the Trapezoidal Prism's base 2 in inches.");
			  cancelButton(base2);
			  isNum = isNumber (base2);
			  if (isNum)
			  {
				  b2 = Double.parseDouble(base2);
				  isPos = isPositive(b2);
			  }
		  }
		  isNum = false; // reset
		  isPos = false; // reset
		  
		  while(!isPos || !isNum)
		  {
			  height = JOptionPane.showInputDialog("Enter the Trapezoidal Prism's height in inches.");
			  cancelButton(height);
			  isNum = isNumber(height);
			  if (isNum)
			  {
				  h = Double.parseDouble(height);
				  isPos = isPositive(h);
			  }
		  }
		  isPos = false; // reset
		  isNum = false; // reset
		  
		  while(!isPos || !isNum)
		  {
			  length = JOptionPane.showInputDialog("Enter the Trapezoidal Prism's height in inches.");
			  cancelButton(length);
			  isNum = isNumber (length);
			  if (isNum)
			  {
				  l = Double.parseDouble(length);
				  isPos = isPositive(l);
			  }
		  }
		  
		  vol = ((b1 + b2) / 2.0) * h * l; // volume calculation for Trapezoidal Prism
		  break;
		  
	  case "5": // Fifth choice Sphere
		  while(!isPos || !isNum)
		  {
			  radius = JOptionPane.showInputDialog("Enter the Sphere's radius in inches.");
			  cancelButton(radius);
			  isNum = isNumber (radius);
			  if (isNum)
			  {
				  r = Double.parseDouble(radius);
				  isPos = isPositive(r);
			  }
		  }
		  
		  vol = (4.0 / 3.0) * Math.PI * r * r * r; // volume calculation for Sphere
		  break;
		  
	  }
	  
	  return vol;
	  
  }
  
  // Displays the calculated volume with corresponding shape
  public static void displayVol (String choice, double vol)
  {
	 switch (choice)
	 {
	 case "1": // First choice Cone
		 JOptionPane.showMessageDialog(null, "The Cone's volime is " + vol + " inches cubed.", 
				 						"Calculated Volume", JOptionPane.INFORMATION_MESSAGE);
		 break;
		 
	 case "2": // Second choice Cylinder
		 JOptionPane.showMessageDialog(null, "The Cylinder's volume is " + vol + " inches cubed.", 
				 							"Calculated Volume", JOptionPane.INFORMATION_MESSAGE);
		 break;
		 
	 case "3": // Third choice Rectangular Prism
		 JOptionPane.showMessageDialog(null, "The Rectangular Prism's volume is " + vol + " inches cubed.",
				 						"Calculated Volume", JOptionPane.INFORMATION_MESSAGE);
		 break;
		 
	 case "4": // Fourth choice Trapezoidal Prism
		 JOptionPane.showMessageDialog(null, "The Trapezoidal Prism's volume is " + vol + " inches cubed.",
				 						"Calculated Volume", JOptionPane.INFORMATION_MESSAGE);
		 break;
		 
	 case "5": // Fifth choice Sphere
		 JOptionPane.showMessageDialog(null, "The Circle's volume is " + vol + " inches cubed.",
				 						"Calculated Volume", JOptionPane.INFORMATION_MESSAGE);
		 break;
		 
	 }
  }
  
//**************************************************************************************************************
// This section does all the verification processes and handles the "Cancel" button in JOptionPane  
  
  // Verify whether or not user input is a positive number
  public static boolean isPositive(double input)
  {
	  boolean isPos = false; // positive number verification
	  if( input < 0)
	  {
		  JOptionPane.showMessageDialog (null, "Number must be positive, please re-enter the dimension", "Warning",
				                         JOptionPane.INFORMATION_MESSAGE);
	  }
	  else 
	  {
		  isPos = true;
	  }
	  return isPos;
  }
  
  // Verify whether or not user input is a number
  public static boolean isNumber(String input)
  {
	  boolean isNum = false; // input number verification
	  try
	  {
		  Integer.parseInt(input);
		  isNum = true;
	  }
	  
	  catch (NumberFormatException e)
	  {
		  JOptionPane.showMessageDialog(null, "Entry is not a number, please try again.", "Warning",
				  						JOptionPane.INFORMATION_MESSAGE);
	  }
	  return isNum;
  }
  
  //Exit the program if the user selects the "Cancel" button
  public static void cancelButton(String input)
  {
	  if(input == null)
	  {
		  System.exit(0);
	  }
  }
	
}
/**
This class accepts input through the scanner.
Veneza Vielle V. Vergara (226676)
December 05, 2022
**/
/*
I have not discussed the Java language code in my program 
with anyone other than my instructor or the teaching assistants 
assigned to this course.

I have not used Java language code obtained from another student, 
or any other unauthorized source, either modified or unmodified.

If any Java language code or documentation used in my program 
was obtained from another source, such as a textbook or website, 
that has been clearly noted with a proper citation in the comments 
of my program.
*/
import java.util.Scanner;

public class TrackerConsole {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LifestyleTracker lifestyletracker = new LifestyleTracker();

		//if the input is not report
		String stringone = in.next();
		while(!stringone.equalsIgnoreCase("Report")) {
			
			//adds food to food list
			if(stringone.equalsIgnoreCase("Food")) {
				//accepts food name
				String stringtwo = in.next();
				//accepts calories
				double doubleone = in.nextDouble();
				//places food name and calories in the parameters of addFood method
				System.out.println(lifestyletracker.addFood(stringtwo,doubleone));
			
			}else if(stringone.equalsIgnoreCase("Activity")) {
				String stringtwo = in.next();
				double doubleone = in.nextDouble();
				System.out.println(lifestyletracker.addActivity(stringtwo,doubleone));
			
			//adds activity to performed activities list
			}else if(stringone.equalsIgnoreCase("Perform")) {
				//accepts activity name
				String stringtwo = in.next();
				//accepts hours
				double doubleone = in.nextDouble();

				if(lifestyletracker.perform(stringtwo,doubleone).equalsIgnoreCase("The specified activity does not exist.")){
					System.out.println("Would you like to create an activity item? Yes or No <3");
					String stringthree = in.next();

					//adds new activity to activity list accepting the name and calories & calls the perform method on the activity
					if(stringthree.equalsIgnoreCase("Yes")){
						System.out.println("How many calories are in this activity item? <3");
						double activitycalorie = in.nextDouble();
						System.out.println(lifestyletracker.addActivity(stringtwo, activitycalorie));
						System.out.println(lifestyletracker.perform(stringtwo, doubleone));
					}
				}else{
					//calls the perform method on activity
					System.out.println(lifestyletracker.perform(stringtwo, doubleone));
				}
	
			}else if(stringone.equalsIgnoreCase("Eat")) {
				String stringtwo = in.next();
				double doubleone = in.nextDouble();

				if(lifestyletracker.eat(stringtwo,doubleone).equalsIgnoreCase("The specified food does not exist.")){
					System.out.println("Would you like to create a food item? Yes or No <3");
					String stringthree = in.next();
					
					if(stringthree.equalsIgnoreCase("Yes")){
						System.out.println("How many calories are in this food item? <3");
						double foodcalorie = in.nextDouble();
						System.out.println(lifestyletracker.addFood(stringtwo, foodcalorie));
						System.out.println(lifestyletracker.eat(stringtwo, doubleone));
					}
				}else{
					System.out.println(lifestyletracker.eat(stringtwo, doubleone));
				}

			}else if(stringone.equalsIgnoreCase("Delete")) {
				System.out.println("Would you like to delete a record of food eaten or activity performed? Yes or No <3");
				String stringfour = in.next();
				if(stringone.equalsIgnoreCase("Yes")) {
					System.out.println("Type 'food' to delete food eaten or type 'activity' to delete activity performed! <3");
					String stringfive = in.next();
					if(stringfive.equalsIgnoreCase("food")){
						System.out.println("Which index is the food positioned?");
						Integer integerone = in.nextInt();
						System.out.println("Record of food eaten has been deleted! <3");
						//https://www.geeksforgeeks.org/removing-element-from-the-specified-index-in-java-arraylist/
						lifestyletracker.consumedfoodlist.remove(integerone);
						lifestyletracker.consumedfoodservings.remove(integerone);
					}else if(stringfive.equalsIgnoreCase("activity")){
						System.out.println("Which index is the activity positioned?");
						Integer integerone = in.nextInt();
						System.out.println("Record of activity performed has been deleted! <3");
						lifestyletracker.performedactivitieslist.remove(integerone);
						lifestyletracker.performedactivitieshours.remove(integerone);
					}
				}
			}
			stringone = in.next();
		}
		lifestyletracker.report();
	}
}
/**
This class uses array lists to record and report the food and activities.
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
import java.util.*;

public class LifestyleTracker {

    public ArrayList <Food> foodlist;
    public ArrayList <Food> consumedfoodlist;
    public ArrayList <Double> consumedfoodservings;
    public Double caloriesconsumed = 0.00;
    public Double totalcaloriesconsumed = 0.00;

    public ArrayList <Activity> activitylist;
    public ArrayList <Activity> performedactivitieslist;
    public ArrayList <Double> performedactivitieshours;
    public Double caloriesperformed = 0.00;
    public Double totalcaloriesperformed = 0.00;

    public Double netcalories = 0.00;
    public String it = "";

    //initializing array lists
	public LifestyleTracker() {
        //list of foods put in the system
        foodlist = new ArrayList<>();
        //list of activities put in the system
        activitylist = new ArrayList<>();
        //list of foods eaten (name + calories)
        consumedfoodlist = new ArrayList<>();
        //list of activities performed (name + calories)
        performedactivitieslist = new ArrayList<>();
        //list of servings of food eaten
        consumedfoodservings = new ArrayList<>();
        //list of hours of activities performed
        performedactivitieshours = new ArrayList<>(); 
	}

    //adds food to system
    public String addFood(String n, double c) {
        //checks through the list of food in the system if name of food is already there
        for(int x = 0; x < foodlist.size(); x++) {
            //if food name is already in system
            if(foodlist.get(x).getFoodName().equalsIgnoreCase(n)) {
                //it updates the calories
                foodlist.get(x).updateCalories(c);
                //formats to two decimal spaces
                it = String.format("Updated Food %s with %.2f kcal",n,c);
                return it;
            }
        }
        //if it is not in food list, it adds the food to system
        foodlist.add(new Food(n,c));
        it = String.format("Added Food %s with %.2f kcal",n,c);
        return it;
    }

    public String addActivity(String n, double c) {
        for(int x = 0; x < activitylist.size(); x++) {
            if(activitylist.get(x).getActivityName().equals(n)) {
                foodlist.get(x).updateCalories(c);
                it = String.format("Updated Activity %s with %.2f kcal",n,c);
                return it;
            }
        }
        activitylist.add(new Activity(n,c));
        it = String.format("Added Activity %s with %.2f kcal",n,c);
        return it;
    }

    //means user ate food
    public String eat(String foodName, double servings) {
        //checks through the list of food in the system if name of food is already there
        for(int x = 0; x < foodlist.size(); x++) {
            //if food name is already in system
            if(foodlist.get(x).getFoodName().equalsIgnoreCase(foodName)) {
                //and if it is not a negative serving
                if(servings >= 0) {
                    //calories consumed variable computes for the calories multiplied to the servings
                    caloriesconsumed = foodlist.get(x).getFoodCalories() * servings; 
                    //adds to total amount of calories consumed 
                    totalcaloriesconsumed += caloriesconsumed;
                    //adds eaten food to consumed food list
                    consumedfoodlist.add(new Food (foodName,caloriesconsumed));
                    //adds number of servings to consumed food servings list
                    consumedfoodservings.add(servings);
                    //to format into 2 decimal places
                    it = String.format("Ate %.2f serving(s) of %s, %.2f kcal",servings,foodName,caloriesconsumed);
                    return it;
                }else{
                    //if negative, returns this
                    return ("Number of servings cannot be negative.");
                }
            }
        }
        return ("The specified food does not exist.");
    }

    public String perform(String actName, double hours) {
        for(int x = 0; x < activitylist.size(); x++) {
            if(activitylist.get(x).getActivityName().equalsIgnoreCase(actName)) {
                if(hours >= 0) {
                    caloriesperformed = activitylist.get(x).getActivityCalories() * hours;
                    totalcaloriesperformed += caloriesperformed;
                    performedactivitieslist.add(new Activity (actName,caloriesperformed));
                    performedactivitieshours.add(hours);
                    it = String.format("Performed %.2f hour(s) of %s, %.2f kcal",hours,actName,caloriesperformed);
                    return it;
                }else{
                    return ("Number of hours cannot be negative.");
                }
            }
        }
        return ("The specified activity does not exist.");
    }
    //displays all the recorded items
    public String report() {
        System.out.println("----------------");
        System.out.println("LIFESTYLE REPORT");
        System.out.println("----------------");
        System.out.println("Food Consumed:");
        //goes through all the items in the list of consumed food in the system
        for(int x = 0; x < consumedfoodlist.size(); x++) {
            System.out.printf("%.2f serving(s) of %s, %.2f kcal\n",consumedfoodservings.get(x),consumedfoodlist.get(x).getFoodName(),consumedfoodlist.get(x).getFoodCalories());
        }
        System.out.println("----------------");
        System.out.printf("Total Calories Consumed: %.2f kcal\n",totalcaloriesconsumed);
        System.out.println("----------------");
        System.out.println("Activity Performed:");
        for(int x = 0; x < performedactivitieslist.size(); x++) {
            System.out.printf("%.2f hour(s) of %s, %.2f kcal\n",performedactivitieshours.get(x),performedactivitieslist.get(x).getActivityName(),performedactivitieslist.get(x).getActivityCalories());
        }
        System.out.println("----------------");
        System.out.printf("Total Calories Burned: %.2f kcal\n",totalcaloriesperformed);
        System.out.println("----------------");
        netcalories = totalcaloriesconsumed - totalcaloriesperformed;
        System.out.printf("Net Calories for the Day: %.2f kcal\n",netcalories);
        System.out.println("If you keep up this lifestyle...");
        //if it is positive, the use gains calories in the future
        if(netcalories>0){
            //1 calorie is equal to .00012959782 kilograms
            double gainedkilograms = netcalories * .00012959782;
            System.out.printf("In a week, you will gain %.2f kilograms.\n",gainedkilograms * 7);
            System.out.printf("In a month, you will gain %.2f kilograms.\n",gainedkilograms * 30);
            System.out.printf("In 3 months, you will gain %.2f kilograms.\n",gainedkilograms * 90);
            System.out.printf("In 6 months, you will gain %.2f kilograms.\n",gainedkilograms * 180);
        }else if(netcalories<0){
            double lostkilograms = netcalories * .00012959782;
            System.out.printf("In a week, you will lose %.2f kilograms.\n",lostkilograms * 7);
            System.out.printf("In a month, you will lose %.2f kilograms.\n",lostkilograms * 30);
            System.out.printf("In 3 months, you will lose %.2f kilograms.\n",lostkilograms * 90);
            System.out.printf("In 6 months, you will lose %.2f kilograms.\n",lostkilograms * 180);
        }
        System.out.println("----------------");
        return("");
    }
}

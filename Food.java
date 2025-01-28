/**
This class represents one food item.
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
public class Food {
    private String foodname;
    private double foodcalorie;

    //initializes name of food and calories
    public Food(String f, double c) {
       foodname = f;
       foodcalorie = c ;
    }

    public String getFoodName() {
        return foodname;
    }

    public double getFoodCalories() {
        return foodcalorie;
    }

    //updates food calories with c
    public void updateCalories(double c) {
        foodcalorie = c;
    }

}
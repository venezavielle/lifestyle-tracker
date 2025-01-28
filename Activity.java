/**
This class represents one activity item.
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
public class Activity {
    private String activityname;
    private double activitycalorie;

    public Activity(String n, double c) {
        activityname = n;
        activitycalorie = c ;
    }

    public String getActivityName() {
        return activityname;
    }

    public double getActivityCalories() {
        return activitycalorie;
    }

    public void updateCalories(double c) {
        activitycalorie = c;
    }

}
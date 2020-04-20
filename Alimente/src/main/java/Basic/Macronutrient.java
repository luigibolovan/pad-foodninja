package Basic;

public class Macronutrient {
    private String macroName;
    private double grams;
    private double calories;

    public Macronutrient(String macroName, double grams) {
        this.macroName = macroName;
        this.grams = grams;
        this.calories = calorieSet();
    }

    public String toString() {
        return macroName + ": " + grams + "g";
    }

    public double calorieSet() {
        double c = 0;
        if(macroName == "Fat")
            c = grams * 9;
        else c = grams * 4;

        return c;
    }

    public double retCalories() {
        return calories;
    }
}

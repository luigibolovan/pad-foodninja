package Basic;
import java.io.Serializable;

public class Aliment implements Serializable{
    private Macronutrient fat, carbohidrate, protein;
    private String numeAliment;
    private double calories;

    public Aliment(String numeAliment, double fatGrams, double carbohidrateGrams, double proteinGrams) {
        this.numeAliment = numeAliment;
        this.fat = new Macronutrient("Fat", fatGrams);
        this.carbohidrate = new Macronutrient("Carbohidrates", carbohidrateGrams);
        this.protein = new Macronutrient("Protein", proteinGrams);
        this.calories = fat.retCalories() + carbohidrate.retCalories() + protein.retCalories();
    }

    public String toString() {
        return numeAliment + "->" + calories + " kcal" + " (" + protein + ", " + carbohidrate + ", " + fat + ");";
    }
    public String getName(){
        return numeAliment;
    }
}

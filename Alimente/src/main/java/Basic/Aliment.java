package Basic;

public class Aliment {
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
        return numeAliment + "->" + calories + " kcal" + " (" + fat + ", " + carbohidrate + ", " + protein + ");";
    }
}

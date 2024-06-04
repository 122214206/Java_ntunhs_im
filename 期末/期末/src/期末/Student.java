package 期末;
import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private double height;
    private double weight;
    private double bmi;
    
    public Student(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.bmi = calculateBMI();
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getBmi() {
        return bmi;
    }
    
    private double calculateBMI() {
        // BMI = weight (kg) / (height (m) ^ 2)
        return weight / (height * height);
    }

    @Override
    public String toString() {
        return " [name:" + name + " height:" + height + " weight:" + weight + " bmi:" + String.format("%.2f", bmi) + "]";
    }
}
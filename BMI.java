import java.util.Scanner;



class BMI {

    private double height;
    private double weight;

    private double BMIValue;
    private BMIInterpretation BMI;
    
    // Would this be close to inner class concept? Enums are a special type of class...
    private enum BMIInterpretation {
        UNDERWEIGHT(18.5),
        NORMAL(25),
        OVERWEIGHT(30),
        OBESE(Double.POSITIVE_INFINITY);
    
        private final double threshold;
    
        public double getValue() {
            return threshold;
        }
    
        BMIInterpretation(double threshold) {
            this.threshold = threshold;
        }
    }

    public double getHeight() {
        return height;
    }
    
    private BMIInterpretation getBMI() {
        return this.BMI;
    }

    public double getBMIValue() {
        return BMIValue;
    }

    public void setBMIValue(double BMIValue) {
        this.BMIValue = BMIValue;
    }

    public void setBMI() {
        if(this.BMIValue < BMIInterpretation.UNDERWEIGHT.getValue()) this.BMI = BMIInterpretation.UNDERWEIGHT;
        else if(this.BMIValue < BMIInterpretation.NORMAL.getValue()) this.BMI = BMIInterpretation.NORMAL;
        else if(this.BMIValue < BMIInterpretation.OVERWEIGHT.getValue()) this.BMI = BMIInterpretation.OVERWEIGHT;
        else this.BMI = BMIInterpretation.OBESE;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    public BMI(double height, double weight) {
        this.setHeight(height);
        this.setWeight(weight);
        this.setBMIValue(weight / (height * height));
        this.setBMI();
    }

    
    final static class UnitConverter {
        final static double poundToKg(double pounds) {
            return pounds * 0.45359237;
        }
        
        final static double inchToMeter(double inches) {
            return inches * 0.0254;
        }
    }



    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter weight in pounds: ");
        double weight = UnitConverter.poundToKg(reader.nextDouble());
        System.out.print("Enter height in inches: ");
        double height = UnitConverter.inchToMeter(reader.nextDouble());
        reader.close();

        BMI myBMI = new BMI(height, weight);
        
        System.out.println("BMI is " + myBMI.getBMIValue());
        System.out.println(myBMI.getBMI());
    
        // System.out.printf("my weight is %.3f%n", myBMI.getWeight());
        // System.out.printf("my height is %.3f%n", myBMI.getHeight());
        // System.out.printf("my BMI is %.3f%n", myBMI.getBMIValue());
        
        // System.out.println("my BMI interpretation is " + myBMI.getBMI());
        
        // System.out.printf("Your weight is %.3f%n", yourBMI.getWeight());
        // System.out.printf("Your height is %.3f%n", yourBMI.getHeight());
        // System.out.printf("Your BMI is %.3f%n", yourBMI.getBMIValue());
        // System.out.println("Your BMI interpretation is " + yourBMI.getBMI());
        
        // System.out.println("Is your BMI lower than mine?: " + (yourBMI.getBMIValue() < myBMI.getBMIValue()));
    }
}
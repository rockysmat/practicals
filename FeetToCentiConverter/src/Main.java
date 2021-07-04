public class Main {

    public static void main(String[] args) {
        System.out.println("15 feet, 7 inches to centimeters is: " + calcFeetAndInchesToCentimeters(15,19));
        System.out.println("117 inches to centimeters is: " + calcFeetAndInchesToCentimeters(119));
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        double returnValue;
        if(feet <= 0 || inches <= 0 || inches >= 12){
            returnValue = -1;
        } else {
            returnValue = (feet * 12 + inches) * 2.54;
        }
        return returnValue;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        double returnValue;
        if(inches <= 0) {
            returnValue = -1;
        } else {
           int feet = (int) inches / 12;
            inches %= 12d;
           returnValue = calcFeetAndInchesToCentimeters(feet, inches);
        }
        return returnValue;
    }
}

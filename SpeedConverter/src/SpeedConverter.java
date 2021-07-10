public class SpeedConverter {
    private static final double kmPerHourToMilesPerHourRate  = 0.621371d;
    public static void main(String[] args) {
        double kmPerHour = -7d;
        System.out.println(kmPerHour + "KM/H to Miles/Hour =" +toMilesPerHour(kmPerHour));
        printConversion(kmPerHour);
    }

    public static void printConversion(double kilometersPerHour){
        if(kilometersPerHour >= 0){
            System.out.println(kilometersPerHour +" km/h = " +toMilesPerHour(kilometersPerHour)+ " mi/h");
        }
        else
            System.out.println("Invalid Value");
    }

    public static long toMilesPerHour(double kilometersPerHour){
        double returnValue = -1d;
        if (!(kilometersPerHour < 0)) {
            returnValue = (kilometersPerHour * kmPerHourToMilesPerHourRate);
            returnValue = Math.round(returnValue);
        }
        return (long) returnValue;
    }
}

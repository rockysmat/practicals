public class SpeedConverter {
    private static final double kmPerHourToMilesPerHourRate  = 0.621371d;
    public static void main(String[] args) {
        double kmPerHour = 10.25d;
        System.out.println(kmPerHour + "KM/H to Miles/Hour =" +toMilesPerHour(kmPerHour));
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

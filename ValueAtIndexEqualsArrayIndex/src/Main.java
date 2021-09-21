import java.util.Arrays;

public class Main {
    static int[] givenArray = {-5, -3, 0, 3, 4, 5, 9};
    public static void main(String[] args) {
        System.out.println("Min index that is equal to value of array at the index is: \n" +
                valueAtIndexEqualsArrayValue(givenArray));
    }

    private static int valueAtIndexEqualsArrayValue(int[] givenArray) {
        Arrays.sort(givenArray);
        int temp = 0, start = 0, end = givenArray.length - 1;
        int mid = (start + end) / 2;

        while(start <= end) {
            if(mid <= givenArray[mid]){
                end = mid;
                temp = givenArray[mid];
                start++;
            }
            else if(mid > givenArray[mid]){
                start = mid;
                temp = givenArray[mid];
                start++;
            }
        }

        for(int i=0; i<givenArray.length; i++){
            if(i == givenArray[i])
                return givenArray[i];
        }
        return -1;
    }
}

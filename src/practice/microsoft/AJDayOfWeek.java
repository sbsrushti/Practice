package practice.microsoft;

public class AJDayOfWeek {

    public static void main(String[] args) {

        String[] arr = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        String str = "Sat";
        int k = 23;
        int i;
        for (i = 0; i < arr.length; i++) {
            if (str.equals(arr[i])) break;
        }

        System.out.println(arr[(i+k)%7]);
    }
}

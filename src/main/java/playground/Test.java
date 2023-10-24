package playground;


import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Test {

    public static void main(String[] args) {
        int num, temp, digit, count = 0;
        UUID uuid = UUID.randomUUID();
        int uniqueNumber = uuid.hashCode();
        String uniqueNumberString = String.format("%014d", uniqueNumber);

        String randomValue = "VmsOmsEwaytxn";
        //randomValue = randomValue.concat(Long.toString(¸));
        //getting the number from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any number:");
        num = scanner.nextInt();
        scanner.close();

        //making a copy of the input number
        temp = num;

        //counting digits in the input number
        while(num > 0)
        {
            num = num / 10;
            count++;
        }
        while(temp > 0)
        {
            digit = temp % 10;
            System.out.println("Digit at place "+count+" is: "+digit);
            temp = temp / 10;
            count--;
        }
    }



}

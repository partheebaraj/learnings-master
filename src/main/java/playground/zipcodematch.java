package playground;

import java.util.Scanner;

/**
 * @author Partheebaraj.Sankarlal
 * @project learnings-master
 */
public class zipcodematch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Zip Code:");
		String zipCode = sc.next();

		//Check if the zip code is in 625***, 624*** series
		if(zipCode.matches("(624|625)\\d\\d\\d")) {
			System.out.println("Order Accepted");
		}
		else {
			System.out.println("Order Rejected");
		}
	}
}
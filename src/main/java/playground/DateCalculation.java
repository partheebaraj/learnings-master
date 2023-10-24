package playground;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Partheebaraj.Sankarlal
 * @project learnings-master
 */
public class DateCalculation {


	public static void main(String[] args) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date currentDate = Calendar.getInstance().getTime();
		Date createdDate = null;
		int priority = 0;

		try {
			createdDate = dateFormat.parse("2022-12-12T11:45:00");
			long diffInMilliseconds = currentDate.getTime() - createdDate.getTime();
			long diffInSeconds = diffInMilliseconds / 1000;
			long diffInMinutes = diffInSeconds / 60;
			long diffInHours = diffInMinutes / 60;
			long diffInDays = diffInHours / 24;

			if (diffInDays >= 2 && diffInDays <= 3) {
				priority = 2;
			} else if (diffInDays >= 1 && diffInDays < 2) {
				priority = 1;
			} else if (diffInDays < 1) {
				priority = 4;
			} else if(diffInDays>3){
				priority=1;
			}

			System.out.println("Difference in Days: " + diffInDays);
			System.out.println("Priority: " + priority);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
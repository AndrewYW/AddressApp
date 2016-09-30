/**
 * Helper class used to convert between LocalDate and String types
 */

package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

	private static final String DATE_PATTERN = "dd.MM.yyyy";
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
	
	/**
	 * Returns given date as String.
	 * @param date
	 * @return formatted String
	 */
	public static String format(LocalDate date) {
		if (date == null) {
			return null;
		}
		return DATE_FORMATTER.format(date);
	}
	
	/**
	 * Converts string in correct DATE_PATTERN format into LocalDat object
	 * @param dateString
	 * @return date object, or null if wrong format
	 */
	public static LocalDate parse(String dateString) {
		try {
			return DATE_FORMATTER.parse(dateString, LocalDate::from);
		} catch (DateTimeParseException e) {
			return null;
		}
	}
	
	public static boolean validDate(String dateString) {
		return DateUtil.parse(dateString) != null;
	}
}

package fr.imie.contact;

import java.time.*;
import java.time.format.*;

public class DateUtils {

  public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public static LocalDate toLocalDate(String text) {
    if (text == null || text.isEmpty()) {
      return null;
    }
    LocalDate date = LocalDate.parse(text, formatter);
    return date;
  }

}

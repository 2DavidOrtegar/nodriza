package app.support.utils;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class WorkWithDates {
    private LocalDate auxDate = LocalDate.now();

    public void addDays(int days) {
        auxDate = auxDate.plusDays(days);
    }

    public void subtractDays(int days) {
        auxDate = auxDate.minusDays(days);
    }

    public void setDate(String date) {
        auxDate = LocalDate.parse(date);
    }

    public String getNameMonthEsp() {
        return auxDate.getMonth().getDisplayName(TextStyle.FULL, new Locale("es","ES"));
    }

    public String getShortNameMonthEsp() {
        return auxDate.getMonth().getDisplayName(TextStyle.FULL, new Locale("es","ES")).substring(0,3);
    }

    public String getMonth() {
        return auxDate.getMonth().toString();
    }

    public String getDay() {
        return String.valueOf(auxDate.getDayOfMonth());
    }

    public String getYear() {
        return String.valueOf(auxDate.getYear());
    }

    public LocalDate getAuxDate() {
        return auxDate;
    }

}

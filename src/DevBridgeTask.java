import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DevBridgeTask {

    public static LocalDate getDateOfFirstDayOfYear(int year) {
        Year y = Year.parse(Integer.toString(year));
        return y.atDay(1);
    }

    public static List<String> getListOfDatesBetweenYears(int fromYear, int toYear) {
        LocalDate startDate = getDateOfFirstDayOfYear(fromYear);
        LocalDate endDate = getDateOfFirstDayOfYear(toYear);
        List<LocalDate> listOfDates = startDate.datesUntil(endDate)
                .collect(Collectors.toList());
        List<String> listOfFormattedDates = new ArrayList<>();
        for (LocalDate d : listOfDates) {
            String s = d.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            listOfFormattedDates.add(s);
        }
        return listOfFormattedDates;
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        List<String> listOfDates = getListOfDatesBetweenYears(fromYear, toYear);
        for (String date : listOfDates) {
            StringBuilder reversedDate = new StringBuilder();
            reversedDate.append(date).reverse();
            if (date.equals(reversedDate.toString())) {
                System.out.println(date.substring(0, 4) + '-' + date.substring(4, 6) + '-' + date.substring(6, 8));
            }
        }
    }

    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }
}

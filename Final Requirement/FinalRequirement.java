import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FinalRequirement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a comma-separated list of signed and unsigned floating-point numbers:");
        String input = sc.nextLine();

        List<Double> floatingPointList = processInput(input);

        System.out.println("Processed List: ");
        System.out.println(formatList(floatingPointList));

        System.out.println("Do you want to run again? (yes/no)");
        String runAgain = sc.nextLine().toLowerCase();
        if (runAgain.equalsIgnoreCase("yes")) {
            main(args);
        } else {
            System.out.println("Exiting the program. Goodbye!");
        }
    }

    private static List<Double> processInput(String input) {
        List<Double> floatingPointList = new ArrayList<>();

        String[] numbers = input.split(", ");
        if (containsMissingComma(numbers)) {
            System.out.println("Invalid input. Use comma to separate list of floating numbers!");
            return processInput(new Scanner(System.in).nextLine());
        }

        if (containsInvalidInput(numbers)) {
            System.out.println("Invalid input. There Should be no Alphabetic or Special Characters!");
            return processInput(new Scanner(System.in).nextLine());
        }

        for (String number : numbers) {
            try {
                double parsedNumber = Double.parseDouble(number);
                if (!isWholeNumber(parsedNumber)) {
                    floatingPointList.add(parsedNumber);
                } else {
                    System.out.println("Invalid input. Must be decimal numbers. Please enter the list again!");
                    return processInput(new Scanner(System.in).nextLine());
                }
            } catch (NumberFormatException e) {

            }
        }
        floatingPointList.removeIf(number -> countDecimalPlaces(number) > 2);

        //Selection Sort
        for (int i = 0; i < floatingPointList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < floatingPointList.size(); j++) {
                if (floatingPointList.get(j) < floatingPointList.get(minIndex)) {
                    minIndex = j;
                }
            }
            double temp = floatingPointList.get(minIndex);
            floatingPointList.set(minIndex, floatingPointList.get(i));
            floatingPointList.set(i, temp);
        }

        return floatingPointList;
    }

    private static boolean containsMissingComma(String[] numbers) {
        return numbers.length < 2;
    }

    private static boolean containsInvalidInput(String[] numbers) {
        for (String number : numbers) {
            if (!number.matches("^[-+]?\\d*\\.?\\d+$")) {
                return true;
            }
        }
        return false;
    }

    private static boolean isWholeNumber(double number) {
        return number % 1 == 0;
    }

    private static boolean isValidDecimalPlaces(double number) {
        return String.valueOf(number).matches("^[-+]?\\d*\\.?\\d{0,2}$");
    }

    private static int countDecimalPlaces(double number) {
        String[] parts = String.valueOf(number).split("\\.");
        return parts.length > 1 ? parts[1].length() : 0;
    }

    private static String formatList(List<Double> list) {
        StringBuilder formattedList = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            formattedList.append(list.get(i));
            if (i < list.size() - 1) {
                formattedList.append(", ");
            }
        }
        return formattedList.toString();
    }
}

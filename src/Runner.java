import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = null;
        int errorLines = 0;
        double sum = 0;
        StringBuilder builder = new StringBuilder(Constants.RESULT);
        try {
            scanner = new Scanner(new FileReader(Constants.FILE_NAME));
            scanner.useLocale(Locale.ENGLISH);
            while (scanner.hasNextLine()) {
                try {
                    double number = findNumberInLine(scanner);
                    sum += number;
                    if (number >= Constants.ZERO){
                        builder.append(Constants.PLUS);
                        builder.append(number);
                    }else {
                        builder.append(Constants.MINUS);
                        builder.append(-number);
                    }
                }catch (ArrayIndexOutOfBoundsException|NumberFormatException e){
                    errorLines++;
                }
            }
            builder.append(Constants.SYMBOLS_AFTER_LAST_NUMBER).
                    append(sum).
                    append(Constants.ERROR_LINES).
                    append(errorLines);
            char firstNumberOperator = builder.charAt(Constants.FIRST_OPERATOR_INDEX);
            if (firstNumberOperator == '-'){
                builder.replace(Constants.FIRST_OPERATOR_START, Constants.FIRST_OPERATOR_END, "-");
            }else if (firstNumberOperator == '+'){
                builder.replace(Constants.FIRST_OPERATOR_START, Constants.FIRST_OPERATOR_END, "");
            }

            System.out.println(builder);
        }catch (FileNotFoundException e){
            System.err.println(Constants.INPUT_FILE_IS_NOT_FOUND);
        }finally {
            if (scanner != null){
                scanner.close();
            }
        }
    }
    private static double findNumberInLine(Scanner scanner){
        String line = scanner.nextLine();
        String[] values = line.split(Constants.NUMBERS_SEPARATOR);
        int indexRequiredNumber = Integer.parseInt(values[0]);
        return Double.parseDouble(values[indexRequiredNumber]);

    }
}

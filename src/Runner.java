import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = null;
        int errorLines = 0;
        double sum = 0;
        StringBuilder builder = new StringBuilder();
        try {
            scanner = new Scanner(new FileReader(Constants.FILE_NAME));
            scanner.useLocale(Locale.ENGLISH);
            while (scanner.hasNextLine()) {
                try {
                    double number = findNumberInLine(scanner);
                    sum += number;
                    builder.append(number >= Constants.ZERO ? Constants.PLUS : Constants.MINUS).append(Math.abs(number));
                }catch (ArrayIndexOutOfBoundsException|NumberFormatException e){
                    errorLines++;
                }
            }

            standardizeOutput(builder);

            createOutputLine(builder, sum, errorLines);

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

    private static void createOutputLine(StringBuilder builder, double sum, int errorLines){
        builder.insert(0, Constants.RESULT);
        builder.append(Constants.SYMBOLS_AFTER_LAST_NUMBER).
                append(sum).
                append(Constants.NEXT_LINE).
                append(Constants.ERROR_LINES).
                append(errorLines);
    }

    private static void standardizeOutput(StringBuilder builder){
        if (builder.length() > 0){
            char firstNumberOperator = builder.charAt(Constants.SIGN_POSITION);
            builder.delete(0, Constants.SIGN_LENGTH);
            if (firstNumberOperator == Constants.CHAR_MINUS){
                builder.insert(0, Constants.CHAR_MINUS);
            }
        }
    }
}

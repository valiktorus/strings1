import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = null;
        int errorLines = 0;
        double sum = 0;
        try {
            scanner = new Scanner(new FileReader(Constants.FILE_NAME));
            scanner.useLocale(Locale.ENGLISH);
            while (scanner.hasNextLine()) {
                try {
                    sum += findNumberInLine(scanner);
                }catch (ArrayIndexOutOfBoundsException|NumberFormatException e){
                    errorLines++;
                }
            }

        }catch (FileNotFoundException e){
            System.err.println("Input file is not found");
        }finally {
            if (scanner != null){
                scanner.close();
            }
            System.out.println(sum);
            System.out.println(errorLines);
        }

    }
    public static double findNumberInLine(Scanner scanner){
        String line = scanner.nextLine();
        String[] values = line.split(";");
        int indexRequiredNumber = Integer.parseInt(values[0]);
        return Double.parseDouble(values[indexRequiredNumber]);

    }
}

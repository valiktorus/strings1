public class Constants {
    public static final String FILE_NAME = "src/in.csv";
    public static final String BEFORE_SIGN = " ";
    public static final String  AFTER_SIGN = " ";
    public static final String PLUS = BEFORE_SIGN + "+" + AFTER_SIGN;
    public static final String MINUS = BEFORE_SIGN + "-" + AFTER_SIGN;
    public static final char CHAR_MINUS = '-';
    public static final char CHAR_PLUS = '+';
    public static final int SIGN_LENGTH = MINUS.length();
    public static final int SIGN_POSITION = MINUS.indexOf(CHAR_MINUS);
    public static final int FIRST_OPERATOR_START = 7;
    public static final int FIRST_OPERATOR_END = 10;

    public static final String INPUT_FILE_IS_NOT_FOUND = "Input file is not found";
    public static final String NUMBERS_SEPARATOR = ";";
    public static final String NEXT_LINE = "\n";
    public static final String ERROR_LINES = "error-lines = ";
    public static final String SYMBOLS_AFTER_LAST_NUMBER = ") = ";
    public static final double ZERO = 0.0;
    public static final String RESULT = "result(";


}

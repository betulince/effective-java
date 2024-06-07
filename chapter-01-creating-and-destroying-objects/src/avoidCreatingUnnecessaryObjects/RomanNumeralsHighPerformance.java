package avoidCreatingUnnecessaryObjects;

import java.util.regex.Pattern;

// Reusing expensive object for improved performance
public class RomanNumeralsHighPerformance {
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        String s = "XI";
        System.out.println(RomanNumeralsHighPerformance.isRomanNumeral(s));
    }
}

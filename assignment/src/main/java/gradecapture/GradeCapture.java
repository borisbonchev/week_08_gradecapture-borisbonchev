package gradecapture;

import java.util.AbstractMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The regex defines two parenthesis groups, one for the student number, one for
 * the grade. 
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class GradeCapture {
    //TODO implement regex
    static final String REGEX = "^(\\d{7})\\s.*\\s(\\d[.,]\\d|\\d{1,2})$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private final Matcher matcher;

    /**
     * Construct a GradeCapture from a string (line).
     *
     * @param line to read
     */
    public GradeCapture(String line) {
        matcher = PATTERN.matcher(line);
    }

    /**
     * Create a tuple. Use AbstractMap. SimpleEntry as implementing class.
     *
     * @return the tuple.
     */
    public AbstractMap.SimpleEntry<Integer, Double> getResult() {
        return new AbstractMap.SimpleEntry<>(getStudentNumber(), getGrade());
    }

    /**
     * Does the line contain the required data?
     *
     * @return whether there is a match
     */
    public boolean hasResult() {
        //TODO implement hasResult()
        return matcher.matches();
    }

    /**
     * Get the grade, if any. Make sure to replace ','(comma) by . (period),
     * before you try to get the double value of the string.
     *
     * @return the grade or null when no match
     */
    public Double getGrade() {
        //TODO implement getGrade()
            if (hasResult()) {
                var gradeFound = matcher.group(2);
                return Double.valueOf(gradeFound.replace(",", "."));
            }
            return null;
    }

    /**
     * Get the student number, if any.
     *
     * @return the student number or null when no match.
     */
    public Integer getStudentNumber() {
        //TODO implement getStudentNumber()
        if (hasResult()) {
            return Integer.valueOf(matcher.group(1));
        }
        return null;
    }
}

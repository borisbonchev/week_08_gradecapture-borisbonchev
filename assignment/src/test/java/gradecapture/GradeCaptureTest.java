package gradecapture;

import java.util.AbstractMap;
import static org.assertj.core.api.Assertions.*;

import gradesutils.GradeCollector;
import org.assertj.core.api.GenericComparableAssert;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


/**
 *
 * @author Pieter van den Hombergh {@code <p.vandenhombergh@fontys.nl>}
 */
public class GradeCaptureTest {

    /**
     * Test hasResult of GradeCollector
     *
     * @param input string
     * @param expHasResult matches
     * @param matchedGradeString the found grade string
     * @param studentNumber sic
     * @param grade the grade as double after conversion
     */
    //@Disabled( "Think TDD" )
    @ParameterizedTest
    @CsvFileSource( resources = { "testdata.csv" } )
    void hasResult( String input, boolean expHasResult,
            String matchedGradeString, Integer studentNumber, double grade ) {

        // TODO test hasResult
        GradeCapture gradeCapture = new GradeCapture(input);
        assertThat(gradeCapture.hasResult()).isEqualTo(expHasResult);
    }

    /**
     * Test of getResult method, of class GradeCapture.
     *
     * @param input string
     * @param expHasResult matches
     * @param matchedGradeString the found grade string
     * @param studentNumber sic
     * @param grade the grade as double after conversion
     */
//    @Disabled( "Think TDD" )Disabled
    @ParameterizedTest
    @CsvFileSource( resources = { "testdata.csv" } )
    void testGetResult( String input, boolean expHasResult,
            String matchedGradeString, Integer studentNumber, double grade ) {

        // TODO test getResult
        GradeCapture gradeCapture = new GradeCapture(input);

        if (!gradeCapture.hasResult()) {
            SoftAssertions.assertSoftly(softly -> {
                softly.assertThat(gradeCapture.getResult().getKey()).isEqualTo(null);
                softly.assertThat(gradeCapture.getResult().getValue()).isEqualTo(null);
            });
        } else {
            SoftAssertions.assertSoftly(softly -> {
                softly.assertThat(gradeCapture.getResult().getKey()).isEqualTo(studentNumber);
                softly.assertThat(gradeCapture.getResult().getValue()).isEqualTo(grade);
            });
        }
    }
}

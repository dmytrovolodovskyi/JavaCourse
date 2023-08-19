import com.example.app.CaseConverter;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class CaseConverterTest {

    @Test
    public void testGetUserText() {
        // Given
        CaseConverter caseConverter = new CaseConverter();
        InputStream input = new ByteArrayInputStream("Test text".getBytes());

        // When
        System.setIn(input);
        String result = caseConverter.getUserText();

        // Then
        String expected = "Test text";
        assertEquals(expected, result);
    }

    @Test
    public void testSplitUserText() {
        CaseConverter caseConverter = new CaseConverter();

        String[] result = caseConverter.splitUserText("Test text");

        String[] expected = new String[]{"T", "e", "s", "t", " ", "t", "e", "x", "t"};
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void testSetTextCase() {
        CaseConverter caseConverter = new CaseConverter();

        String result = caseConverter.setTextCase(new String[]{"T", "e", "s", "t", " ", "t", "e", "x", "t"});

        String expected = "tEsT TeXt";
        assertEquals(expected, result);
    }
}

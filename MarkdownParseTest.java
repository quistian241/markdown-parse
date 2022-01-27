// javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
// java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class MarkdownParseTest {
    // System.out.println(MarkdownParse.getLinks(""));

    @Test
    public void testCorrectLink() {
        assertEquals(List.of("https://something.com"), MarkdownParse.getLinks("[a link!](https://something.com)"));
    }

    @Test
    public void testExtraSpace() {
        assertEquals(List.of(), MarkdownParse.getLinks("[fake link]extra space here(not a real link)"));
    }

    @Test
    public void testImages() {
        assertEquals(List.of("google.com"), MarkdownParse.getLinks("[](google.com)"));
    }
    
    @Test
    public void testNewLines() {
        assertEquals(List.of(), MarkdownParse.getLinks("[no link here] \n\n (no text here)"));
    }

    @Test
    public void testOnlyBracketts() {
        assertEquals(List.of(), MarkdownParse.getLinks("[no text here]"));
    }

    @Test
    public void testBuchOfMess() {
        assertEquals(List.of("last line link should be found"), MarkdownParse.getLinks("a ] ] ] ] text! \n [Last line link](last line link should be found)"));
    }

    @Test
    public void testEmpty() {
        assertEquals(List.of(), MarkdownParse.getLinks(""));
    }

    @Test
    public void testNoLink() {
        assertEquals(List.of(), MarkdownParse.getLinks("[a] link!](https://something.com)"));
    }

    // @Test 
    // public void testFile1() {
    //     System.out.println(MarkdownParse.main("test-file.md", test));
    // }

    @Test
    public void testPrints() {
        // System.out.println();
        // System.out.println("New test: " + MarkdownParse.getLinks(")["));
        System.out.println("New test: " + MarkdownParse.getLinks("[](a link on the first line)\n["));
    }
}
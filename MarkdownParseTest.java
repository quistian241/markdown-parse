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
    public void testPrints() {
        System.out.println();
        System.out.println("New test: " + MarkdownParse.getLinks("[First line link](first line link should be found)"));
        System.out.println("New test: " + MarkdownParse.getLinks("[a] link!](https://something.com)"));
        System.out.println("New test: " + MarkdownParse.getLinks("a text!"));
        System.out.println("New test: " + MarkdownParse.getLinks("a ] ] ] ] text!"));
        System.out.println("New test: " + MarkdownParse.getLinks(""));



        
    }
}
// javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
// java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testEmpty() throws IOException {
        assertLinks(List.of(), "testCases/empty.md");
    }

    @Test
    public void testExtraSpace() throws IOException {
        assertLinks(List.of(), "testCases/extraSpace.md");
    }

    @Test
    public void testEscape() throws IOException {
        assertLinks(List.of("https://somethingelse.com"), "testCases/escape.md");
    }

    @Test
    public void testJustEscape() throws IOException {
        assertLinks(List.of(), "testCases/justEscape.md");
    }

    @Test
    public void testImage() throws IOException {
        assertLinks(List.of(), "testCases/image.md");
    }

    @Test
    public void testJustBrackets() throws IOException {
        assertLinks(List.of(), "testCases/justBrackets.md");
    }

    @Test
    public void testJustParentheses() throws IOException {
        assertLinks(List.of(), "testCases/justParentheses.md");
    }

    @Test
    public void testMultiline() throws IOException {
        assertLinks(List.of("https://isthisfound.com"), "testCases/multiline.md");
    }

    @Test
    public void testLastLine() throws IOException {
        assertLinks(List.of("last line link should be found"), "testCases/lastLine.md");
    }

    @Test
    public void testEndStartParentheses() throws IOException {
        assertLinks(List.of(), "testCases/endStartParentheses.md");
    }

    //needs to be fixed
    // @Test
    // public void testSpaceAfterParen() {
    //     String contents = "[title]( space-in-url.com)";
    //     List<String> expect = List.of("space-in-url.com");
    //     assertEquals(expect, MarkdownParse.getLinks(contents));
    // }
    
    @Test
    public void testSnippet1() throws IOException {
        String contents= Files.readString(Path.of("./snippet-1.md"));
        List<String> expect = List.of("`google.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet2() throws IOException {
        String contents= Files.readString(Path.of("./snippet-2.md"));
        List<String> expect = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet3() throws IOException {
        String contents= Files.readString(Path.of("./snippet-3.md"));
        List<String> expect = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    public static void assertLinks(List<String> expectedLinks, String fileName) throws IOException {
        Path filePath = Path.of(fileName);
        String contents = Files.readString(filePath);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(expectedLinks, links);
    }
}

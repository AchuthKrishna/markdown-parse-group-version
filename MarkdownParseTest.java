import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile6() throws IOException{
        String contents= Files.readString(Path.of("./test-file5.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void subtraction(){
        assertEquals(7, 9 - 2);
    }

    @Test
    public void testLabReport1() throws IOException{
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), 
            MarkdownParse.getLinks(Files.readString(Path.of
            ("/Users/achuthkrishna/Documents/GitHub/markdown-parse-review/lab-report-test1.md"))));
    }
    
    @Test
    public void testLabReport2() throws IOException{
        assertEquals(List.of("a.com", "a.com(())", "example.com"), 
            MarkdownParse.getLinks(Files.readString(Path.of
            ("/Users/achuthkrishna/Documents/GitHub/markdown-parse-review/lab-report-test2.md"))));
    }

    @Test
    public void testLabReport3() throws IOException{
        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), 
        MarkdownParse.getLinks(Files.readString(Path.of
        ("/Users/achuthkrishna/Documents/GitHub/markdown-parse-review/lab-report-test3.md"))));
    }
}

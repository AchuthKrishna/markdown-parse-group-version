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
    
}

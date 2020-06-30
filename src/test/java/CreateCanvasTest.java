import CreateCanvas.CreateCanvas;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Created on 30/06/2020.
 */
public class CreateCanvasTest {
    
    @Before
    public void setup() {

    }

    @Test
    public void testCreateCanvas() {
        CreateCanvas createCanvas = new CreateCanvas();
        boolean hasCanvasCreated = createCanvas.createCanvas();
        assertTrue(" Canvas created ", hasCanvasCreated);
    }
}

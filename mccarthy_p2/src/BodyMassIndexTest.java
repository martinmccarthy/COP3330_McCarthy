import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.Math;

public class BodyMassIndexTest {
    @Test
    public void testCalculateBmi() {
        BodyMassIndex b = new BodyMassIndex(60, 145);

        double answer = Math.round(b.calculateBmi());

        assertEquals(28, answer);
    }

    @Test
    public void testCalculateBmiCategory() {
        BodyMassIndex b = new BodyMassIndex(60, 145);

        String answer = b.calculateBmiCategory();

        assertEquals("Overweight", answer);
    }

    @Test
    public void testUnderweight() {
        BodyMassIndex b = new BodyMassIndex(60, 90);

        String answer = b.calculateBmiCategory();

        assertEquals("Underweight", answer);
    }

    @Test
    public void testNormalWeight() {
        BodyMassIndex b = new BodyMassIndex(60, 105);

        String answer = b.calculateBmiCategory();

        assertEquals("Normal weight", answer);
    }

    @Test
    public void testOverweight() {
        BodyMassIndex b = new BodyMassIndex(60, 145);

        String answer = b.calculateBmiCategory();

        assertEquals("Overweight", answer);
    }
    @Test
    public void testObesity() {
        BodyMassIndex b = new BodyMassIndex(60, 190);

        String answer = b.calculateBmiCategory();

        assertEquals("Obesity", answer);
    }
}

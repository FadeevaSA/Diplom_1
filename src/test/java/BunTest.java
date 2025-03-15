import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    public static final String NAME_OF_BLACK_BUN = "Black bun";
    private static final float PRICE_OF_BLACK_BUN = 100;
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(NAME_OF_BLACK_BUN, PRICE_OF_BLACK_BUN);
    }

    @Test
    public void getNameReturnNameOfBun() {
        String actualNameOfBun = bun.getName();
        assertEquals(NAME_OF_BLACK_BUN, actualNameOfBun);
    }

    @Test
    public void getPriceReturnPriceOfBun() {
        float actualPriceOfBun = bun.getPrice();
        assertEquals(PRICE_OF_BLACK_BUN, actualPriceOfBun, 0.01);
    }

}

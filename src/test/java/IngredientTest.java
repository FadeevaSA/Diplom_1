import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    private Ingredient ingredient;
    public static final String NAME_OF_SAUCE = "Chili sauce";
    private static final float PRICE_OF_SAUCE = 200;

    @Before
    public void setUp() {
        ingredient = new Ingredient(SAUCE, NAME_OF_SAUCE, PRICE_OF_SAUCE);
    }

    @Test
    public void testGetPriceReturnPrice() {
        float actualPriceOfIngredient = ingredient.getPrice();
        assertEquals(PRICE_OF_SAUCE, actualPriceOfIngredient, 0.01);
    }

    @Test
    public void testGetNameReturnName() {
        String actualNameOfIngredient = ingredient.getName();
        assertEquals(NAME_OF_SAUCE, actualNameOfIngredient);
    }

    @Test
    public void testGetTypeReturnType() {
        IngredientType actualTypeOfIngredient = ingredient.getType();
        assertEquals(SAUCE, actualTypeOfIngredient);
    }
}

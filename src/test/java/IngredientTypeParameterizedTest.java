import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {
    private final IngredientType ingredientType;

    public IngredientTypeParameterizedTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Тип ингредиента: {0}")
    public static Object[][] types() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        };
    }

    @Test
    public void testIngredientTypeNotNull() {
        assertNotNull(ingredientType);
    }

}

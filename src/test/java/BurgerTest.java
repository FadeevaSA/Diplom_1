import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient cutlet;

    @Mock
    Ingredient hotSauce;

    @Mock
    Bun bun;

    private Burger burger;
    private static final float PRICE_OF_BUN = 100;
    private static final float PRICE_OF_CUTLET = 200;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(cutlet);
    }

    @Test
    public void addIngredientAddListOfIngredients() {
        List<Ingredient> testIngredients = burger.ingredients;
        assertTrue(testIngredients.contains(cutlet));
    }

    @Test
    public void setBunsChoosesBun() {
        assertEquals(bun, burger.bun);
    }

    @Test
    public void removeIngredientDeleteIngredient() {
        assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
        List<Ingredient> testIngredients = burger.ingredients;
        assertTrue(testIngredients.isEmpty());
    }

    @Test
    public void moveIngredientSwapsIngredients() {
        burger.addIngredient(hotSauce);
        burger.moveIngredient(0, 1);
        List<Ingredient> testIngredients = burger.ingredients;
        assertEquals(cutlet, testIngredients.get(1));
    }

    @Test
    public void getPriceReturnPrice() {
        Mockito.when(bun.getPrice()).thenReturn(PRICE_OF_BUN);
        Mockito.when(cutlet.getPrice()).thenReturn(PRICE_OF_CUTLET);
        float expectedPriceOfBurger = PRICE_OF_BUN * 2 + PRICE_OF_CUTLET;
        float actualPriceOfBurger = burger.getPrice();
        assertEquals(expectedPriceOfBurger, actualPriceOfBurger, 0.01);
    }

    @Test
    public void getReceiptReturnReceipt() {
        Mockito.when(bun.getName()).thenReturn("Black Bun");
        Mockito.when(cutlet.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(cutlet.getName()).thenReturn("Chicken cutlet");
        Mockito.when(burger.getPrice()).thenReturn(400f);
        String expectedReceipt = "(==== Black Bun ====)\n" +
                "= filling Chicken cutlet =\n" +
                "(==== Black Bun ====)\n" +
                "\nPrice: 400,000000\n";
        String actualReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }
}

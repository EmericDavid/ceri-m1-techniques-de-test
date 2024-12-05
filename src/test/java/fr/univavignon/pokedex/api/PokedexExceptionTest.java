package fr.univavignon.pokedex.api;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PokedexExceptionTest {

    @Test
    public void testPokedexExceptionMessage() {
        String errorMessage = "This is a test error message";
        PokedexException exception = new PokedexException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}

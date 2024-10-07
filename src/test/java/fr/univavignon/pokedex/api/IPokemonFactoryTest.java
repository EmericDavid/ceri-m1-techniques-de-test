package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IPokemonFactoryTest {

    @Test
    public void testCreatePokemon() {
        IPokemonFactory factory = Mockito.mock(IPokemonFactory.class);
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 613, 64, 4000, 200, 1000, 0, 0, 0);
        Mockito.when(factory.createPokemon(0, 200, 1000, 0, 0)).thenReturn(pokemon);

        Pokemon result = factory.createPokemon(0, 200, 1000, 0, 0);
        assertNotNull(result);
        assertEquals("Bulbasaur", result.getName());
        assertEquals(200, result.getCp());
        assertEquals(1000, result.getHp());
        assertEquals(0, result.getDust());
        assertEquals(0, result.getCandy());
    }

}
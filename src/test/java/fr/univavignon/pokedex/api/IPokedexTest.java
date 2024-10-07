package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IPokedexTest {

    @Test
    public void testAddPokemon() {
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 613, 64, 4000, 200, 1000, 0, 0, 0);
        Mockito.when(pokedex.addPokemon(pokemon)).thenReturn(0);

        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 613, 64, 4000, 200, 1000, 0, 0, 0);
        Mockito.when(pokedex.getPokemon(0)).thenReturn(pokemon);

        Pokemon result = pokedex.getPokemon(0);
        assertNotNull(result);
    }

}
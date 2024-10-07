package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IPokemonFactoryTest {

    @Test
    public void testCreatePokemonExemple1() {
        IPokemonFactory factory = Mockito.mock(IPokemonFactory.class);
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        Mockito.when(factory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon);

        Pokemon result = factory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(0, result.getIndex());
        assertEquals("Bulbasaur", result.getName());
        assertEquals(126, result.getAttack());
        assertEquals(126, result.getDefense());
        assertEquals(90, result.getStamina());
        assertEquals(613, result.getCp());
        assertEquals(64, result.getHp());
        assertEquals(4000, result.getDust());
        assertEquals(4, result.getCandy());
    }

    @Test
    public void testCreatePokemonExemple2() {
        IPokemonFactory factory = Mockito.mock(IPokemonFactory.class);
        Pokemon pokemon = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        Mockito.when(factory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(pokemon);
        Pokemon result = factory.createPokemon(133, 2729, 202, 5000, 4);
        assertNotNull(result);
        assertEquals(133, result.getIndex());
        assertEquals("Aquali", result.getName());
        assertEquals(186, result.getAttack());
        assertEquals(168, result.getDefense());
        assertEquals(260, result.getStamina());
        assertEquals(2729, result.getCp());
        assertEquals(202, result.getHp());
        assertEquals(5000, result.getDust());
        assertEquals(4, result.getCandy());
    }

}
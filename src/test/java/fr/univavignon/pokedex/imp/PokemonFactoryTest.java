package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonFactoryTest {
    @Test
    public void testCreatePokemonExemple1() {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory factory = new PokemonFactory(metadataProvider);
        // Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4,
        // 56);

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
        assertEquals(100, result.getIv(), 0.0);
    }

    @Test
    public void testCreatePokemonExemple2() {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory factory = new PokemonFactory(metadataProvider);

        // Pokemon pokemon = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000,
        // 4,
        // 100);

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
        assertEquals(100, result.getIv(), 0.0);
    }

    @Test(expected = RuntimeException.class)
    public void testCreatePokemonInvalidIndex() throws PokedexException {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory factory = new PokemonFactory(metadataProvider);

        factory.createPokemon(-1, 613, 64, 4000, 4);
    }
}

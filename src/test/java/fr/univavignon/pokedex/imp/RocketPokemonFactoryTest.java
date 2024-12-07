package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class RocketPokemonFactoryTest {

    @Test
    public void testCreatePokemon() {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory factory = new PokemonFactory(metadataProvider);

        Pokemon pokemon = factory.createPokemon(0, 613, 64, 4000, 4);

        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(126, pokemon.getAttack());
        assertEquals(126, pokemon.getDefense());
        assertEquals(90, pokemon.getStamina());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
        assertEquals(100.0, pokemon.getIv(), 0.0);
    }

    @Test
    public void testCreatePokemonWithInvalidIndex() {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider() {
            @Override
            public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
                throw new PokedexException("Invalid Pokemon index: " + index);
            }
        };
        PokemonFactory factory = new PokemonFactory(metadataProvider);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            factory.createPokemon(-1, 613, 64, 4000, 4);
        });

        assertEquals("Failed to create Pokemon", exception.getMessage());
        assertNotNull(exception.getCause());
        assertEquals(PokedexException.class, exception.getCause().getClass());
        assertEquals("Invalid Pokemon index: -1", exception.getCause().getMessage());
    }
}

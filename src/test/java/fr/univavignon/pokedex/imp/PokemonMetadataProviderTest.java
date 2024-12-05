package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PokemonMetadataProviderTest {

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadataProvider provider = new PokemonMetadataProvider();
        PokemonMetadata metadata = provider.getPokemonMetadata(0);

        assertNotNull(metadata);
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        PokemonMetadataProvider provider = new PokemonMetadataProvider();
        provider.getPokemonMetadata(-1);
    }
}
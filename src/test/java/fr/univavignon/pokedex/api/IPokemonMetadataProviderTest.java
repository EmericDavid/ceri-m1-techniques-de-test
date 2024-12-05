package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IPokemonMetadataProviderTest {

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        IPokemonMetadataProvider provider = Mockito.mock(IPokemonMetadataProvider.class);
        PokemonMetadata metadata = new PokemonMetadata(0, "Bulbasaur", 126, 126, 90);

        Mockito.when(provider.getPokemonMetadata(0)).thenReturn(metadata);
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals("Bulbasaur", result.getName());
        assertEquals(126, result.getAttack());
        assertEquals(126, result.getDefense());
        assertEquals(90, result.getStamina());
    }

}

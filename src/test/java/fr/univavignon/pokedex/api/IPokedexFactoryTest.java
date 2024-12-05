package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;

public class IPokedexFactoryTest {

    @Test
    public void testCreatePokedex() {
        IPokedexFactory factory = Mockito.mock(IPokedexFactory.class);
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Mockito.when(factory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        IPokedex result = factory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(result);
    }

}

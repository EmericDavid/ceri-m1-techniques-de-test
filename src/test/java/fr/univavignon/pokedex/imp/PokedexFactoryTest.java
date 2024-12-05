package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.IPokedex;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PokedexFactoryTest {

    @Test
    public void testCreatePokedex() {
        PokedexFactory factory = new PokedexFactory();
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);

        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex);
    }
}
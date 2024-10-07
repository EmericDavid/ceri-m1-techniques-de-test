package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;

public class IPokemonTrainerFactoryTest {

    @Test
    public void testCreateTrainer() {
        IPokemonTrainerFactory factory = Mockito.mock(IPokemonTrainerFactory.class);
        IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokedex pokedex = Mockito.mock(IPokedex.class);

        PokemonTrainer trainer = new PokemonTrainer("Ash", Team.VALOR, pokedex);
        Mockito.when(factory.createTrainer("Ash", Team.VALOR, pokedexFactory)).thenReturn(trainer);

        PokemonTrainer result = factory.createTrainer("Ash", Team.VALOR, pokedexFactory);
        assertNotNull(result);


    }

}
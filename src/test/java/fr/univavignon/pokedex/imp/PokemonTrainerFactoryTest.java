package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PokemonTrainerFactoryTest {

    @Test
    public void testCreateTrainer() {
        PokemonTrainerFactory factory = new PokemonTrainerFactory();
        PokedexFactory pokedexFactory = new PokedexFactory();

        PokemonTrainer trainer = factory.createTrainer("Ash", Team.VALOR, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());

        IPokedex pokedex = trainer.getPokedex();
        assertNotNull(pokedex);
    }
}
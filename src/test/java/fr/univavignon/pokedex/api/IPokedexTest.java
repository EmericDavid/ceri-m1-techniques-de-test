package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

public class IPokedexTest {
    private IPokedex pokedex = Mockito.mock(IPokedex.class);
    private Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
    private Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

    @Test
    public void testAddPokemon() {
        Mockito.when(pokedex.addPokemon(bulbasaur)).thenReturn(bulbasaur.getIndex());
        int index = pokedex.addPokemon(bulbasaur);
        assertEquals(0, index);

        Mockito.when(pokedex.addPokemon(aquali)).thenReturn(aquali.getIndex());
        index = pokedex.addPokemon(aquali);
        assertEquals(133, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Mockito.when(pokedex.getPokemon(0)).thenReturn(bulbasaur);

        Pokemon result = pokedex.getPokemon(0);
        assertEquals(0, result.getIndex());
        assertEquals("Bulbasaur", result.getName());

        Mockito.when(pokedex.getPokemon(133)).thenReturn(aquali);
        result = pokedex.getPokemon(133);
        assertEquals(133, result.getIndex());
        assertEquals("Aquali", result.getName());
    }

    @Test
    public void testSize() {
        Mockito.when(pokedex.addPokemon(bulbasaur)).thenReturn(bulbasaur.getIndex());
        pokedex.addPokemon(bulbasaur);

        Mockito.when(pokedex.size()).thenReturn(1);
        assertEquals(1, pokedex.size());

        Mockito.when(pokedex.addPokemon(aquali)).thenReturn(aquali.getIndex());
        pokedex.addPokemon(aquali);

        Mockito.when(pokedex.size()).thenReturn(2);
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testGetPokemons() {
        Mockito.when(pokedex.addPokemon(bulbasaur)).thenReturn(bulbasaur.getIndex());
        int index_bulbi = pokedex.addPokemon(bulbasaur);

        Mockito.when(pokedex.addPokemon(aquali)).thenReturn(aquali.getIndex());
        int index_aquali = pokedex.addPokemon(aquali);

        Mockito.when(pokedex.getPokemons()).thenReturn(List.of(bulbasaur, aquali));
        List<Pokemon> pokemons = pokedex.getPokemons();

        assertEquals(index_bulbi, pokemons.get(0).getIndex());
        assertEquals(index_aquali, pokemons.get(1).getIndex());
    }

}
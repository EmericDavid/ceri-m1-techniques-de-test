package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonComparators;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PokedexTest {

    private Pokedex pokedex;
    private Pokemon bulbasaur;
    private Pokemon aquali;

    @Before
    public void setUp() {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    @Test
    public void testAddPokemon() {
        int index = pokedex.addPokemon(bulbasaur);
        assertEquals(0, index);

        index = pokedex.addPokemon(aquali);
        assertEquals(1, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        pokedex.addPokemon(bulbasaur);
        pokedex.addPokemon(aquali);

        Pokemon result = pokedex.getPokemon(0);
        assertNotNull(result);
        assertEquals("Bulbasaur", result.getName());

        result = pokedex.getPokemon(1);
        assertNotNull(result);
        assertEquals("Aquali", result.getName());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonInvalidIndex() throws PokedexException {
        pokedex.getPokemon(-1);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());

        pokedex.addPokemon(bulbasaur);
        assertEquals(1, pokedex.size());

        pokedex.addPokemon(aquali);
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testGetPokemons() {
        pokedex.addPokemon(bulbasaur);
        pokedex.addPokemon(aquali);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals("Bulbasaur", pokemons.get(0).getName());
        assertEquals("Aquali", pokemons.get(1).getName());
    }

    @Test
    public void testGetPokemonsSorted() {
        pokedex.addPokemon(aquali);
        pokedex.addPokemon(bulbasaur);

        List<Pokemon> pokemons = pokedex.getPokemons(PokemonComparators.NAME);
        assertEquals(2, pokemons.size());
        assertEquals("Aquali", pokemons.get(0).getName());
        assertEquals("Bulbasaur", pokemons.get(1).getName());
    }
}
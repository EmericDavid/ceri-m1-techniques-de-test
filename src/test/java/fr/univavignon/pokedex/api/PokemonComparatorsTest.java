package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PokemonComparatorsTest {

    private Pokemon bulbasaur;
    private Pokemon ivysaur;
    private Pokemon charmander;

    @Before
    public void setUp() {
        bulbasaur = new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        ivysaur = new Pokemon(2, "Ivysaur", 156, 158, 120, 1000, 125, 8000, 7, 100);
        charmander = new Pokemon(4, "Charmander", 128, 108, 78, 500, 50, 3000, 3, 45);
    }

    @Test
    public void testCompareByName() {
        assertEquals(-7, PokemonComparators.NAME.compare(bulbasaur, ivysaur));
        assertEquals(7, PokemonComparators.NAME.compare(ivysaur, bulbasaur));
        assertEquals(0, PokemonComparators.NAME.compare(bulbasaur, bulbasaur));
    }

    @Test
    public void testCompareByIndex() {
        assertEquals(-1, PokemonComparators.INDEX.compare(bulbasaur, ivysaur));
        assertEquals(1, PokemonComparators.INDEX.compare(ivysaur, bulbasaur));
        assertEquals(0, PokemonComparators.INDEX.compare(bulbasaur, bulbasaur));
    }

    @Test
    public void testCompareByCp() {
        assertEquals(1, PokemonComparators.CP.compare(bulbasaur, charmander));
        assertEquals(-1, PokemonComparators.CP.compare(charmander, bulbasaur));
        assertEquals(0, PokemonComparators.CP.compare(bulbasaur, bulbasaur));
    }
}
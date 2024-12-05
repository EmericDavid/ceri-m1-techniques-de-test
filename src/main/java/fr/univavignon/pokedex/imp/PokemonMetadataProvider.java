package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private static final Map<Integer, PokemonMetadata> METADATA_MAP = new HashMap<>();
    private static final int BULBASAUR_INDEX = 0;
    private static final int BULBASAUR_ATTACK = 126;
    private static final int BULBASAUR_DEFENSE = 126;
    private static final int BULBASAUR_STAMINA = 90;
    private static final int AQUALI_INDEX = 133;
    private static final int AQUALI_ATTACK = 186;
    private static final int AQUALI_DEFENSE = 168;
    private static final int AQUALI_STAMINA = 260;

    static {
        METADATA_MAP.put(BULBASAUR_INDEX, new PokemonMetadata(BULBASAUR_INDEX, "Bulbasaur", BULBASAUR_ATTACK,
                BULBASAUR_DEFENSE, BULBASAUR_STAMINA));
        METADATA_MAP.put(AQUALI_INDEX,
                new PokemonMetadata(AQUALI_INDEX, "Aquali", AQUALI_ATTACK, AQUALI_DEFENSE, AQUALI_STAMINA));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!METADATA_MAP.containsKey(index)) {
            throw new PokedexException("Invalid Pokemon index: " + index);
        }
        return METADATA_MAP.get(index);
    }
}
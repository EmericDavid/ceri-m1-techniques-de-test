package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private static final Map<Integer, PokemonMetadata> metadataMap = new HashMap<>();

    static {
        metadataMap.put(0, new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));
        metadataMap.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Invalid Pokemon index: " + index);
        }
        return metadataMap.get(index);
    }
}

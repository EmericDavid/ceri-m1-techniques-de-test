package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class PokemonFactory implements IPokemonFactory {

    private final IPokemonMetadataProvider metadataProvider;
    private static final double DEFAULT_IV = 100.0;

    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
            return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(),
                    metadata.getStamina(), cp, hp, dust, candy, DEFAULT_IV);
        } catch (PokedexException e) {
            throw new RuntimeException("Failed to create Pokemon", e);
        }
    }
}
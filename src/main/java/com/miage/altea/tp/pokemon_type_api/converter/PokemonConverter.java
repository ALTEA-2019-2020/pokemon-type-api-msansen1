package com.miage.altea.tp.pokemon_type_api.converter;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.dto.PokemonFlat;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;

@Component
public class PokemonConverter extends GenericsConverter<PokemonType, PokemonFlat> {

    @Override
    public PokemonFlat entityToDto(PokemonType poke) {
        return PokemonFlat.builder()
                .name(poke.getName())
                .description(String.join(", ", poke.getTypes()))
                .baseExperience(poke.getBaseExperience())
                .height(poke.getHeight())
                .weight(poke.getWeight())
                .img(poke.getSprites().getFront_default())
                .price(500-poke.getId()*2)

                .build();
    }

    @Override
    public PokemonType dtoToEntity(PokemonFlat pokemonFlat) {
        return null;
    }
}

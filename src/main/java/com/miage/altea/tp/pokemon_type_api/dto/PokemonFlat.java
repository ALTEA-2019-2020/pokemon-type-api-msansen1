package com.miage.altea.tp.pokemon_type_api.dto;

import com.miage.altea.tp.pokemon_type_api.bo.Sprites;
import com.miage.altea.tp.pokemon_type_api.bo.Stats;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PokemonFlat {

    private int baseExperience;
    private int height;
    private String name;
    private int weight;
    private String img;
    private int price;
    private String description;

}

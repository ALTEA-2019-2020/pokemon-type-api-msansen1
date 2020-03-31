package com.miage.altea.tp.pokemon_type_api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
/**
 * Utilisé pour le projet MIAGE PEPIT www.comparit.fr: https://github.com/comparIt/comparIt_docker#envie-de-charger-des-produits
 **/

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

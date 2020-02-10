package com.miage.altea.tp.pokemon_type_api.bo;

import com.miage.altea.tp.pokemon_type_api.repository.TranslationRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

@Getter
@Setter
public class PokemonType {

    private int id;
    private int baseExperience;
    private int height;
    private String name;
    private Sprites sprites;
    private Stats stats;
    private int weight;
    private List<String> types;

}

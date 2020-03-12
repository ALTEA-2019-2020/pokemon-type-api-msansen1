package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.dto.PokemonFlat;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/pokemon-flat", produces = MediaType.APPLICATION_JSON_VALUE)
public class PokemonFlatController {

    public PokemonTypeService pokemonTypeService;

    public PokemonFlatController(PokemonTypeService service) {
        this.pokemonTypeService = service;
    }

    @GetMapping("/")
    public List<PokemonFlat> getAllPokemonFlat() {
        return pokemonTypeService.getAllPokemonFlats();
    }
}

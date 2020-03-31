package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.dto.PokemonFlat;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Utilisé pour le projet MIAGE PEPIT www.comparit.fr: https://github.com/comparIt/comparIt_docker#envie-de-charger-des-produits
 **/

@RestController
@Api(value = "Pokemon Management System JSON Flattened")
@RequestMapping(value = "/pokemon-flat", produces = MediaType.APPLICATION_JSON_VALUE)
public class PokemonFlatController {

    public PokemonTypeService pokemonTypeService;

    public PokemonFlatController(PokemonTypeService service) {
        this.pokemonTypeService = service;
    }

    @GetMapping("/")
    @ApiOperation(value = "View a list of available pokemons", response = List.class)
    public List<PokemonFlat> getAllPokemonFlat() {
        return pokemonTypeService.getAllPokemonFlats();
    }
}

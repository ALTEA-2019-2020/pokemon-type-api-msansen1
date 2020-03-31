package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Pokemon Management System")
@RequestMapping(value = "/pokemon-types", produces = MediaType.APPLICATION_JSON_VALUE)
public class PokemonTypeController {

    public PokemonTypeService pokemonTypeService;

    public PokemonTypeController(PokemonTypeService service) {
        this.pokemonTypeService = service;
    }

    @ApiOperation(value = "View a pokemon by his ID")
    @GetMapping("/{id}")
    PokemonType getPokemonTypeFromId(@ApiParam(value = "Pokemon Id", required = true) @PathVariable int id) {
        return pokemonTypeService.getPokemonTypeById(id);
    }

    @ApiOperation(value = "View a pokemon by his name")
    @GetMapping(value = "/", params = "name")
    PokemonType getPokemonTypeFromName(@ApiParam(value = "Pokemon Name", required = true) @RequestParam String name) {
        return pokemonTypeService.getPokemonTypeByName(name);
    }

    @ApiOperation(value = "View a list of pokemons by their types", response = List.class)
    @GetMapping(value = "/", params = "types")
    List<PokemonType> getPokemonTypeFromName(@ApiParam(value = "Pokemon types", required = true) @RequestParam String[] types) {
        return pokemonTypeService.getPokemonTypeByType(types);
    }

    @ApiOperation(value = "View a list of available pokemons", response = List.class)
    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        return pokemonTypeService.getAllPokemonTypes();
    }
}

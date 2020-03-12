package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.dto.PokemonFlat;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/pokemon-types", produces = MediaType.APPLICATION_JSON_VALUE)
public class PokemonTypeController {

    public PokemonTypeService pokemonTypeService;

    public PokemonTypeController(PokemonTypeService service) {
        this.pokemonTypeService = service;
    }

    @GetMapping("/{id}")
    PokemonType getPokemonTypeFromId(@PathVariable int id){
        return pokemonTypeService.getPokemonTypeById(id);
    }

    @GetMapping(value = "/", params = "name")
    PokemonType getPokemonTypeFromName(@RequestParam String name){
        return pokemonTypeService.getPokemonTypeByName(name);
    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        return pokemonTypeService.getAllPokemonTypes();
    }
}

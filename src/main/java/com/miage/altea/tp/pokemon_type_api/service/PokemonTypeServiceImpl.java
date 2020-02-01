package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    public PokemonTypeRepository pokemonTypeRepository;

    @Autowired
    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository){
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    @Override
    public PokemonType getPokemonTypeById(int id) {
        return pokemonTypeRepository.findPokemonTypeById(id);
    }

    @Override
    public PokemonType getPokemonTypeByName(String name) {
        return pokemonTypeRepository.findPokemonTypeByName(name);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        return pokemonTypeRepository.findAllPokemonType();
    }
}

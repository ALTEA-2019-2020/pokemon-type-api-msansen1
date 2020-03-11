package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.converter.PokemonConverter;
import com.miage.altea.tp.pokemon_type_api.dto.PokemonFlat;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.miage.altea.tp.pokemon_type_api.repository.TranslationRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class PokemonTypeServiceImpl implements PokemonTypeService{

    @Autowired
    public PokemonTypeRepository pokemonTypeRepository;
    @Autowired
    public TranslationRepository translationRepository;
    @Autowired
    PokemonConverter pokemonConverter;

    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    @Override
    public PokemonType getPokemonTypeById(int id) {
        PokemonType poke = pokemonTypeRepository.findPokemonTypeById(id);
        poke.setName(translationRepository.getPokemonName(poke.getId(), LocaleContextHolder.getLocale()));
        return poke;
    }

    @Override
    public PokemonType getPokemonTypeByName(String name) {
        PokemonType poke = pokemonTypeRepository.findPokemonTypeByName(name);
        poke.setName(translationRepository.getPokemonName(poke.getId(), LocaleContextHolder.getLocale()));
        return poke;
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        //chercher la traduction du poke avant de le retourner
        var pokeList = pokemonTypeRepository.findAllPokemonType();
        List<PokemonType> out = new ArrayList<>();
        pokeList.forEach(pokemonType -> {
            PokemonType poke = pokemonType;
            poke.setName(translationRepository.getPokemonName(pokemonType.getId(), LocaleContextHolder.getLocale()));
            out.add(poke);
        });
        return out;
    }

    @Override
    public List<PokemonFlat> getAllPokemonFlats() {
        List<PokemonType> lpotype =  getAllPokemonTypes();
        List<PokemonFlat> out = new ArrayList<>();
        lpotype.forEach(pokemonType -> {
            out.add(pokemonConverter.entityToDto(pokemonType));
        });
        return out;
    }

    @Override
    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    @Override
    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }
}

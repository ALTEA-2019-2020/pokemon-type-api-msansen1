package com.miage.altea.tp.pokemon_type_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {

    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            var pokemonsStream = new ClassPathResource("pokemons.json").getInputStream();

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonTypeById(int id) {
        log.info("Loading Pokemon information for Pokemon id " + id);
        return this.pokemons.stream().filter(it -> it.getId() == id).findAny().orElseThrow();
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        log.info("Loading Pokemon information for Pokemon name " + name);
        return this.pokemons.stream().filter(it -> it.getName().equals(name)).findAny().orElseThrow();
    }

    @Override
    public List<PokemonType> findPokemonTypeByType(String[] type) {
        log.info("Loading Pokemon information for Pokemon types " + Arrays.asList(type).toString());
        List<PokemonType> list = this.pokemons
                .stream()
                .filter(it -> it.getTypes().containsAll(Arrays.asList(type)))
                .sorted((o1, o2) -> o1.getId() - o2.getId())
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public List<PokemonType> findAllPokemonType() {
        return this.pokemons.stream().sorted((o1, o2) -> o1.getId() - o2.getId()).collect(Collectors.toList());
    }
}

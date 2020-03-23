package com.miage.altea.tp.pokemon_type_api.repository;

import java.util.Locale;
import java.util.Optional;

public interface TranslationRepository {
    Optional<String> getPokemonName(int id, Locale locale);
}
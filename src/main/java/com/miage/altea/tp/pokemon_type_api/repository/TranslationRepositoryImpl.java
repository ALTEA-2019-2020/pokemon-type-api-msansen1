package com.miage.altea.tp.pokemon_type_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miage.altea.tp.pokemon_type_api.bo.Translation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class TranslationRepositoryImpl implements TranslationRepository {

    private Map<Locale, List<Translation>> translations;

    private List<Translation> defaultTranslations;

    public TranslationRepositoryImpl() {
        try {
            var objectMapper = new ObjectMapper();

            var frenchTranslationStream = new ClassPathResource("translations-fr.json").getInputStream();
            var frenchTranslationsArray = objectMapper.readValue(frenchTranslationStream, Translation[].class);

            var englishTranslationStream = new ClassPathResource("translations-en.json").getInputStream();
            var englishTranslationsArray = objectMapper.readValue(englishTranslationStream, Translation[].class);

            this.translations = Map.of(
                    Locale.FRANCE, List.of(frenchTranslationsArray),
                    Locale.FRENCH, List.of(frenchTranslationsArray),
                    Locale.ENGLISH, List.of(englishTranslationsArray),
                    Locale.US, List.of(englishTranslationsArray)
            );

            this.defaultTranslations = List.of(englishTranslationsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<String> getPokemonName(int id, Locale locale) {
        log.info(locale.getCountry());
        //Gestion d'une Langue par defaut dans le cas ou le navigateur supporterait une autre langue
        if (this.translations.get(locale.toLanguageTag()) == null) locale = Locale.ENGLISH;
        log.debug("Translating to " + locale.toLanguageTag());
        return Optional.ofNullable(this.translations.get(locale).get(id - 1).getName());
    }
}
package com.example.app05_parties;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PartyPokemon extends RealmObject {

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getPartynumber() {
        return partynumber;
    }

    public void setPartynumber(int partynumber) {
        this.partynumber = partynumber;
    }

    public int getPokemonnumber() {
        return pokemonnumber;
    }

    public void setPokemonnumber(int pokemonnumber) {
        this.pokemonnumber = pokemonnumber;
    }


    public int getPokemonlevel() {
        return pokemonlevel;
    }

    public void setPokemonlevel(int pokemonlevel) {
        this.pokemonlevel = pokemonlevel;
    }

    public PartyPokemon(String uuid, int partynumber, int pokemonnumber, int pokemonlevel) {
        this.uuid = uuid;
        this.partynumber = partynumber;
        this.pokemonnumber = pokemonnumber;
        this.pokemonlevel = pokemonlevel;
    }

    public PartyPokemon() {
        this.uuid = UUID.randomUUID().toString();
        this.partynumber = 0;
        this.pokemonnumber = 0;
        this.pokemonlevel = 0;
    }

    public PartyPokemon(PartyPokemon partypokemon) {
        this.uuid = partypokemon.uuid;
        this.partynumber = partypokemon.partynumber;
        this.pokemonnumber = partypokemon.pokemonnumber;
        this.pokemonlevel = partypokemon.pokemonlevel;
    }

    @PrimaryKey
    private String uuid;
    private int partynumber;
    private int pokemonnumber;
    private int pokemonlevel;
}

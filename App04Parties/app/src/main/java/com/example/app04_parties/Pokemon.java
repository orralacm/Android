package com.example.app04_parties;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Pokemon extends RealmObject {
    public String getPokemonname() {
        return pokemonname;
    }

    public void setPokemonname(String pokemonname) {
        this.pokemonname = pokemonname;
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

    private int pokemonlevel;

    public Pokemon(String pokemonname, int pokemonnumber, int pokemonlevel) {
        this.pokemonname = pokemonname;
        this.pokemonnumber = pokemonnumber;
        this.pokemonlevel = pokemonlevel;
    }

    public Pokemon() {
        this.pokemonname = "";
        this.pokemonnumber = 0;
        this.pokemonlevel = 1;
    }

    public Pokemon(Pokemon pokemon) {
        this.pokemonname = pokemon.pokemonname;
        this.pokemonnumber = pokemon.pokemonnumber;
        this.pokemonlevel = pokemon.pokemonlevel;
    }

    @PrimaryKey
    private int pokemonnumber;
    private String pokemonname;
}


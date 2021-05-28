package com.example.app05_parties;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Pokemon extends RealmObject {

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

    public Pokemon(int pokemonnumber, int pokemonlevel) {
        this.pokemonnumber = pokemonnumber;
        this.pokemonlevel = pokemonlevel;
    }

    public Pokemon() {
        this.pokemonnumber = 0;
        this.pokemonlevel = 1;
    }

    public Pokemon(Pokemon pokemon) {
        this.pokemonnumber = pokemon.pokemonnumber;
        this.pokemonlevel = pokemon.pokemonlevel;
    }

    @PrimaryKey
    private int pokemonnumber;
    private int pokemonlevel;

}


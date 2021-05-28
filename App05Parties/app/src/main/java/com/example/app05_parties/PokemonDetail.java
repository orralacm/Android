package com.example.app05_parties;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PokemonDetail extends RealmObject {

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public int getPokemonimage() {
        return pokemonimage;
    }

    public void setPokemonimage(int pokemonimage) {
        this.pokemonimage = pokemonimage;
    }

    public String getPokemonname() {
        return pokemonname;
    }

    public void setPokemonname(String pokemonname) {
        this.pokemonname = pokemonname;
    }

    public PokemonDetail(String uuid, int pokemonnumber, int pokemonlevel, int pokemonimage, String pokemonname) {
        this.uuid = uuid;
        this.pokemonnumber = pokemonnumber;
        this.pokemonlevel = pokemonlevel;
        this.pokemonimage = pokemonimage;
        this.pokemonname = pokemonname;
    }

    public PokemonDetail() {
        this.uuid = UUID.randomUUID().toString();
        this.pokemonnumber = 0;
        this.pokemonlevel = 0;
        this.pokemonimage = 0;
        this.pokemonname = "";
    }

    public PokemonDetail(PokemonDetail pokemondetail) {
        this.uuid = pokemondetail.uuid;
        this.pokemonnumber = pokemondetail.pokemonnumber;
        this.pokemonlevel = pokemondetail.pokemonlevel;
        this.pokemonimage = pokemondetail.pokemonimage;
        this.pokemonname = pokemondetail.pokemonname;
    }

    @PrimaryKey
    private String uuid;
    private int pokemonnumber;
    private int pokemonlevel;
    private int pokemonimage;
    private String pokemonname;
}

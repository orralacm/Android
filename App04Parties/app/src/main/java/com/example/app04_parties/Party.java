package com.example.app04_parties;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Party extends RealmObject {


    public Party(int partynumber, int pokemon1, int pokemon2, int pokemon3) {
        this.partynumber = partynumber;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
    }

    public Party() {
        this.partynumber = 0;
        this.pokemon1 = 0;
        this.pokemon2 = 0;
        this.pokemon3 = 0;
    }

    public Party(Party party) {
        this.partynumber = party.partynumber;
        this.pokemon1 = party.pokemon1;
        this.pokemon2 = party.pokemon2;
        this.pokemon3 = party.pokemon3;
    }

    public int getPartynumber() {
        return partynumber;
    }
    public void setPartynumber(int partynumber) {
        this.partynumber = partynumber;
    }

    public int getPokemon1() {
        return pokemon1;
    }
    public void setPokemon1(int pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public int getPokemon2() {
        return pokemon2;
    }
    public void setPokemon2(int pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public int getPokemon3() {
        return pokemon3;
    }
    public void setPokemon3(int pokemon3) {
        this.pokemon3 = pokemon3;
    }

    @PrimaryKey
    private int partynumber;
    private int pokemon1;
    private int pokemon2;
    private int pokemon3;
}
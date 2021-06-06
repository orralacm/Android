package com.example.app05_parties;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;

public class DBManager {
    public static void saveObject(RealmObject object){
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(object);
            realm.commitTransaction();
        } finally {
            realm.close();
        }
    }

    public static void deleteObject(RealmObject object){
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            object.deleteFromRealm();
            realm.commitTransaction();
        } finally {
            realm.close();
        }
    }

    public static Pokemon getPokemonByNumber(int pokemonnumber) {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Pokemon> query = realm.where(Pokemon.class);
        query.equalTo("pokemonnumber", pokemonnumber);

        Pokemon pokemonresult = query.findFirst();
        if (pokemonresult != null) {
            return new Pokemon(pokemonresult);
        } else {
            return null;
        }
    }

    public static Party getPartyByNumber(int partynumber) {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Party> query = realm.where(Party.class);
        query.equalTo("partynumber", partynumber);

        Party partyresult = query.findFirst();
        if (partyresult != null) {
            return new Party(partyresult);
        } else {
            return null;
        }
    }

    public static List<Pokemon> getPokemonsOfParty(int partynumber) {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<PartyPokemon> query = realm.where(PartyPokemon.class);
        query.equalTo("partynumber", partynumber);

        List<PartyPokemon> partyresult = query.findAll();
        List<Pokemon> pokemonlist = new ArrayList<>();
        RealmQuery<Pokemon> querypokemon = realm.where(Pokemon.class);
        for (PartyPokemon partypokemon:partyresult) {
            querypokemon.equalTo("pokemonnumber", partypokemon.getPokemonnumber());
            Pokemon pokemonresult = querypokemon.findFirst();
            pokemonlist.add(new Pokemon(pokemonresult));
        }
        return pokemonlist;
    }

    public static List<Party> getAllParties() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Party> query = realm.where(Party.class);

        List<Party> partyresult = query.findAll();
        List<Party> partylist = new ArrayList<>();

        for (Party party:partyresult) {
            partylist.add(new Party(party));
        }
        return partylist;
    }

    public static PokemonDetail getPokemonDetail(int pokemonnumber, int pokemonlevel) {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<PokemonDetail> query = realm.where(PokemonDetail.class);
        query.equalTo("pokemonnumber", pokemonnumber).and().equalTo("pokemonlevel", pokemonlevel);

        PokemonDetail pokemonresult = query.findFirst();
        if (pokemonresult != null) {
            return new PokemonDetail(pokemonresult);
        } else {
            return null;
        }
    }

    public static List<PokemonDetail> getAllPokemons() {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<PokemonDetail> query = realm.where(PokemonDetail.class);
        query.equalTo("pokemonlevel", 1);

        List<PokemonDetail> pokemonresult = query.findAll();
        List<PokemonDetail> pokemonlist = new ArrayList<>();
        for (PokemonDetail pokemon:pokemonresult) {
            pokemonlist.add(new PokemonDetail(pokemon));
        }
        return pokemonlist;
    }

    public static List<PartyPokemon> getPokemonsInParty(int partynumber) {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<PartyPokemon> query = realm.where(PartyPokemon.class);
        query.equalTo("partynumber", partynumber);

        List<PartyPokemon> pokemonresult = query.findAll();
        List<PartyPokemon> pokemonlist = new ArrayList<>();
        for (PartyPokemon pokemon:pokemonresult) {
            pokemonlist.add(new PartyPokemon(pokemon));
        }
        return pokemonlist;
    }

    public static PartyPokemon getPokemonByPartyAndNumber(int partynumber, int pokemonnumber) {
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<PartyPokemon> query = realm.where(PartyPokemon.class);
        query.equalTo("pokemonnumber", pokemonnumber).and().equalTo("partynumber", partynumber);

        PartyPokemon pokemonresult = query.findFirst();
        if (pokemonresult != null) {
            return new PartyPokemon(pokemonresult);
        } else {
            return null;
        }
    }

    public static void deletePokemonInParty(PartyPokemon deletedpokemon) {
        Realm realm = Realm.getDefaultInstance();

        RealmQuery<PartyPokemon> query = realm.where(PartyPokemon.class);
        query.equalTo("pokemonnumber", deletedpokemon.getPokemonnumber()).and().equalTo("partynumber", deletedpokemon.getPartynumber());

        PartyPokemon pokemonresult = query.findFirst();

        try {
            realm.beginTransaction();
            pokemonresult.deleteFromRealm();
            realm.commitTransaction();
        } finally {
            realm.close();
        }
    }

}

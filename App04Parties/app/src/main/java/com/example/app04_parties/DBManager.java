package com.example.app04_parties;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

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

}

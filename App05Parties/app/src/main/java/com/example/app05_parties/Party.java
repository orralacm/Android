package com.example.app05_parties;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Party extends RealmObject {


    public Party(int partynumber, String partyname) {
        this.partynumber = partynumber;
        this.partyname = partyname;
    }

    public Party() {
        this.partynumber = 0;
        this.partyname = "";
    }

    public Party(Party party) {
        this.partynumber = party.partynumber;
        this.partyname = party.partyname;
    }

    public int getPartynumber() {
        return partynumber;
    }
    public void setPartynumber(int partynumber) {
        this.partynumber = partynumber;
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    @PrimaryKey
    private int partynumber;
    private String partyname;
}
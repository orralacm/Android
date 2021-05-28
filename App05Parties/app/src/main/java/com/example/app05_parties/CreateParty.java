package com.example.app05_parties;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class CreateParty extends AppCompatActivity {

    EditText inputpartyname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_party);
        setTitle("Create Party");
        inputpartyname = findViewById(R.id.inputpartyname);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.create_party, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save) {
            Party party = new Party();
            party.setPartynumber(DBManager.getAllParties().size() + 1);
            party.setPartyname(inputpartyname.getText().toString());
            DBManager.saveObject(party);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
package com.example.app04_parties;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Evolutions extends AppCompatActivity {

    String Name;
    int Number;
    Pokemon pkmn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evolutions);

        TextView text1 = findViewById(R.id.text1);
        ImageView pokemon = findViewById(R.id.pokemon);
        Button btnclose = findViewById(R.id.btnclose);

        Number = getIntent().getIntExtra("Pokemon Number", 0);
        pkmn = DBManager.getPokemonByNumber(Number);
        text1.setText("The Pokemon Name is: " + pkmn.getPokemonname() + ", it's Pokedex number is: " + pkmn.getPokemonnumber() + " and it's tier level is: " + pkmn.getPokemonlevel());

        if (pkmn.getPokemonnumber() == 101) {
            if (pkmn.getPokemonlevel() == 1) {
                pokemon.setImageResource(R.mipmap.bulbasaur);
            }
            else if (pkmn.getPokemonlevel() == 2) {
                pokemon.setImageResource(R.mipmap.ivysaur);
            }
            else if (pkmn.getPokemonlevel() == 3) {
                pokemon.setImageResource(R.mipmap.venusaur);
            }
        }
        else if (pkmn.getPokemonnumber() == 102) {
            if (pkmn.getPokemonlevel() == 1) {
                pokemon.setImageResource(R.mipmap.charmander);
            }
            else if (pkmn.getPokemonlevel() == 2) {
                pokemon.setImageResource(R.mipmap.charmeleon);
            }
            else if (pkmn.getPokemonlevel() == 3) {
                pokemon.setImageResource(R.mipmap.charizard);
            }
        }
        else if (pkmn.getPokemonnumber() == 103) {
            if (pkmn.getPokemonlevel() == 1) {
                pokemon.setImageResource(R.mipmap.squirtle);
            }
            else if (pkmn.getPokemonlevel() == 2) {
                pokemon.setImageResource(R.mipmap.wartortle);
            }
            else if (pkmn.getPokemonlevel() == 3) {
                pokemon.setImageResource(R.mipmap.blastoise);
            }
        }

        else if (pkmn.getPokemonnumber() == 201) {
            if (pkmn.getPokemonlevel() == 1) {
                pokemon.setImageResource(R.mipmap.chikorita);
            }
            else if (pkmn.getPokemonlevel() == 2) {
                pokemon.setImageResource(R.mipmap.bayleef);
            }
            else if (pkmn.getPokemonlevel() == 3) {
                pokemon.setImageResource(R.mipmap.meganium);
            }
        }
        else if (pkmn.getPokemonnumber() == 202) {
            if (pkmn.getPokemonlevel() == 1) {
                pokemon.setImageResource(R.mipmap.cyndaquil);
            }
            else if (pkmn.getPokemonlevel() == 2) {
                pokemon.setImageResource(R.mipmap.quilava);
            }
            else if (pkmn.getPokemonlevel() == 3) {
                pokemon.setImageResource(R.mipmap.typhlosion);
            }
        }
        else if (pkmn.getPokemonnumber() == 203) {
            if (pkmn.getPokemonlevel() == 1) {
                pokemon.setImageResource(R.mipmap.totodile);
            }
            else if (pkmn.getPokemonlevel() == 2) {
                pokemon.setImageResource(R.mipmap.croconaw);
            }
            else if (pkmn.getPokemonlevel() == 3) {
                pokemon.setImageResource(R.mipmap.feraligatr);
            }
        }

        Button evolve = findViewById(R.id.evolve);

        evolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pkmn.getPokemonnumber() == 101) {
                    if (pkmn.getPokemonlevel() == 1) {
                        pokemon.setImageResource(R.mipmap.ivysaur);
                        pkmn.setPokemonname("Ivysaur");
                        pkmn.setPokemonlevel(2);
                        DBManager.saveObject(pkmn);
                    }
                    else if (pkmn.getPokemonlevel() == 2) {
                        pokemon.setImageResource(R.mipmap.venusaur);
                        pokemon.setScaleX(2);
                        pokemon.setScaleY(2);
                        pkmn.setPokemonname("Venusaur");
                        pkmn.setPokemonlevel(3);
                        DBManager.saveObject(pkmn);
                    }
                }
                else if (pkmn.getPokemonnumber() == 102) {
                    if (pkmn.getPokemonlevel() == 1) {
                        pokemon.setImageResource(R.mipmap.charmeleon);
                        pkmn.setPokemonname("Charmeleon");
                        pkmn.setPokemonlevel(2);
                        DBManager.saveObject(pkmn);
                    }
                    else if (pkmn.getPokemonlevel() == 2) {
                        pokemon.setImageResource(R.mipmap.charizard);
                        pokemon.setScaleX(2);
                        pokemon.setScaleY(2);
                        pkmn.setPokemonname("Charizard");
                        pkmn.setPokemonlevel(3);
                        DBManager.saveObject(pkmn);
                    }
                }
                else if (pkmn.getPokemonnumber() == 103) {
                    if (pkmn.getPokemonlevel() == 1) {
                        pokemon.setImageResource(R.mipmap.wartortle);
                        pkmn.setPokemonname("Wartortle");
                        pkmn.setPokemonlevel(2);
                        DBManager.saveObject(pkmn);
                    }
                    else if (pkmn.getPokemonlevel() == 2) {
                        pokemon.setImageResource(R.mipmap.blastoise);
                        pokemon.setScaleX(2);
                        pokemon.setScaleY(2);
                        pkmn.setPokemonname("Blastoise");
                        pkmn.setPokemonlevel(3);
                        DBManager.saveObject(pkmn);
                    }
                }


                else if (pkmn.getPokemonnumber() == 201) {
                    if (pkmn.getPokemonlevel() == 1) {
                        pokemon.setImageResource(R.mipmap.bayleef);
                        pkmn.setPokemonname("Bayleef");
                        pkmn.setPokemonlevel(2);
                        DBManager.saveObject(pkmn);
                    }
                    else if (pkmn.getPokemonlevel() == 2) {
                        pokemon.setImageResource(R.mipmap.meganium);
                        pokemon.setScaleX(2);
                        pokemon.setScaleY(2);
                        pkmn.setPokemonname("Meganium");
                        pkmn.setPokemonlevel(3);
                        DBManager.saveObject(pkmn);
                    }
                }
                else if (pkmn.getPokemonnumber() == 202) {
                    if (pkmn.getPokemonlevel() == 1) {
                        pokemon.setImageResource(R.mipmap.quilava);
                        pkmn.setPokemonname("Quilava");
                        pkmn.setPokemonlevel(2);
                        DBManager.saveObject(pkmn);
                    }
                    else if (pkmn.getPokemonlevel() == 2) {
                        pokemon.setImageResource(R.mipmap.typhlosion);
                        pokemon.setScaleX(2);
                        pokemon.setScaleY(2);
                        pkmn.setPokemonname("Typhlosion");
                        pkmn.setPokemonlevel(3);
                        DBManager.saveObject(pkmn);
                    }
                }
                else if (pkmn.getPokemonnumber() == 203) {
                    if (pkmn.getPokemonlevel() == 1) {
                        pokemon.setImageResource(R.mipmap.croconaw);
                        pkmn.setPokemonname("Croconaw");
                        pkmn.setPokemonlevel(2);
                        DBManager.saveObject(pkmn);
                    }
                    else if (pkmn.getPokemonlevel() == 2) {
                        pokemon.setImageResource(R.mipmap.feraligatr);
                        pokemon.setScaleX(2);
                        pokemon.setScaleY(2);
                        pkmn.setPokemonname("Feraligatr");
                        pkmn.setPokemonlevel(3);
                        DBManager.saveObject(pkmn);
                    }
                }
                text1.setText("The Pokemon Name is: " + pkmn.getPokemonname() + ", it's Pokedex number is: " + pkmn.getPokemonnumber() + " and it's tier level is: " + pkmn.getPokemonlevel());
            }
        });

        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultintent = new Intent();
                setResult(RESULT_OK, resultintent);
                finish();
            }
        });

    }
}
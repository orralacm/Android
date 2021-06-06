package com.example.app05_parties;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolderHU> {
    List<PokemonDetail> pokemonlist;
    List<Integer> pokemonidselected;
    Boolean needcheckbox;
    Activity context;
    int partynumber;

    public PokemonAdapter(List<PokemonDetail> list, boolean needcheckbox, List<Integer> pokemonidselected, Activity context) {
        pokemonlist = list;
        this.pokemonidselected = pokemonidselected;
        this.needcheckbox = needcheckbox;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderHU onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokemon_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolderHU vh = new ViewHolderHU(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHU holder, int position) {
        PokemonDetail pokemon = pokemonlist.get(position);
        holder.pokemonname.setText(pokemon.getPokemonname());
        holder.pokemonimage.setImageResource(pokemon.getPokemonimage());
        if(needcheckbox) {
            if (pokemonidselected.size() > 0) {
                if (pokemonidselected.indexOf(pokemon.getPokemonnumber()) >= 0) {
                    holder.pokemonselected.setChecked(true);
                }

            }
            holder.pokemonselected.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.pokemonselected.isChecked()) {
                        pokemonidselected.add(pokemon.getPokemonnumber());
                    }
                    else {
                        pokemonidselected.remove(pokemonidselected.indexOf(pokemon.getPokemonnumber()));
                    }
                }
            });
        }
        else {
            holder.pokemonselected.setVisibility(View.GONE);
            if (partynumber > 0) {
                holder.pokemonitem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent pokemonevolution = new Intent(context, PokemonEvolution.class);
                        pokemonevolution.putExtra("pokemonNumber", pokemon.getPokemonnumber());
                        pokemonevolution.putExtra("partyNumber", partynumber);
                        context.startActivityForResult(pokemonevolution, 2001);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return pokemonlist.size();
    }

    public static class ViewHolderHU extends RecyclerView.ViewHolder {

        TextView pokemonname;
        ImageView pokemonimage;
        CheckBox pokemonselected;
        RelativeLayout pokemonitem;

        public ViewHolderHU(View itemView) {
            super(itemView);
            pokemonname = (TextView)itemView.findViewById(R.id.pokemonname);
            pokemonimage = (ImageView)itemView.findViewById(R.id.pokemonimage);
            pokemonselected = (CheckBox)itemView.findViewById(R.id.pokemonselected);
            pokemonitem = (RelativeLayout)itemView.findViewById(R.id.pokemonitem);
        }
    }

    public void update(List<PokemonDetail> list) {
        pokemonlist = list;
        notifyDataSetChanged();
    }

    public List<Integer> getPokemonSelected() {
        return pokemonidselected;
    }

    public void addPokemon(PokemonDetail pokemon) {
        boolean pokemonexist = false;
        for (PokemonDetail currentpokemon:pokemonlist) {
            if (currentpokemon.getPokemonnumber() == pokemon.getPokemonnumber()) {
                pokemonexist = true;
                break;
            }
        }
        if (!pokemonexist) {
            pokemonlist.add(pokemon);
            notifyDataSetChanged();
        }
    }

    public List<PokemonDetail> getPokemonlist() {
        return pokemonlist;
    }

    public void resetPokemonList() {
        pokemonlist = new ArrayList<>();
        notifyDataSetChanged();
    }

    public void setPartynumber(int partynumber) {
        this.partynumber = partynumber;
    }
}

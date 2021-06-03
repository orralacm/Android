package com.example.app05_parties;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PartyAdapter extends RecyclerView.Adapter<PartyAdapter.ViewHolderHU>{
    List<Party> partylist;
    Context context;

    public PartyAdapter(List<Party> list, Context context) {
        partylist = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderHU onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.party_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolderHU vh = new ViewHolderHU(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHU holder, int position) {
        Party party = partylist.get(position);
        holder.partyname.setText(party.getPartyname());
        holder.relativelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CreateParty.class);
                intent.putExtra("PartyNumber", party.getPartynumber());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return partylist.size();
    }

    public static class ViewHolderHU extends RecyclerView.ViewHolder {

        TextView partyname;
        RelativeLayout relativelayout;

        public ViewHolderHU(View itemView) {
            super(itemView);
            partyname = (TextView)itemView.findViewById(R.id.partyname);
            relativelayout = (RelativeLayout)itemView.findViewById(R.id.relativelayout);
        }
    }

    public void update(List<Party> list) {
        partylist = list;
        notifyDataSetChanged();
    }
}

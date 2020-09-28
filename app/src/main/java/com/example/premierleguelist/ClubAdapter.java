package com.example.premierleguelist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ClubViewHolder> {

    private Context context;

    private ArrayList<Clubs> clubsArrayList;

    public ClubAdapter(Context context, ArrayList<Clubs> arrayList)
    {
        this.clubsArrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ClubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items,null);
        return new ClubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubViewHolder clubViewHolder, int position) {

        Clubs clubs = clubsArrayList.get(position);
        clubViewHolder.textname.setText(clubs.getNames());
        clubViewHolder.imageView.setImageResource(clubs.getImages());


    }

    @Override
    public int getItemCount() {
        return clubsArrayList.size();
    }

    public class ClubViewHolder extends RecyclerView.ViewHolder {

        private TextView textname;
        private ImageView imageView;
        private CardView cardView;


        public ClubViewHolder(@NonNull View itemView) {
            super(itemView);
            textname = (TextView)itemView.findViewById(R.id.name);
            imageView = (ImageView)itemView.findViewById(R.id.thumbtail);
            cardView = (CardView)itemView.findViewById(R.id.cardview);

        }
    }


}
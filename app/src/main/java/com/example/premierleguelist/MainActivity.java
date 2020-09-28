package com.example.premierleguelist;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Clubs> clubsArrayList;
    private ClubAdapter clubAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclelist);
        clubsArrayList = new ArrayList<>();
        clubsArrayList.add(new Clubs("Arsenal", R.drawable.arsenal));
        clubsArrayList.add(new Clubs("Aston Villa", R.drawable.aston_villa));
        clubsArrayList.add(new Clubs("Burney FC", R.drawable.burney_fc_hd_logo));
        clubsArrayList.add(new Clubs("Chelsea", R.drawable.chelsea));
        clubsArrayList.add(new Clubs("Crystal Palace FC", R.drawable.crystal_palace_fc));
        clubsArrayList.add(new Clubs("Everton FC", R.drawable.everton_fc_logo1));
        clubsArrayList.add(new Clubs("Hull City FC", R.drawable.hull_city_afc_hd_logo));
        clubsArrayList.add(new Clubs("Leicester City", R.drawable.leicester_city_fc_hd_logo));
        clubsArrayList.add(new Clubs("Liverpool", R.drawable.liverpool));
        clubsArrayList.add(new Clubs("Manchester City", R.drawable.manchester_city));
        clubsArrayList.add(new Clubs("Manchester United", R.drawable.manchester_united));
        clubsArrayList.add(new Clubs("Newcastle United", R.drawable.newcastle_united));
        clubsArrayList.add(new Clubs("Queen Park Rangers", R.drawable.queens_park_rangers_hd_logo));
        clubsArrayList.add(new Clubs("Southampton", R.drawable.southampton_fc));
        clubsArrayList.add(new Clubs("Stoke City", R.drawable.stoke_city));
        clubsArrayList.add(new Clubs("Sunderland AFC", R.drawable.sunderland));
        clubsArrayList.add(new Clubs("Swansea City AFC", R.drawable.swansea_city_afc));
        clubsArrayList.add(new Clubs("Spurs", R.drawable.tottenham_hotspur));
        clubsArrayList.add(new Clubs("West Bromwish Albion", R.drawable.west_bromwich_albion_hd_logo));
        clubsArrayList.add(new Clubs("West Ham", R.drawable.west_ham));

        clubAdapter = new ClubAdapter(this,clubsArrayList);
        mRecyclerView.setAdapter(clubAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

    }
    final ItemTouchHelper.Callback simpleItemTouchCallback = new ItemTouchHelper.Callback() {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            if (viewHolder.getAdapterPosition() < target.getAdapterPosition()) {
                for (int i = viewHolder.getAdapterPosition(); i < target.getAdapterPosition(); i++) {
                    Collections.swap(clubsArrayList, i, i + 1);
                }
            } else {
                for (int i = viewHolder.getAdapterPosition(); i > target.getAdapterPosition(); i--) {
                    Collections.swap(clubsArrayList, i, i - 1);
                }
            }
            clubAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
            return true;
        }

        @Override
        public boolean isLongPressDragEnabled() {
            return true;
        }
        @Override
        public boolean isItemViewSwipeEnabled() {
            return true;
        }
        @Override
        public void onSwiped(final RecyclerView.ViewHolder viewHolder, final int swipeDir) {

        }

        @Override
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            View itemView = viewHolder.itemView;
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

        @Override
        public int getMovementFlags(RecyclerView recyclerView,
                                    RecyclerView.ViewHolder viewHolder) {
            int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
            return makeMovementFlags(dragFlags, swipeFlags);
        }
    };





}

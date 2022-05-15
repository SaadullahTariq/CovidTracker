package com.example.covidtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StateRVAdapter extends RecyclerView.Adapter<StateRVAdapter.MyViewHolder> {

    Context context;
    ArrayList<StateModel> stateModels;

    public StateRVAdapter(Context context, ArrayList<StateModel> stateModels) {
        this.context = context;
        this.stateModels = stateModels;
    }

    @NonNull
    @Override
    public StateRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.state_rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateRVAdapter.MyViewHolder holder, int position) {


        holder.tvstatecases.setText(stateModels.get(position).getCases());
        holder.tvstaterecovered.setText(stateModels.get(position).getRecovered());
        holder.tvstatedeaths.setText(stateModels.get(position).getDeaths());
        holder.tvState.setText(stateModels.get(position).getState());

    }

    @Override
    public int getItemCount() {

        return stateModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvstatecases, tvstaterecovered, tvstatedeaths, tvState;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvstatecases = itemView.findViewById(R.id.tvstatecases);
            tvstaterecovered = itemView.findViewById(R.id.tvstaterecovered);
            tvstatedeaths = itemView.findViewById(R.id.tvstatedeaths);
            tvState = itemView.findViewById(R.id.TVStates);
        }
    }

}

package com.example.covidtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<StateModel> {

    private Context context;
    private List<StateModel> stateModelArray;

    public MyCustomAdapter(Context context, List<StateModel> stateModelArray) {
        super(context, R.layout.list_custom_item, stateModelArray);

        this.context = context;
        this.stateModelArray = stateModelArray;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item, null, true);
        TextView tvdistrict = view.findViewById(R.id.tvdistrict);
        TextView tvdetailcases = view.findViewById(R.id.tvdetailcases);
        TextView tvdetailrecovered = view.findViewById(R.id.tvdetailrecovered);
        TextView tvdetaildeaths = view.findViewById(R.id.tvdetaildeaths);

        tvdistrict.setText(stateModelArray.get(position).getState());
        tvdetailcases.setText(stateModelArray.get(position).getActive());
        tvdetailrecovered.setText(stateModelArray.get(position).getRecovered());
        tvdetaildeaths.setText(stateModelArray.get(position).getDeaths());

        return view;
    }
}

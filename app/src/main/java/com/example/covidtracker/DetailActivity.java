package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    TextView tvdetailcases, tvdetailrecovered, tvdetaildeaths;
    RecyclerView stateRV;
    StateRVAdapter stateRVAdapter;
    ArrayList<StateModel> stateList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvdetailcases = findViewById(R.id.tvdetailcases);
        tvdetailrecovered = findViewById(R.id.tvdetailrecovered);
        tvdetaildeaths = findViewById(R.id.tvdetaildeaths);
        stateRV = findViewById(R.id.RVStates);
        stateInfo();

    }

    private void stateInfo() {
        String url = "https://api.rootnet.in/covid19-in/stats/latest";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                response -> {

                    try {
                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject dataObj = jsonObject.getJSONObject("data");
                        JSONObject summaryObj = dataObj.getJSONObject("summary");

                        tvdetailcases.setText(summaryObj.getString("total"));
                        tvdetailrecovered.setText(summaryObj.getString("discharged"));
                        tvdetaildeaths.setText(summaryObj.getString("deaths"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }, error -> Toast.makeText(DetailActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show());

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

}
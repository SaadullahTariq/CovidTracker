package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class DetailActivity extends AppCompatActivity {

    ListView listView;
    TextView tvdetailcases, tvdetailrecovered, tvdetaildeaths;

    public static List<StateModel> stateModelList = new ArrayList<>();
    StateModel stateModel;
    MyCustomAdapter myCustomAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        listView = findViewById(R.id.listView);
        tvdetailcases = findViewById(R.id.tvdetailcases);
        tvdetailrecovered = findViewById(R.id.tvdetailrecovered);
        tvdetaildeaths = findViewById(R.id.tvdetaildeaths);

        stateInfo();
}

    private void stateInfo() {

        String url = "https://api.rootnet.in/covid19-in/stats/latest/";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                response -> {

                    try {
                        JSONObject jsonObject = new JSONObject(response);

                        JSONObject dataObj = jsonObject.getJSONObject("data");
                        JSONObject summaryObj = dataObj.getJSONObject("summary");
                        JSONArray jsonArray = dataObj.getJSONArray("regional");

                        tvdetailcases.setText(summaryObj.getString("total"));
                        tvdetailrecovered.setText(summaryObj.getString("discharged"));
                        tvdetaildeaths.setText(summaryObj.getString("deaths"));

                        for (int i=0;i<jsonArray.length();i++){

                            JSONObject regionalObj = jsonArray.getJSONObject(i);

                            String state = regionalObj.getString("loc");
                            String active = regionalObj.getString("totalConfirmed");
                            String recovered = regionalObj.getString("discharged");
                            String deaths = regionalObj.getString("deaths");

                            stateModel = new StateModel(state,active,recovered,deaths);
                            stateModelList.add(stateModel);

                        }

                        myCustomAdapter = new MyCustomAdapter(DetailActivity.this, stateModelList);
                        listView.setAdapter(myCustomAdapter);





                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }, error -> Toast.makeText(DetailActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show());

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }

}
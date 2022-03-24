package com.uppa.nationalite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText etSearch;
    Button btnSearch;
    RecyclerView recyclerView;
    List<CountryItem> listeCountry;
    CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch = findViewById(R.id.etSearch);
        btnSearch = findViewById(R.id.btnSearch);
        recyclerView = findViewById(R.id.recyclerView);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://api.nationalize.io/")
                        .build();

                NationalityApi service = retrofit.create(NationalityApi.class);
                Log.d("TEST",etSearch.getText().toString());
                Call<Response> locationCall = service.getCountry(etSearch.getText().toString());
                locationCall.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        Response response1 = response.body();
                        Log.d("TEST", response1.getCountry().get(0).getCountryId());
                        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(lm);
                        listeCountry = new ArrayList(response1.getCountry());
                        adapter = new CountryAdapter(listeCountry);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                    }
                });

            }
        });
    }
}
package org.appspot.mid_term;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.appspot.mid_term.adapter.ListAdapter;
import org.appspot.mid_term.dto.dtoDonor;

import java.util.ArrayList;

public class SearchDonorActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_Query;
    Button button_Search;
    ListView lv_SearchResults;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_donor);
        initComponents();
        initListeners();
    }

    private void initComponents() {
        et_Query = findViewById(R.id.et_Query);
        button_Search = findViewById(R.id.button_Search);
        lv_SearchResults = findViewById(R.id.lv_SearchResults);

        initListView(new ArrayList<>());
    }

    private void initListeners() {
        button_Search.setOnClickListener(this);
    }

    private void initListView(ArrayList<dtoDonor> donors) {
        listAdapter = new ListAdapter(donors, this);
        lv_SearchResults.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(button_Search)) {
            String queryText = et_Query.getText().toString().trim();
            if (!TextUtils.isEmpty(queryText)) {
                ArrayList<dtoDonor> donorArrayList = new ArrayList<>();
                for (dtoDonor donor : MainActivity.donorList) {
                    if (donor.getBloodGroup().toLowerCase().contains(queryText.toLowerCase())
                            || donor.getName().toLowerCase().contains(queryText.toLowerCase())) {
                        donorArrayList.add(donor);
                    }
                }

                initListView(donorArrayList);
            }
        }
    }
}
package org.appspot.mid_term;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.appspot.mid_term.dto.dtoDonor;

public class AddDonorActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_AddDonor;
    EditText editTextTextPersonName, et_BloodGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donor);
        initComponents();
        initListeners();
    }

    private void initComponents() {
        btn_AddDonor = findViewById(R.id.btn_AddDonor);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        et_BloodGroup = findViewById(R.id.et_BloodGroup);
    }

    private void initListeners() {
        btn_AddDonor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btn_AddDonor)) {
            String userName = editTextTextPersonName.getText().toString().trim();
            String bloodGroup = et_BloodGroup.getText().toString().trim();
            if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(bloodGroup)) {
                MainActivity.donorList.add(new dtoDonor(userName, bloodGroup));
                editTextTextPersonName.setText("");
                et_BloodGroup.setText("");
                Toast.makeText(this, "Successfully added.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Invalid Data", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
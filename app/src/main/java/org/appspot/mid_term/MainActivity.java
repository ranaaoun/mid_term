package org.appspot.mid_term;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.appspot.mid_term.dto.dtoDonor;
import org.appspot.mid_term.ui.detail.DetailFragment;
import org.appspot.mid_term.ui.detail.DetailViewModel;
import org.appspot.mid_term.ui.list.ListFragment;
import org.appspot.mid_term.ui.main.AddNewDonorFragment;
import org.appspot.mid_term.viewModel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<dtoDonor> donorList = new ArrayList<>();
    private FrameLayout frameLayout_List, frameLayout_Detail, frameLayout_AddDonor;
    public MainViewModel mainViewModel;
    public DetailViewModel detailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.init();


        populateDummyData();
        initComponents();
        initListeners();

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, AddNewDonorFragment.newInstance())
//                    .commitNow();
//        }
    }

    private void initComponents() {
        frameLayout_List = findViewById(R.id.frameLayout_List);
        frameLayout_Detail = findViewById(R.id.frameLayout_Detail);
        frameLayout_AddDonor = findViewById(R.id.frameLayout_AddDonor);

        loadFragment("ViewDonors", R.id.frameLayout_List);
        loadFragment("DonorDetail", R.id.frameLayout_Detail);
        loadFragment("AddNewDonorFragment", R.id.frameLayout_AddDonor);
    }

    private void initListeners() {

    }

    private void populateDummyData() {
        donorList.add(new dtoDonor("Farooq", "A"));
        donorList.add(new dtoDonor("Ali", "A+"));
        donorList.add(new dtoDonor("Tahir", "A-"));
        donorList.add(new dtoDonor("Danish", "B"));
        donorList.add(new dtoDonor("Ateeq", "B+"));
        donorList.add(new dtoDonor("Nadeem", "B-"));
        donorList.add(new dtoDonor("Faizan", "B-"));
        donorList.add(new dtoDonor("Bilal", "AB"));
        donorList.add(new dtoDonor("Adeel", "AB+"));
        donorList.add(new dtoDonor("Maaz", "AB-"));
        donorList.add(new dtoDonor("Ahmad", "O"));
        donorList.add(new dtoDonor("Shahbaz", "O+"));
        donorList.add(new dtoDonor("Haider", "O-"));
    }

    private Fragment getFragment(String fragmentName) {
        if (fragmentName.equals("AddDonor")) {

        } else if (fragmentName.equals("SearchDonor")) {

        } else if (fragmentName.equals("ViewDonors")) {
            return ListFragment.newInstance();
        } else if (fragmentName.equals("DonorDetail")) {
            return DetailFragment.newInstance();
        } else if (fragmentName.equals("AddNewDonorFragment")) {
            return AddNewDonorFragment.newInstance();
        }
        return null;
    }

    public void loadFragment(String fragmentName, int frameLayoutId) {
        Fragment fragment = getFragment(fragmentName);
        getSupportFragmentManager().beginTransaction()
                .replace(frameLayoutId, fragment)
                .commitNow();
    }


}
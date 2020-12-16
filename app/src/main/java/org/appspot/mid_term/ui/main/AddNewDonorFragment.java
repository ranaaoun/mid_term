package org.appspot.mid_term.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.appspot.mid_term.AddDonorActivity;
import org.appspot.mid_term.R;
import org.appspot.mid_term.SearchDonorActivity;

public class AddNewDonorFragment extends Fragment implements View.OnClickListener {

    private AddNewDonorViewModel mViewModel;
    private Button button_AddDonor, button_ViewDonors, button_SearchDonor;

    public static AddNewDonorFragment newInstance() {
        return new AddNewDonorFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        initComponents(view);
        initListener();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddNewDonorViewModel.class);
        // TODO: Use the ViewModel
    }

    private void initComponents(View view) {
        button_AddDonor = view.findViewById(R.id.button_AddDonor);
        button_SearchDonor = view.findViewById(R.id.button_SearchDonor);
    }

    private void initListener() {
        button_AddDonor.setOnClickListener(this);
        button_SearchDonor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(button_AddDonor)) {
            startActivity(new Intent(getActivity(), AddDonorActivity.class));
        } else if (view.equals(button_SearchDonor)) {
            startActivity(new Intent(getActivity(), SearchDonorActivity.class));
        }
    }
}
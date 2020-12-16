package org.appspot.mid_term.ui.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.appspot.mid_term.R;
import org.appspot.mid_term.viewModel.MainViewModel;

public class DetailFragment extends Fragment implements View.OnClickListener {

    private DetailViewModel mViewModel;
    private TextView textView_Detail;
    private MainViewModel mainViewModel;
    private ImageView imageView_Phone, imageView_Map;


    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        initComponent(view);
        initListeners();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        mainViewModel.getDonorMutableLiveData().observe(getViewLifecycleOwner(), donor -> {
            if (donor != null) {
                textView_Detail.setText(donor.getName() + donor.getBloodGroup());
            }
        });

        // TODO: Use the ViewModel
    }

    private void initComponent(View view) {
        textView_Detail = view.findViewById(R.id.textView_Detail);
        imageView_Phone = view.findViewById(R.id.imageView_Phone);
        imageView_Map = view.findViewById(R.id.imageView_Map);
    }

    private void initListeners() {
        imageView_Phone.setOnClickListener(this);
        imageView_Map.setOnClickListener(this);
    }

    private void openDialer() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:090078601"));
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        if (view.equals(imageView_Phone)) {
            openDialer();
        }
    }
}
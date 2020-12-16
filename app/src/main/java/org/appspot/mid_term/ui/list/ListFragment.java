package org.appspot.mid_term.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.appspot.mid_term.MainActivity;
import org.appspot.mid_term.R;
import org.appspot.mid_term.adapter.ListAdapter;
import org.appspot.mid_term.dto.dtoDonor;
import org.appspot.mid_term.viewModel.MainViewModel;

public class ListFragment extends Fragment {

    private ListViewModel mViewModel;
    private ConstraintLayout constraintLayout;
    private ListView listView;
    private ListAdapter listAdapter;
    private MainViewModel mainViewModel;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        initComponents(view);
        initListeners();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    private void initComponents(View view) {
        listView = view.findViewById(R.id.listView);

    }

    private void initListeners() {

    }

    @Override
    public void onResume() {
        super.onResume();
        initRecyclerView();
    }

    private void initRecyclerView() {
        listAdapter = new ListAdapter(MainActivity.donorList, getContext());
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            dtoDonor donor = MainActivity.donorList.get(i);
            mainViewModel.setDonorMutableLiveData(donor);
        });
    }

}
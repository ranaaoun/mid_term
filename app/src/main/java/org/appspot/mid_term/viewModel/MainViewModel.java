package org.appspot.mid_term.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.appspot.mid_term.dto.dtoDonor;

public class MainViewModel extends ViewModel {
    private MutableLiveData<dtoDonor> donorMutableLiveData;

    public void init() {
        donorMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<dtoDonor> getDonorMutableLiveData() {
        return donorMutableLiveData;
    }

    public void setDonorMutableLiveData(dtoDonor donorMutableLiveData) {
        this.donorMutableLiveData.setValue(donorMutableLiveData);
    }
}

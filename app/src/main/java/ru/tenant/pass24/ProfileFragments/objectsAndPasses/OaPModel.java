package ru.tenant.pass24.ProfileFragments.objectsAndPasses;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OaPModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OaPModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is share fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
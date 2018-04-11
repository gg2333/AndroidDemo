package com.master.android.meitu.image;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.master.android.datasource.MeituRepository;
import com.master.android.meitu.ImageResponse;

public class ImageViewModel extends ViewModel{

    private MutableLiveData<ImageResponse> liveData = new MutableLiveData<>();

    public MutableLiveData<ImageResponse> liveData() {
        return liveData;
    }

    private MutableLiveData<ImageResponse> nextPageLiveData = new MutableLiveData<>();

    public MutableLiveData<ImageResponse> nextPageLiveData() {
        return nextPageLiveData;
    }

    public void refresh(String id) {
        MeituRepository.requestImageResponse(id, 0L, liveData);
    }

    public void nextPage(String id, Long maxTime) {
        MeituRepository.requestImageResponse(id, maxTime, nextPageLiveData);
    }

}

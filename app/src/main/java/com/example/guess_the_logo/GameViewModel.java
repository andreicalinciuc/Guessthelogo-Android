package com.example.guess_the_logo;

import android.content.res.Resources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class GameViewModel extends ViewModel {

    public final MutableLiveData<GameModel> userLiveData = new MutableLiveData<>();

    public GameViewModel(List<Integer> image_list, Resources resources) {
        userLiveData.setValue(new GameModel(image_list, resources));
    }

    void chooseCharacter(String character) {
        // depending on the action, do necessary business logic calls and update the
        // userLiveData.
        userLiveData.getValue().chooseCharacter(character);

    }
}
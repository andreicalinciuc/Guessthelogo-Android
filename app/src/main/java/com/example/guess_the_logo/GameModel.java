package com.example.guess_the_logo;

import android.content.res.Resources;
import android.util.Log;
import android.util.Pair;

import com.example.guess_the_logo.Common.Common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class GameModel implements Serializable {
    public int getScore() {
        return score;
    }

    public int getHighScore() {
        return highScore;
    }

    public int getCurrentLogo() {
        return images.get(currentImageIndex).second;
    }

    int score;
    int currentImageIndex;
    int highScore;
    List<Pair<String, Integer>> images;

    public GameModel(List<Integer> image_list, Resources resources, Integer highScore) {
        this.score = 0;
        this.highScore = highScore != null ? highScore : 0;
        images = new ArrayList<>();
        for (Integer imgResId : image_list) {
            images.add(new Pair<String, Integer>(resources.getResourceName(imgResId).split("/")[1], imgResId));
        }
        newRound();
    }


    public void checkName(String logoName) {
        Log.e(null, logoName);
        Log.e(null, images.get(currentImageIndex).first);

        if (logoName.equalsIgnoreCase(images.get(currentImageIndex).first)) {
            score++;

        } else {
            highScore = Math.max(highScore, score);
            score = 0;

        }
        newRound();
    }

    private void newRound() {
        currentImageIndex = new Random().nextInt(images.size());

        onNewRound();
    }

    public abstract void onNewRound();
}



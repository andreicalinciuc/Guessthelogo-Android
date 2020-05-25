package com.example.guess_the_logo;

import android.content.res.Resources;
import android.util.Pair;

import com.example.guess_the_logo.Common.Common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameModel implements Serializable {
    int score;
    int currentImage;
    List<String> characterChoices;
    List<String> charactersLeft;
    List<Pair<String, Integer>> images;

    public GameModel(List<Integer> image_list, Resources resources) {
        this.score = 0;

        for (Integer imgResId : image_list) {
            images.add(new Pair<String, Integer>(resources.getResourceName(imgResId), imgResId));
        }
        newRound();
    }


    public void chooseCharacter(String character) {
        if (characterChoices.remove(character)) {
            boolean correctAnswer = this.charactersLeft.remove(character);
            if (correctAnswer) {
                score++;
            } else {
                score--;
            }
            if (charactersLeft.size() == 0) {
                newRound();
            }
        }

    }

    private void newRound() {
        Pair<String, Integer> current = images.get(new Random().nextInt(images.size()));
        currentImage = current.second;
        charactersLeft = Arrays.asList(current.first.split(""));

        this.characterChoices = new ArrayList<>(charactersLeft);
        for (int i = charactersLeft.size(); i < charactersLeft.size() * 2; i++)
            characterChoices.add(Common.alphabet[new Random().nextInt(Common.alphabet.length)]);
        Collections.shuffle(characterChoices);

    }
}



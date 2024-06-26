package com.example.game_a.Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.game_a.Model.BallSlot;
import com.example.game_a.Model.ManSlot;
import com.example.game_a.R;

public class DataManager {
    private static int[] ManSlotlotImages = new int[]{
            R.color.lightBackground,
            R.drawable.man,
            R.color.lightBackground

    };
    private static boolean[] isShowingSlots = new boolean[]{
            false,
            true,
            false,
    };

    public static List<ManSlot> getManSlots(){
        ArrayList<ManSlot> allManSlots = new ArrayList<>();
        for (int i = 0; i < ManSlotlotImages.length; i++) {
            allManSlots.add(
                    new ManSlot()
                            .setSlotImage(ManSlotlotImages[i])
                            .setShowing(isShowingSlots[i])
            );
        }
        return allManSlots;
    }
}

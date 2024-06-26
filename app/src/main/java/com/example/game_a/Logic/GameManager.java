package com.example.game_a.Logic;

import com.example.game_a.Model.BallSlot;
import com.example.game_a.Model.ManSlot;
import com.example.game_a.R;

import java.util.ArrayList;
import java.util.List;



public class GameManager {
    private List<ManSlot> allManSlots;

    private ArrayList<BallSlot> AllBallSlots;
    private int ballCatches;
    private int ballMisses;
    private ArrayList<ManSlot> AllManSlots;
    private static final int BallImage = R.drawable.poop;
    private static final int ManImage = R.drawable.man;

    public GameManager() {
        allManSlots = DataManager.getManSlots();
    }

    public List<ManSlot> getAllManSlots() {
        return AllManSlots;
    }

    public GameManager setAllManSlots(ArrayList<ManSlot> allManSlots) {
        AllManSlots = allManSlots;
        return this;
    }



    public ArrayList<BallSlot> getAllBallSlots() {
        return AllBallSlots;
    }

    public GameManager setAllBallSlots(ArrayList<BallSlot> allBallSlots) {
        AllBallSlots = allBallSlots;
        return this;
    }

    public int getBallCatches() {
        return ballCatches;
    }

    public GameManager setBallCatches(int ballCatches) {
        this.ballCatches = ballCatches;
        return this;
    }

    public int getBallMisses() {
        return ballMisses;
    }

    public GameManager setBallMisses(int ballMisses) {
        this.ballMisses = ballMisses;
        return this;
    }
}

package com.example.game_a.Model;

public class BallSlot {
    private String name;
    private boolean isShowing;
    private int SlotImage;


    public BallSlot() {
    }

    public int getSlotImage() {
        return SlotImage;
    }

    public BallSlot setSlotImage(int slotImage) {
        SlotImage = slotImage;
        return this;
    }

    public String getName() {
        return name;
    }

    public BallSlot setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isShowing() {
        return isShowing;
    }

    public BallSlot setShowing(boolean showing) {
        isShowing = showing;
        return this;
    }
}

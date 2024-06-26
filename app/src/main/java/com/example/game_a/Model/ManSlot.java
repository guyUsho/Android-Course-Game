package com.example.game_a.Model;

public class ManSlot {

    private boolean isShowing;
    private int SlotImage;


    public ManSlot() {
    }


    public int getSlotImage() {
        return SlotImage;
    }

    public ManSlot setSlotImage(int slotImage) {
        SlotImage = slotImage;
        return this;
    }


    public boolean isShowing() {
        return isShowing;
    }

    public ManSlot setShowing(boolean showing) {
        isShowing = showing;
        return this;
    }




}

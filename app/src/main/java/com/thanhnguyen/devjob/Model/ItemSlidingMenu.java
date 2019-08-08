package com.thanhnguyen.devjob.Model;

public class ItemSlidingMenu {
    private int image;
    private String content;
    private boolean isSelected;
    public ItemSlidingMenu(int image, String content, boolean isSelected) {
        this.image = image;
        this.content = content;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ", isSelected=" + isSelected + "";
    }
}

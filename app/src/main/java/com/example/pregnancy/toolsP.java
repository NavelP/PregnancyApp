package com.example.pregnancy;

public class toolsP {
    public int image;
    public String tools_name, background;

    public toolsP(int image, String tools_name, String background) {
        this.image = image;
        this.tools_name = tools_name;
        this.background = background;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTools_name() {
        return tools_name;
    }

    public void setTools_name(String tools_name) {
        this.tools_name = tools_name;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}

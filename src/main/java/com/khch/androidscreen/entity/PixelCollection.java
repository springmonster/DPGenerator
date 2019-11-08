package com.khch.androidscreen.entity;

import java.util.ArrayList;
import java.util.List;

public class PixelCollection {

    private List<StandardPixel> standardPixelList = new ArrayList<StandardPixel>();
    private List<Pixel> pixelList = new ArrayList<Pixel>();

    public void addStandardPixel(StandardPixel standardPixel) {
        standardPixelList.add(standardPixel);
    }

    public void addPixel(Pixel pixel) {
        pixelList.add(pixel);
    }

    public List<StandardPixel> getStandardPixelList() {
        return standardPixelList;
    }

    public List<Pixel> getPixelList() {
        return pixelList;
    }
}

package com.khch.androidscreen.ui;

import com.khch.androidscreen.entity.PixelCollection;
import com.khch.androidscreen.utils.PixelConfigurationUtils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private TopStandardPixelLayout standardPixelLayout;
    private CenterPixelLayout pixelLayout;
    private BottomGenerateLayout generateLayout;

    public MainFrame() {
        super();

        PixelCollection pixelCollection = PixelConfigurationUtils.readConfiguration();

        this.setSize(500, 300);
        this.setLocation(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("适配工具");
        this.setResizable(false);


        pixelLayout = new CenterPixelLayout(pixelCollection.getPixelList());
        standardPixelLayout = new TopStandardPixelLayout(pixelCollection.getStandardPixelList());
        generateLayout = new BottomGenerateLayout(this);

        this.add(standardPixelLayout, BorderLayout.NORTH);
        this.add(pixelLayout, BorderLayout.CENTER);
        this.add(generateLayout, BorderLayout.SOUTH);

        setVisible(true);
    }

    String getStandardPixelStr() {
        return standardPixelLayout.getStandardPixel();
    }

    List<String> getPixelStrList() {
        return pixelLayout.getTargetPixelValues();
    }
}

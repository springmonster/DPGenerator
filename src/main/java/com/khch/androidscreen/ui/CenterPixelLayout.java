package com.khch.androidscreen.ui;

import com.khch.androidscreen.entity.Pixel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class CenterPixelLayout extends JPanel {

    CenterPixelLayout(List<Pixel> pixelList) {

        this.add(new JLabel("选择想要生成的目标尺寸:"));

        for (Pixel pixel : pixelList) {
            this.add(new JCheckBox(pixel.getValue()));
        }
    }

    List<String> getTargetPixelValues() {
        List<String> lists = new ArrayList<String>();

        for (int i = 0; i < this.getComponents().length; i++) {
            if (this.getComponent(i) instanceof JCheckBox) {
                JCheckBox jCheckBox = (JCheckBox) this.getComponent(i);
                if (jCheckBox.isSelected()) {
                    lists.add(jCheckBox.getActionCommand());
                }
            }
        }

        return lists;
    }
}

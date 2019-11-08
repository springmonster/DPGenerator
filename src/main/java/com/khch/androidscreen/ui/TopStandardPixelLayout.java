package com.khch.androidscreen.ui;

import com.khch.androidscreen.entity.StandardPixel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TopStandardPixelLayout extends JPanel {

    private String strSelect = "选择效果图尺寸:";


    private ButtonGroup group;
    private List<JRadioButton> jrbList = new ArrayList<JRadioButton>();

    /**
     * 构造容器
     */
    TopStandardPixelLayout(List<StandardPixel> standardPixelList) {

        JLabel jlShow = new JLabel(strSelect);
        this.add(jlShow);

        group = new ButtonGroup();

        for (StandardPixel standardPixel : standardPixelList) {
            JRadioButton jRadioButton = new JRadioButton(standardPixel.getValue());
            group.add(jRadioButton);
            this.add(jRadioButton);
            jrbList.add(jRadioButton);
        }
    }

    String getStandardPixel() {
        for (JRadioButton jRadioButton : jrbList) {
            if (jRadioButton.isSelected()) {
                return jRadioButton.getText();
            }
        }
        return null;
    }
}

package com.dqqdo.androidscreen.ui;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TopLayout extends JPanel {

    private String strSelect = "选择效果图尺寸:";


    private ButtonGroup group;
    private JRadioButton jrb480x800;
    private JRadioButton jrb1280x800;
    private JRadioButton jrb375x667;

    /**
     * 构造容器
     */
    TopLayout() {

        JLabel jlShow = new JLabel(strSelect);
        this.add(jlShow);

        group = new ButtonGroup();

        jrb480x800 = new JRadioButton("750x1334");
        group.add(jrb480x800);
        this.add(jrb480x800);

        jrb1280x800 = new JRadioButton("1280x800");
        group.add(jrb1280x800);
        this.add(jrb1280x800);

        jrb375x667 = new JRadioButton("375x667");
        this.add(jrb375x667);
        jrb375x667.setSelected(true);
        group.add(jrb375x667);
        this.add(jrb375x667);

    }

    public String getSrcSize() {

        if (jrb480x800.isSelected()) {
            return "750";
        } else if (jrb1280x800.isSelected()) {
            return "800";
        } else if (jrb375x667.isSelected()) {
            return "375";
        }

        return null;
    }
}

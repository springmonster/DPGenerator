package com.dqqdo.androidscreen.ui;

import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CenterLayout extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = -3503191094211761668L;

    JCheckBox item, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, item16, item17, item18, item19;

    CenterLayout() {

        this.add(new JLabel("选择想要生成的目标尺寸:"));

        item = new JCheckBox("hdpi-960x540");
        this.add(item);
        item2 = new JCheckBox("hdpi-1024x600");
        this.add(item2);
        item3 = new JCheckBox("hdpi-1280x720");
        this.add(item3);
        item4 = new JCheckBox("ldpi-400x240");
        this.add(item4);
        item5 = new JCheckBox("ldpi-480x320");
        this.add(item5);
        item6 = new JCheckBox("mdpi-800x480");
        this.add(item6);
        //google 机型
        item7 = new JCheckBox("mdpi-800x600");
        this.add(item7);
        item8 = new JCheckBox("mdpi-1024x600");
        this.add(item8);
        item9 = new JCheckBox("mdpi-1024x768");
        this.add(item9);
        item10 = new JCheckBox("mdpi-1280x720");
        this.add(item10);

        item11 = new JCheckBox("xhdpi-960x640");
        this.add(item11);
        item12 = new JCheckBox("xhdpi-1184x720");
        this.add(item12);
        item13 = new JCheckBox("xhdpi-1280x720");
        this.add(item13);
        item14 = new JCheckBox("xhdpi-1280x800");
        this.add(item14);
        item15 = new JCheckBox("xhdpi-1776x1080");
        this.add(item15);
        item16 = new JCheckBox("xhdpi-1920x1080");
        this.add(item16);

        item17 = new JCheckBox("xxxhdpi-2772x1440");
        this.add(item17);

        item18 = new JCheckBox("xxxhdpi-2880x1440");
        this.add(item18);

        item19 = new JCheckBox("xxxhdpi-2560x1440");
        this.add(item19);
    }


    public LinkedList<String> getTargetValues() {

        LinkedList<String> lists = new LinkedList<String>();


        if (item.isSelected()) {
            String actionCommand = item.getActionCommand();
            lists.add(actionCommand);
        }
        if (item2.isSelected()) {
            String actionCommand = item2.getActionCommand();
            lists.add(actionCommand);
        }
        if (item3.isSelected()) {
            String actionCommand = item3.getActionCommand();
            lists.add(actionCommand);
        }
        if (item4.isSelected()) {
            String actionCommand = item4.getActionCommand();
            lists.add(actionCommand);
        }
        if (item5.isSelected()) {
            String actionCommand = item5.getActionCommand();
            lists.add(actionCommand);
        }
        if (item6.isSelected()) {
            String actionCommand = item6.getActionCommand();
            lists.add(actionCommand);
        }
        if (item7.isSelected()) {
            String actionCommand = item7.getActionCommand();
            lists.add(actionCommand);
        }
        if (item8.isSelected()) {
            String actionCommand = item8.getActionCommand();
            lists.add(actionCommand);
        }
        if (item9.isSelected()) {
            String actionCommand = item9.getActionCommand();
            lists.add(actionCommand);
        }
        if (item10.isSelected()) {
            String actionCommand = item10.getActionCommand();
            lists.add(actionCommand);
        }
        if (item11.isSelected()) {
            String actionCommand = item11.getActionCommand();
            lists.add(actionCommand);
        }
        if (item12.isSelected()) {
            String actionCommand = item12.getActionCommand();
            lists.add(actionCommand);
        }
        if (item13.isSelected()) {
            String actionCommand = item13.getActionCommand();
            lists.add(actionCommand);
        }
        if (item14.isSelected()) {
            String actionCommand = item14.getActionCommand();
            lists.add(actionCommand);
        }
        if (item15.isSelected()) {
            String actionCommand = item15.getActionCommand();
            lists.add(actionCommand);
        }
        if (item16.isSelected()) {
            String actionCommand = item16.getActionCommand();
            lists.add(actionCommand);
        }
        if (item17.isSelected()) {
            String actionCommand = item17.getActionCommand();
            lists.add(actionCommand);
        }
        if (item18.isSelected()) {
            String actionCommand = item18.getActionCommand();
            lists.add(actionCommand);
        }
        if (item19.isSelected()) {
            String actionCommand = item19.getActionCommand();
            lists.add(actionCommand);
        }
        return lists;
    }

}

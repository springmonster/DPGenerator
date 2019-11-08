package com.khch.androidscreen.ui;

import com.khch.androidscreen.utils.DimensUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class BottomGenerateLayout extends JPanel {
    private MainFrame mainFrame;
    private JButton btnSure = new JButton("生成");

    BottomGenerateLayout(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        btnSure.addActionListener(new GenerateAction());
        this.add(btnSure);
    }

    private class GenerateAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // 是否选择基准分辨率
            if (mainFrame.getStandardPixelStr() == null || mainFrame.getStandardPixelStr().length() == 0) {
                JOptionPane.showMessageDialog(null, "基准分辨率不能为空！");
                return;
            }

            // 是否选择目标分辨率
            if (mainFrame.getPixelStrList() == null || mainFrame.getPixelStrList().size() == 0) {
                JOptionPane.showMessageDialog(null, "生成的分辨率列表不能为空！");
                return;
            }

            // 判断文件是否存在
            File resFile = new File("./res");
            if (resFile.exists()) {
                JOptionPane.showMessageDialog(null, "请删除res文件夹之后重试！");
                return;
            }

            // 屏蔽掉程序执行入口
            btnSure.setText("正在生成中");
            btnSure.setEnabled(false);

            resFile.mkdir();
            System.out.println("创建成功");

            // 根文件创建成功，则创建其他文件夹
            File file;

            for (String dirName : mainFrame.getPixelStrList()) {
                System.out.println("dirName   ==== " + dirName);
                file = new File("./res/values-" + dirName);

                if (!file.exists()) {
                    file.mkdir();
                    // 计算缩放比例
                    String desValue = dirName;

                    Pattern p = Pattern.compile("\\d+");
                    Matcher m = p.matcher(desValue);

                    String numValueOne = "";
                    String numValueTwo = "";

                    if (m.find()) {
                        numValueOne = m.group(0);
                        if (m.find()) {
                            numValueTwo = m.group(0);
                        }
                    }

                    System.out.println("numValueOne   ===  " + numValueOne);
                    System.out.println("numValueTwo   ===  " + numValueTwo);
                    // 获取最小值
                    int num;
                    int intNumOne = Integer.parseInt(numValueOne);
                    int intNumTwo = Integer.parseInt(numValueTwo);
                    System.out.println("------------------numValueTwo  === "
                            + numValueTwo);
                    if (intNumOne > intNumTwo) {
                        num = intNumTwo;
                    } else {
                        num = intNumOne;
                    }
                    // 获取原始效果尺寸
                    int intSrcSize = Integer.parseInt(mainFrame.getStandardPixelStr());
                    float scale = (float) ((num * 1.0) / intSrcSize);
                    float scale1 = (float) ((num * 1.0) / (intSrcSize / 2));
                    File dimensFile = new File(file.getAbsoluteFile()
                            + "/dimens.xml");

                    try {
                        DimensUtils.outContent(
                                dimensFile, scale, scale1);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        System.out.println("生成文件错误，请稍后重试");
                        return;
                    }


                }
            }

            // 生成完毕，恢复按钮状态
            btnSure.setText("生成");
            btnSure.setEnabled(true);
        }
    }
}

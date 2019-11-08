package com.dqqdo.androidscreen.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BottomLayout extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 2566994302921751173L;

    private DuFrame frame;
    private JButton btnSure;

    BottomLayout(DuFrame frame) {

        this.frame = frame;
        btnSure = new JButton("生成");
        this.add(btnSure);
        // 设置事件监听
        btnSure.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSure) {

            String result = frame.getSrcSize();

            // 屏蔽掉程序执行入口
            btnSure.setText("正在生成中");
            btnSure.setEnabled(false);

            // 判断文件是否存在
            File resFile = new File("./res");
            if (resFile.exists()) {
                System.out.println("当前目录存在同名文件夹，请处理");
//				System.out.println("当前目录存在同名文件夹，请处理");
                JOptionPane.showMessageDialog(null, "当前目录存在同名文件夹，请处理");
            } else {
                resFile.mkdir();
                System.out.println("创建成功");
            }

            // 获取相关参数
            LinkedList<String> lists = frame.getTargetValues();

            // 设置以480*800为计算标准
            // 根文件创建成功，则创建其他文件夹
            File file;

            Iterator<String> iterator = lists.iterator();
            while (iterator.hasNext()) {
                String dirName = iterator.next();
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
                    int intSrcSize = Integer.parseInt(frame.getSrcSize());
                    float scale = (float) ((num * 1.0) / intSrcSize);
                    float scale1 = (float) ((num * 1.0) / (intSrcSize / 2));
                    File dimensFile = new File(file.getAbsoluteFile()
                            + "/dimens.xml");

                    try {
                        com.dqqdo.androidscreen.utils.DimensUtils.outContent(
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

            // ayi ni zhediao ..ni erzi zhidoama ...gezhong heimayun
            // jiaoyuju bawei zhigao
            // yueru wuqian,chi sha
            // hongtou .... doumeiquguo
            // gezhongchuibeij ..huibeij
            // xianggang he zhongguo
            // list
            // ayi ,ni biehei wo dalinfen.(kongqi)
            // huayangxuanfu.....
            // putonghua ...linfentuhua qifei.

            // shiye...haizi jiaoyu .........badu==== baidu

            // beij maifangzi ..... linfen maifangzi .....

            // linfen daqujingli...huayang xuanfu

            // weixin jiqianhaoyou ......maidongxi kuangjia haoduoqian
            // chuanxiao dianshanghua

            // input
            // chinese chenyang changbaishan

            // renmen zongsi ba bieren dangzuo shaazi ...danshi shijishang
            // bieren dou bushi shazi

            // yidabo chuanxiao laixi ....

            // yuechui yueniu ....yueru jigeyi..liangbian lia chengongrenshi ..

        }

    }

}

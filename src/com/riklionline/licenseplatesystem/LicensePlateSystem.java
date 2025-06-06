package com.riklionline.licenseplatesystem;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName: LicensePlateSystem
 * @Descirption:
 *            业务描述
 *            1 项目名称：车牌摇号器
 *            2 用户故事描述：使用随机不重复算法，实现一个车牌摇号器，本期参与摇号人员共1000（编号1-1000）人，从中抽取10人，获得购买车牌资格
 *            3 设计思路：
 *              3.1 创建一个10个元素的数组，用来存放10个人的编号；
 *              3.2 编号从1-1000随机产生，需要算法；

 * @Version: v1.01
 * @Author: RikLi
 * @DateTime: 5/8/24 21:55:25
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public class LicensePlateSystem {

    public static void main(String[] args) {

        int[] userNumber = new int[10]; //10个用户号码
        int[] systemNumber = new int[1000]; //1000个系统号码

        for (int i = 0; i < systemNumber.length; i++) {
            systemNumber[i] = i + 1; //1000次循环填满[1,2,3,4,……,1000]
        }

        randomSelection(userNumber,systemNumber);//从系统号码中随机10个不重复的数据给到用户数组
        System.out.println("本期中奖号码为:" + Arrays.toString(userNumber));

    }

    public static void randomSelection(int[] a,int[] b){
        Random r = new Random();
        int index = -1; //索引

        for (int i = 0; i < a.length; i++) {
            index = r.nextInt(b.length - i);
            a[i] = b[index];

            int temp = b[index];
            b[index] = b[b.length - 1 -i];
            b[b.length - 1 -i] = temp;

        }
    }
}

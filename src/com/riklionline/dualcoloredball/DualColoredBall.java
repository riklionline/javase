package src.com.riklionline.dualcoloredball;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName: DualColoredBall
 * @Descirption:
 *      双色球业务规则：
 *      1.红色球号码区由1-33共三十三个号码组成，蓝色球号码区由1-16共十六个号码组成；
 *      2.投注时用户选择6个红色球号码和1个蓝色球号码组成一注进行投注，可以选择机选和手选；
 *      3.中奖号码在每期开展活动前已经确定；
 *      4.比对用户购买红球和蓝球与中奖号码的匹配数量即可，没有顺序要求；
 *      业务代码设计思路：
 *      1.准备变量，红球存放区数组int[6]，蓝球存放区int;
 *      2.用户选择机选或者手选；
 *      3.接收用户号码（6红1蓝）;
 *      4.系统生成中奖号码（6红1蓝）;
 *      5.比较系统号码和用户号码，记录个数，验证是否中奖；
 *      6.系统号码排序；
 *      7.中奖号码与用户所选号码同时公示；
 * @Version: v1.01
 * @Author: RikLi
 * @DateTime: 5/6/24 13:14
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public class DualColoredBall {

    //Main Method
    public static void main(String[] args) {

        int[] redBallUser = new int[6];//用户选择的红球
        int blueBallUser = 0;//用户选择的蓝球

        int[] redBallSys = new int[6];//系统生成的红球
        int blueBallSys = 0;//系统生成的蓝球

        int redBallCount = 0;//红球中奖个数
        int blueBallCount = 0;//蓝球中奖个数

        /*生成1-33存放于数组中（有序）*/
        int[] redBallBox = new int[33];
        for (int i = 0; i < redBallBox.length; i++) {
            redBallBox[i] = i + 1;
            //System.out.println("RedBallBox" +"[" + i + "]" + ": " + redBallBox[i])
        }

        Random r = new Random();
        MyUtils myUtils = new MyUtils();
        myUtils.autoRandomSelection(redBallBox,redBallSys);//系统生成中奖号码（红球）
        blueBallSys = r.nextInt(16)+1;//系统生成中奖号码（蓝球）

        System.out.println("双色球游戏开始，祝君好运！");
        System.out.println("请选择，1：机选，2：手选");

        Scanner input = new Scanner(System.in);

        boolean flag = true;

        while (flag) {
            try {
                int isAuto = input.nextInt();//线程阻塞，在循环中判断选号方式
                switch (isAuto){
                    case 1:
                        myUtils.autoRandomSelection(redBallBox, redBallUser);//机选从红球box中选出6个不重复的数存入用户红球数组
                        blueBallUser = r.nextInt(16)+1;//该值介于[0,n)的区间，包括0但是不包括n
                        flag = false;//机选全部选完，中断循环
                        break;
                    case 2:
                        for (int i = 0; i < redBallUser.length; i++) {
                            System.out.println("选择红球：请从1到33中任意选择6个号码连续输入，每输入一次按回车确认；");
                            redBallUser[i] = input.nextInt();
                        }
                        System.out.println("选择蓝球：请从1到16中任意选择1个号码输入，按回车确认；");
                        blueBallUser = input.nextInt();
                        flag = false;//手选全部选完，中断循环
                        break;
                    default:
                        System.out.println("请重新选择，1：机选，2：手选");
                        break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        //比较系统红球与用户红球，相同则count++
        for (int i = 0; i < redBallUser.length; i++) {
            for (int j = 0; j < redBallSys.length-redBallCount; j++) {
                if(redBallUser[i] == redBallSys[j]){
                    int temp = redBallSys[j];
                    redBallSys[j] = redBallSys[redBallSys.length-1-redBallCount];
                    redBallSys[redBallSys.length-1-redBallCount] = temp;
                    redBallCount++;
                    break;
                }
            }
        }
        //比较系统蓝球与用户蓝球，相同则计数“1”
        if (blueBallUser == blueBallSys){
            blueBallCount = 1;
        }

        //判断中奖结果
        myUtils.prizeInspect(blueBallCount,redBallCount);

        //公布系统生成中奖号码
        System.out.println("本期蓝球中奖号码是：" + blueBallSys);
        myUtils.sort(redBallSys);
        System.out.println("本期红球中奖号码是：" + Arrays.toString(redBallSys));

        //公布用户选择的号码
        System.out.println("您选择的蓝球号码是：" + blueBallUser);
        myUtils.sort(redBallUser);
        System.out.println("您选择的红球号码是：" + Arrays.toString(redBallUser));
    }
}

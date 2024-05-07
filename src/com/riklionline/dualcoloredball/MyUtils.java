package src.com.riklionline.dualcoloredball;

import java.util.Random;

/**
 * @ClassName: MyUtils
 * @Descirption:
 * @Version: v1.01
 * @Author: RikLi
 * @DateTime: 5/6/24 16:42
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public class MyUtils {

    //在指定的数组中随机生成不重复的数，从数组“a”中不重复的取出元素依次放入数组“b”中
    public void autoRandomSelection(int[] a, int[] b) {

        Random r = new Random();
        int index = -1;

        for (int i = 0; i < b.length; i++) {
            index = r.nextInt(a.length - i);//数组a的取数索引值每次范围变小一个，避免随机时取出最后一个的可能，最后一个肯定是重复的
            b[i] = a[index];

            int temp = a[index];
            a[index] = a[a.length - 1 - i];
            a[a.length - 1 -i] = temp;
        }

    }

    //中奖结果审查与判断，a-蓝球，b-红球
    public void prizeInspect(int a, int b){

        if(a==0 && b<=3){
            System.out.println("革命尚未成功，同志仍需努力！");
        } else if (a==1 && b<3) {
            System.out.println("中了六等奖，奖励5元！");
        } else if (a+b==4) {
            System.out.println("中了五等奖，奖励10元！");
        } else if (a+b==5) {
            System.out.println("中了四等奖，奖励200元！");
        } else if (a==1 && b==5) {
            System.out.println("中了三等奖，奖励10000元！");
        } else if (a==0 && b==6) {
            System.out.println("中了二等奖，奖励100万元！");
        } else if (a==1 && b==6) {
            System.out.println("中了一等奖，奖励500万元！");
        }else {
            System.out.println("系统错误！");
        }
    }

    //冒泡排序法
    public void sort(int[] ball){
        for(int i=0;i<ball.length-1;i++){
            for(int j=0;j<ball.length-1-i;j++){
                if(ball[j]>ball[j+1]){
                    ball[j] = ball[j]+ball[j+1];
                    ball[j+1] = ball[j]-ball[j+1];
                    ball[j] = ball[j]-ball[j+1];
                }
            }
        }
    }

}

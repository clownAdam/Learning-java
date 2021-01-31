package cn.clown;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author clown
 */
public class JumpFloor {
    /**
     * 通过数学归纳法发现：当n=1时,sum=1;当n=2时,sum=2;当n=3时,sum=3;当n=4时,sum=5;因此是斐波那契数列
     *
     * @param target 阶数
     * @return 结果
     */
    public int jumpFloor2(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            int sum0 = 1;
            int sum1 = 2;
            int result = 0;
            for (int i = 3; i <= target; i++) {
                result = sum0 + sum1;
                sum0 = sum1;
                sum1 = result;
            }
            return result;
        }
    }

    public static void main(String[] args) {

        System.out.println(new JumpFloor().jumpFloor2(5));
    }
}
import java.util.Scanner;

public class CF278C {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int hpy = sc.nextInt();
        int atky = sc.nextInt();
        int defy = sc.nextInt();
        int hpm = sc.nextInt();
        int atkm = sc.nextInt();
        int defm = sc.nextInt();
        int hp_cost = sc.nextInt();
        int atk_cost = sc.nextInt();
        int def_cost = sc.nextInt();

        long min = Long.MAX_VALUE;
        for (long atk_buy = 0; atk_buy <= 200; atk_buy++) {
            for (long def_buy = 0; def_buy <= 100; def_buy++) {
                long diff_atk_y = Math.max(0, (atky + atk_buy) - defm);
                long diff_atk_m = Math.max(0, atkm - (defy + def_buy));
                if (diff_atk_y == 0) {
                    continue;
                }

                if (diff_atk_m == 0) {
                    long curr = atk_buy * atk_cost + def_buy * def_cost;
                    if (curr < min) {
                        min = curr;
                    }
                } else {
                    long t_y = hpy / diff_atk_m + (hpy % diff_atk_m > 0 ? 1 : 0);
                    long t_m = hpm / diff_atk_y + (hpm % diff_atk_y > 0 ? 1 : 0);
                    if (t_y > t_m) {
                        long curr = atk_buy * atk_cost + def_buy * def_cost;
                        if (curr < min) {
                            min = curr;
                        }
                    } else {
                        long t_diff = t_m - t_y;
                        long rest = hpy % diff_atk_m;
                        long missing_hp_y = (rest == 0 ? 1 : (diff_atk_m + 1 - rest));
                        if (t_diff > 0) {
                            missing_hp_y += diff_atk_m * t_diff;
                        }

                        long curr = atk_buy * atk_cost + def_buy * def_cost + missing_hp_y * hp_cost;
                        if (curr < min) {
                            min = curr;
                        }
                    }
                }
            }
        }

        System.out.println(min);
    }
}

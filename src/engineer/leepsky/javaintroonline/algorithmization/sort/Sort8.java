package engineer.leepsky.javaintroonline.algorithmization.sort;

public class Sort8 {

    /* Даны дроби p1/q1 , p2/q2 , ..., pn/qn ( pi , qi - натуральные). Составить программу, которая приводит эти дроби к общему
       знаменателю и упорядочивает их в порядке возрастания. */ 
       
    public static void toCommonDenominator(int[] nums, int[] dens) {

        int denominator = 1;

        for (int i = 0; i < dens.length; i++) {

            denominator *= dens[i];

        }

        for (int i = 0; i < dens.length; i++) {

            nums[i] = (denominator / dens[i]) * nums[i];
            dens[i] = denominator;

        }

    }

    public static void main(String[] args) {

        int[] nums = {4, 1, 7, 5, 12};
        int[] dens = {5, 2, 3, 2, 17};

        toCommonDenominator(nums, dens);

        Sort6.sortShell(nums);

        Sort1.printArray(nums);
        Sort1.printArray(dens);

    }

}

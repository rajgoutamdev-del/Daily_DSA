import java.util.*;


    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1}; // No solution found
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking array input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Taking target input
        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        // Calling two sum function
        int[] result = twoSum(nums, target);

        // Printing result
        if (result[0] != -1) {
            System.out.println("Indices are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No valid pair found");
        }

        sc.close();
    }

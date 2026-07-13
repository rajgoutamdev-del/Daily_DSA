const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function twoSum(nums, target) {
    let map = new Map();

    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];

        if (map.has(complement)) {
            return [map.get(complement), i];
        }

        map.set(nums[i], i);
    }

    return [-1, -1];
}

rl.question("Enter array elements separated by space: ", function(inputArray) {

    let nums = inputArray.split(" ").map(Number);

    rl.question("Enter target value: ", function(inputTarget) {

        let target = Number(inputTarget);

        let result = twoSum(nums, target);

        if (result[0] !== -1) {
            console.log(
                "Indices are: " + result[0] + " and " + result[1]
            );
        } else {
            console.log("No valid pair found");
        }

        rl.close();
    });
});
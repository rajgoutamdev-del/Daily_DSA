function combinationSum(arr: number[], t: number): number[][] {
    let ans : number[][] = [];
    let ls : number[] = [];
    func(0,arr, t, ans,ls);
    return ans;
};

function func(ind: number, arr : number[] , target : number, ans : number[][],ls : number[]) {
    if(ind === arr.length) return;
    if(target === 0) {
        ans.push([...ls]);
        return;
    }
    if(arr[ind] <= target) {
        ls.push(arr[ind]);
        func(ind,arr,target - arr[ind],ans,ls);
        ls.pop();
    }
    func(ind+1,arr,target,ans,ls)
}
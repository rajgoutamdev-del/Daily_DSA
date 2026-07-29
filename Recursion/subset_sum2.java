class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        Arrays.sort(nums);
        func(0,nums,new ArrayList<Integer>(),st);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> ls : st) ans.add(ls);
        return ans;
    }
    void func(int ind,int[] arr,List<Integer> ls,Set<List<Integer>> st) {
        if(ind == arr.length) {
            st.add(new ArrayList<>(ls));
            return;
        }

        ls.add(arr[ind]);
        func(ind+1,arr,ls,st);
        ls.remove(ls.size()-1);
        func(ind+1,arr,ls,st);
    }
}
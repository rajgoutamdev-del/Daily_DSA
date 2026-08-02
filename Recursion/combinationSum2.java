class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int t) {
        Arrays.sort(arr);
        Set<List<Integer>> st = new HashSet<>();
        func(0,arr,t,new ArrayList<Integer>(),st);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> ls : st) {
            ans.add(ls);
        }
        return ans;
    }
    public void func(int ind,int[] arr,int t,List<Integer> ls,Set<List<Integer>> st) {
        if(t == 0) {
            st.add(new ArrayList<>(ls));
            return;
        }
        
        for(int i = ind ; i < arr.length ; i++) {
            if(i > ind && arr[i-1] == arr[i]) continue;

            if(arr[i] > t) break;

            ls.add(arr[i]);
            func(i+1,arr,t-arr[i],ls,st);
            ls.remove(ls.size()-1);
        }
    }
}
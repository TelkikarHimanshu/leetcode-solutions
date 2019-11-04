class LeetCode_1086_HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            if (map.get(items[i][0]) == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(items[i][1]);
                map.put(items[i][0], list);
            } else {
                ArrayList<Integer> list = map.get(items[i][0]);
                list.add(items[i][1]);
                map.put(items[i][0], list);
            }
        }
        
        
        for (Integer i : map.keySet()) {
            ArrayList<Integer> list = map.get(i);
            Collections.sort(list, Collections.reverseOrder());
        }
        
        items = new int[map.keySet().size()][2];
        int count = 0, sum = 0;
        for (Integer i : map.keySet()) {
            ArrayList<Integer> list= map.get(i);
            for (int j = 0; j < 5; j++) {
                sum += list.get(j);
            }
            
            sum = sum / 5;
            items[count][0] = Integer.valueOf(i);
            items[count][1] = sum;
            sum = 0;
            count = count + 1;
        }
        
        return items;
    }
}
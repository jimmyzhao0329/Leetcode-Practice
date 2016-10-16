public class print_binary_tree_in_vertical_order{
	public void getVerticalOrder(TreeNode root, 
			int horizontal_distance, 
			Map<Integer, List<Integer>> map){

		if(root == null){
			return;
		}

		if(map.containsKey(horizontal_distance)){
			map.get(horizontal_distance).add(root.val);
		}
		else{
			List<Integer> list = new ArrayList<Integer>();
			list.add(root.val);
			map.put(horizontal_distance, list);
		}

		getVerticalOrder(root.left, horizontal_distance - 1, map);
		getVerticalOrder(root.right, horizontal_distance + 1, map);
	}

	public List<List<Integer>> printVerticalOrder(TreeNode root){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null){
			return res;
		}

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		getVerticalOrder(root, 0, map);

		Set<Integer> keySet = map.keySet();
		Integer[] arr = keySet.toArray(new Integer[keySet.size()]);
		Arrays.sort(arr);
		for(Integer i : arr){
			res.add(new ArrayList<Integer>(map.get(i)));
		}
		
		return res;
	}
}
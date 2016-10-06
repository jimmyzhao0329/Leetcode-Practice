// https://leetcode.com/problems/word-break-ii/

public class Solution {
    public static List<String> wordBreak(String s, Set<String> dict) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        if (s == null || s.length() == 0 || dict == null) {
            return null;
        }

        return dfs(s, dict, map);
    }

    public static List<String> dfs(String s, Set<String> dict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> list = new ArrayList<String>();
        int len = s.length();

        if (len == 0) {
            list.add("");
        } 
        for (int i = 1; i <= len; i++) {
            String sub = s.substring(0, i);

            if (!dict.contains(sub)) {
                continue;
            }

            List<String> sublist = dfs(s.substring(i), dict, map);

            for (String r: sublist) {
                list.add(sub + (r.isEmpty() ? "" : " ") + r);
            }
        }

        map.put(s, list);
        return list;
    }
}
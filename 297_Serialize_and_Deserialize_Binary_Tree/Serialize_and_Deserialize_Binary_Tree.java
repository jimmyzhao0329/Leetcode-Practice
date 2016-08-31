// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

// My solution
public class Codec {

    // Encodes a tree to a single string.
    // Using level-order traversal 
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(sb.length() != 0){
                sb.append(",");
            }
            if(node != null){
                sb.append(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
            else{
                sb.append("null");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int i = 1;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            String s = vals[i++];
            if(!s.equals("null")){
                node.left = new TreeNode(Integer.parseInt(s));
                q.offer(node.left);
            }
            s = vals[i++];
            if(!s.equals("null")){
                node.right = new TreeNode(Integer.parseInt(s));
                q.offer(node.right);
            }
        }
        return root;
    }
}

// Highest voted solution
public class Codec {
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
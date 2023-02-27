class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return list;
        }

        list.add(List.of(root.val));
        traverse(root, 1);

        for (int i = 0; i < list.size(); i += 1) {
            if (list.get(i).size() == 0) {
                list.remove(i);
            }
        }

        return list;
    }

    public void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (list.size() <= level) {
            list.add(new ArrayList<>());
        }

        List<Integer> levelList = list.get(level);

        if (root.left != null) {
            levelList.add(root.left.val);
        }

        if (root.right != null) {
            levelList.add(root.right.val);
        }

        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }
}

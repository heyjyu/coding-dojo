class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        traverse(root);

        return list;
    }

    public void traverse(Node node) {
        if (node == null) {
            return;
        }

        list.add(node.val);

        for (Node children : node.children) {
            traverse(children);
        }
    }
}

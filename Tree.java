package geekbrains.HomeTask_6;

import java.util.ArrayList;

public class Tree {
    public Tree(ArrayList<Integer> list) {
        for (Integer integer : list) {
            this.insert(integer);
        }
    }
    // travers
    // delete

    private class TreeNode implements Comparable {
        private int load;
        Cat c;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.load = value;
        }

        @Override
        public String toString() {
            return "(" + load + ")";
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    TreeNode root;

    public void insert(int number) {
        TreeNode node = new TreeNode(number);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (number <= current.load) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }

    public Cat find(int age) {
        TreeNode current = root;
        while (current.c.getAge() != age) {
            current = (age < current.c.getAge()) ? current.left : current.right;
            if (current == null) return null;
        }
        return current.c;
    }

    private void preOrderTraverse(TreeNode current) {
        if (current != null) {
            System.out.print(current.c.getAge() + " ");
            preOrderTraverse(current.left);
            preOrderTraverse(current.right);
        }
    }

    public void displayTree() {
        preOrderTraverse(root);
    }

    public boolean delete(int age) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (current.c.getAge() != age) {
            parent = current;
            if (age < current.c.getAge()) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }

        // leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // one ancestor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // two ancestors
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parent = node;
        TreeNode s = node;
        TreeNode curr = node.right;
        while (curr != null) {
            parent = s;
            s = curr;
            curr = curr.left;
        }

        if (s != node.right) {
            parent.left = s.right;
            s.right = node.right;
        }
        return s;
    }

    private int countLevels(TreeNode node) {
        if (node == null) return 0;
        int left = 0;
        int right = 0;
        if (node.left != null)
            left = countLevels(node.left);
        if (node.right != null)
            right = countLevels(node.right);
        return 1 + (Math.max(left, right));
    }

    int isBalanced() {
        int leftLevel = countLevels(root.left);
        int rightLevel = countLevels(root.right);
        if (leftLevel == rightLevel) return 1;
        else return 0;
    }
}
// 23 22 89 25 10 18 39 53 75 27 9 16 87 33 17 23 17

// 9 (4 (2 (1, 3), 8 (6 (5, 7), N)), 13 (11 (10, 12), 15 (14, 16)))




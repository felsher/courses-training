package siaod.lab1;

import java.util.LinkedList;
import java.util.Queue;

class MyBinarySearchTree {

    TreeNode root;

    void add(int value) {
        if (this.root == null) {
            this.root = new TreeNode(value);
        } else {
            this.addTo(this.root, value);
        }
    }

    private void addTo(TreeNode node, int value) {
        if (value < node.value) {
            TreeNode leftChild = node.left;
            if (leftChild == null) {
                TreeNode newNode = new TreeNode(value);
                node.left = newNode;
            } else {
                this.addTo(leftChild, value);
            }
        } else {
            TreeNode rightChild = node.right;
            if (rightChild == null) {
                TreeNode newNode = new TreeNode(value);
                node.right = newNode;
            } else {
                this.addTo(rightChild, value);
            }
        }
    }

    int findMaxOnExactLvl(int lvl) {
        int currentLevel = 0;
        int result = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        if (this.root == null) {
            return 0;
        }

        queue.offer(this.root);

        while (!queue.isEmpty() && currentLevel != lvl + 1) {

            float numberOfElementsOnLevel = queue.size();

            for (int i = 0; i < numberOfElementsOnLevel; i++) {

                TreeNode node = queue.poll();

                if (currentLevel == lvl) {
                    if (result < node.value) {
                        result = node.value;
                    }
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            currentLevel++;
        }

        return result;
    }

    void print(TreeNode node, int prefix) {
        if (node == null)
            return;

        // Increase distance between levels
        prefix += 5;

        print(node.right, prefix);

        System.out.print("\n");
        for (int i = 5; i < prefix; i++)
            System.out.print(" ");
        System.out.print(node.value + "\n");

        // Process left child
        print(node.left, prefix);
    }

    void fill(Integer... intArray) {
        for (Integer i : intArray) {
            this.add(i);
        }
    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}

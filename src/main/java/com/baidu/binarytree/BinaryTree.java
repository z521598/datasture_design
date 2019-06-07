package com.baidu.binarytree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree<T> {
    private Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    /**
     * 先根遍历
     */
    public List<T> nlr() {
        List<T> res = new ArrayList<>();
        nlr(root, res);
        return res;
    }

    private void nlr(Node<T> current, List<T> result) {
        if (current == null) {
            return;
        }
        result.add(current.data);
        nlr(current.left, result);
        nlr(current.right, result);
    }

    /**
     * 先根遍历（非递归）
     */
    public List<T> nlrWithoutRecursion() {
        List<T> res = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();

        Node<T> node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                res.add(node.data);
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }

        }

        return res;
    }

    /**
     * 中根遍历
     */
    public List<T> lnr() {
        List<T> res = new ArrayList<>();
        lnr(root, res);
        return res;
    }

    private void lnr(Node<T> current, List<T> result) {
        if (current == null) {
            return;
        }
        lnr(current.left, result);
        result.add(current.data);
        lnr(current.right, result);
    }

    /**
     * 中根遍历（非递归）
     */
    public List<T> lnrWithoutRecursion() {
        List<T> res = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();
        Node<T> node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            while (!stack.isEmpty()) {
                node = stack.pop();
                res.add(node.data);
                if (node.right != null) {
                    node = node.right;
                    break;
                } else {
                    node = null;
                }
            }

        }
        return res;
    }

    /**
     * 后根遍历
     */
    public List<T> lrn() {
        List<T> res = new ArrayList<>();
        lrn(root, res);
        return res;
    }

    private void lrn(Node<T> current, List<T> result) {
        if (current == null) {
            return;
        }
        lrn(current.left, result);
        lrn(current.right, result);
        result.add(current.data);
    }

    /**
     * 后根遍历（非递归）
     */
    public List<T> lrnWithoutRecursion() {
        List<T> res = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        Node<T> lastNode = null;
        while (!stack.isEmpty()) {
            while (stack.peek().left != null) {
                stack.push(stack.peek().left);
            }
            while (!stack.isEmpty()) {
                if (lastNode == stack.peek().right || stack.peek().right == null) {
                    Node<T> node = stack.pop();
                    res.add(node.data);
                    lastNode = node;
                } else if (stack.peek().right != null) {
                    stack.push(stack.peek().right);
                    break;
                }
            }
        }
        return res;
    }
}

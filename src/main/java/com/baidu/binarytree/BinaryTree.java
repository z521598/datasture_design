package com.baidu.binarytree;


import java.util.ArrayList;
import java.util.List;

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
}

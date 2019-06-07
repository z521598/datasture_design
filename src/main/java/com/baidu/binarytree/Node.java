package com.baidu.binarytree;

public class Node<T> {
    public T data;
    public Node left;
    public Node right;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

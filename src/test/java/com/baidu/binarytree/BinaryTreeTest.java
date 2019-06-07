package com.baidu.binarytree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    private Node<Integer> getRoot() {
        /*
                   1
               2       3
            4    5        6

         */
        Node<Integer> leaf1ForRootLeft = new Node<>(4, null, null);
        Node<Integer> leaf2ForRootLeft = new Node<>(5, null, null);
        Node<Integer> leaf1ForRootRight = new Node<>(6, null, null);
        Node<Integer> rootLeft = new Node<>(2, leaf1ForRootLeft, leaf2ForRootLeft);
        Node<Integer> rootRight = new Node<>(3, null, leaf1ForRootRight);
        Node<Integer> root = new Node<>(1, rootLeft, rootRight);
        return root;
    }

    @Test
    public void testNlr() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(getRoot());
        assertEquals("[1,2,4,5,3,6]", binaryTree.nlr().toString().replaceAll(" ", ""));
    }

    @Test
    public void testLnr() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(getRoot());
        assertEquals("[4,2,5,1,3,6]", binaryTree.lnr().toString().replaceAll(" ", ""));
    }

    @Test
    public void testLrn() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(getRoot());
        assertEquals("[4,5,2,6,3,1]", binaryTree.lrn().toString().replaceAll(" ", ""));
    }
}
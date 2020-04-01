package com.redJoker.datastructure.Tree;

public class AslNode {
    /**
     * 节点数据
     */
    int data;

    /**
     * 层高
     */
    int height;

    /**
     * 左子节点的引用
     */
    AslNode leftChild;

    /**
     * 右子节点的引用
     */
    AslNode rightChild;

    public AslNode(int data) {
        initNode(data, null, null, 1);
    }

    public AslNode(int data, AslNode leftChild, AslNode rightChild) {
        initNode(data, leftChild, rightChild, null);
    }

    private void initNode(int t, AslNode left, AslNode right, Integer height) {
        this.setData(t);
        this.leftChild = left;
        this.rightChild = right;
        this.height = height;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AslNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AslNode leftChild) {
        this.leftChild = leftChild;
    }

    public AslNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(AslNode rightChild) {
        this.rightChild = rightChild;
    }
}

package com.redJoker.datastructure.LinearTable;


public class DoubleList<E> {
    private Node head = new Node(null, null);

    /**
     * add链表节点
     *
     * @param data
     * @return
     */
    public void add(E data) {
    }

    /**
     * 删除节点
     *
     * @param data
     * @return
     */
    public boolean delete(E data) {
        return true;
    }

    /**
     * 返回某一个节点下的数据
     *
     * @param index
     * @return
     */
    public E findNode(int index) {
        return null;
    }

    /**
     * 打印链表
     *
     * @return
     */
    @Override
    public String toString() {
        return "";
    }


}

class DoubleNode<E> {
    E data;
    DoubleNode next;
    DoubleNode prev;

    public DoubleNode(E data, DoubleNode next, DoubleNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public DoubleNode() {
    }
}
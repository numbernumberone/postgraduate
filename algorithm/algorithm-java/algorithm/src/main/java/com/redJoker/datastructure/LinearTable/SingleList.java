package com.redJoker.datastructure.LinearTable;


public class SingleList<E> {
    private Node head = new Node(null,null);

    /**
     * add链表节点
     * @param data
     * @return
     */
    public void add(E data) {
        Node<E> node = new Node<E>();
        node.data = data;
        node.next = null;
        if(null == head) {
            head = node;
        } else {
            // 此时需要遍历到尾节点,从head节点开始
            Node<E> temp = head;
            while (null != temp.next) {
                temp = temp.next;
            }
            // 找到尾节点,新增节点即可
            temp.next = node;
        }
    }

    /**
     * 删除节点
     * @param data
     * @return
     */
    public boolean delete(E data) {
        if(data == head.data) {
            // 要删除的节点是 头节点
            head = head.next;
            return true;
        } else {
            // 不是head节点 需要遍历节点
            Node<E> temp = head;
            while(null != temp.next) {
                if(data == temp.next.data) {
                    // 匹配需要删除的节点的下一个节点
                    temp.next = temp.next.next;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    /**
     * 返回某一个节点下的数据
     * @param index
     * @return
     */
    public Node<E> findNode(int index) {
        if(index < 0) return null;
        Node<E> temp = head;
        for(int i = 0; i < index; i++) {
            if(temp == null) {
                // 空链表
                return null;
            }
            temp = temp.next;
        }
        // 返回节点数据
        if(null != temp) {
            return temp;
        }
        return null;
    }

    /**
     * 打印链表
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(head == null) {
            return sb.append("暂无数据").toString();
        } else {
            Node<E> temp = head;
            while(null != temp.next) {
                sb.append(temp.next.data + " ");
                temp = temp.next;
            }
        }
        return sb.toString();
    }

    /**
     * 单链表的环检测
     * @param link
     * @return
     */
    public boolean judgeRing(SingleList<E> link) {
        // 快指针
        Node<E> quick = link.head;
        // 慢指针
        Node<E> slow = link.head;
        while(null != quick && null != quick.next) {
            // 单步遍历
            slow = slow.next;
            // 双步遍历
            quick = quick.next.next;
            if(quick == slow) {
                // 链表有打结
                return true;
            }
        }
        return false;
    }

    /**
     * 单链表的翻转
     */
    public void reverse() {
        if(null == head && null == head.next) {
            System.out.println("只有一个节点, 没有必要翻转...");
            return;

        }
        // 准备工作
        Node<E> node = head;
        Node<E> nextNode = null;
        Node<E> preNode = null;

        nextNode = node.next;
        node = preNode;
        while (null != nextNode) {
            preNode = nextNode.next;
            nextNode.next = node;
            node = nextNode;
            nextNode = preNode;
        }
        head.next = node;
    }

    public SingleList<E> merge(SingleList<E> one,SingleList<E>two) {
        // 新建一个链表,存储最终结果
        SingleList<E> result = new SingleList<E>();

        // 链表的头节点
        Node<E> first = one.head.next;
        Node<E> second = two.head.next;

        /**
         * 只要是两个节点不是null, 那就需要去比较合并.
         * 如果first节点小雨second节点,需要将first节点保存到result中去,反之保存second节点
         */
        while (first != null && second != null) {
            if(((Comparable<E>)first.data).compareTo((E)second.data) < 0) {
                result.add(first.data);
                first = first.next;
            } else {
                result.add(second.data);
                second = second.next;
            }
        }

        // 此时是第一条链没有遍历完 第二条遍历完 将第一条链全部保存到result
        if(first != null) {
            while(first != null) {
                result.add(first.data);
                first = first.next;
            }
        }

        // 此时是第二条链没有遍历完 第一条遍历完 将第二条链全部保存到result
        if(second != null) {
            while(second != null) {
                result.add(second.data);
                second = second.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SingleList list = new SingleList();
        list.add(1);
        list.add("asd");
        list.add(3.1415);
        list.add(true);
        System.out.println(list.toString());
        System.out.println("-------------");
        list.reverse();
        System.out.println(list.toString());
        System.out.println("------------");
        System.out.println(list.findNode(4).data);
        System.out.println("--------------");
        list.delete(1);
        System.out.println(list.toString());
        System.out.println("-----测试链表的是否有环--------");
        System.out.println("链表" + (list.judgeRing(list) ? "打结了" : "没有打结"));
        System.out.println("-------------");
        Node node = list.findNode(3);
        node.next = list.head;
        System.out.println("链表" + (list.judgeRing(list) ? "打结了" : "没有打结"));
        System.out.println("------测试链表的合并-----");

        SingleList first = new SingleList();
        first.add(1);
        first.add(3);
        first.add(5);
        SingleList second = new SingleList();
        second.add(0);
        second.add(2);
        second.add(9);
        SingleList merge = list.merge(first, second);
        System.out.println(merge.toString());
    }
}

class Node<E>{
    E data;
    Node next;
    public Node(E data, Node next) {
        this.data = data;
        this.next = next;
    }
    public Node(){}
}
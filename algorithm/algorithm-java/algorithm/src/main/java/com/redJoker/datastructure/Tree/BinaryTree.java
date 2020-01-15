package com.redJoker.datastructure.Tree;

public class BinaryTree implements Tree {
    /**
     * 根节点
     */
    private Node root;

    /**
     * 查找节点
     * 1.查找值比当前节点值大，则搜索右子树；
     * 2.查找值等于当前节点值，停止搜索（终止条件）；
     * 3.查找值小于当前节点值，则搜索左子树；
     *
     * @param key
     * @return
     */
    @Override
    public Node find(int key) {
        Node current = root;
        while (null != current) {
            if (current.data < key) {
                // key 大于 当前节点
                current = current.rightChild;
            } else if (current.data > key) {
                // key 小于 当前节点
                current = current.leftChild;
            } else {
                return current;
            }
        }
        // 没有查询到结果
        return null;
    }

    /**
     * 插入节点
     * 待插入的节点从根节点开始进行比较，小于根节点则与根节点左子树比较，反之则与右子树比较，直到左子树为空或右子树为空，则插入到相应为空的位置。
     * ps: 在比较的过程中要注意保存父节点的信息 及 待插入的位置是父节点的左子树还是右子树，才能插入到正确的位置。
     *
     * @param data
     * @return
     */
    @Override
    public boolean insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            // 是一棵空树 在根节点存放数据即可
            root = node;
            return true;
        } else {
            // 从根节点开始比较
            Node currentNode = root;
            // 父节点信息
            Node parentNode = null;
            while (currentNode != null) {
                // 每一次循环开始, 先将父节点信息保存下来
                parentNode = currentNode;
                if (currentNode.data > data) {
                    // 要插入的值 小于 根节点 继续在左子树里查询
                    currentNode = currentNode.leftChild;
                    if (currentNode == null) {
                        parentNode.leftChild = node;
                        return true;
                    }
                } else {
                    // 要插入的值 大于 根节点 继续在右子树里查询
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        parentNode.rightChild = node;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 中序遍历 左 -> 根 -> 右
     *
     * @param current
     */
    @Override
    public void infixOrder(Node current) {
        if (current != null) {
            infixOrder(current.leftChild);
            System.out.print(current.data + " ");
            infixOrder(current.rightChild);
        }
    }

    /**
     * 前序遍历 根 -> 左 -> 右
     *
     * @param current
     */
    @Override
    public void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }
    }

    /**
     * 后序遍历 左 -> 右 -> 根
     *
     * @param current
     */
    @Override
    public void postOrder(Node current) {
        if (current != null) {
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.print(current.data + " ");
        }
    }

    /**
     * 找到最大值
     * 一直找根节点的右节点，直到没有右节点，则就是最大值
     *
     * @return
     */
    @Override
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    /**
     * 找到最小值
     * 先找根的左节点，然后一直找这个左节点的左节点，直到找到没有左节点的节点，那么这个节点就是最小值
     *
     * @return
     */
    @Override
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    /**
     * 删除节点 有如下一些步骤:
     * 1. 定位要删除的数据. ps: 定位规则有一个需要注意的地方: 需要知道要删除的节点是在父节点的左节点还是右节点。这里用isleftChild标识
     * 2. 分析定位到要删除的节点
     *  2.1 删除的节点没有子节点
     *      isleftChild -> true 将父节点的左子树置空
     *                   -> false 将父节点的右子树置空
     *  2.2 删除的节点有左子节点
     *      特殊情况: 删除的节点是root节点, 让删除节点的左子节点当root节点
     *      isleftChild -> true
     *          父节点的左子节点 指向 删除节点的左节点
     *      isLeftChild -> false
     *          父节点的右子节点 指向 删除节点的左节点
     *  2.3 删除的节点有右子节点
     *      特殊情况: 删除节点是root节点, 删除节点的右节点当root节点
     *      isleftChild -> true
     *          父节点的左子节点 指向 删除节点的右节点
     *      isleftChild -> false
     *          父节点右边节点 指向 删除节点的右节点
     *  2.4 删除的节点有两个子节点
     *      2.4.1 后继节点是删除节点的右节点
     *          2.4.1.1 寻找后继节点
     *          2.4.1.2 要删除节点的父节点的子节点指向后继节点
     *              isleftChild -> true
     *                父节点的左子节点 指向 后继节点
     *             isleftChild -> false
     *                父节点右边节点 指向 后继节点
     *          2.4.1.3 删除节点的左节点信息 作为 后继节点左子节点
     *      2.4.2 后继节点是删除节点的右节点上后的左节点
     *          2.4.2.1 寻找后继节点
     *              将后续节点右边节点 指向 其父节点的左子节点
     *              后继节点的右子节点 指向 要删除节点的右节点
     *          2.4.2.2
     *          2.4.2.2
     *          ... 同上
     * @param key
     * @return
     */
    @Override
    public boolean delete(int key) {
        if(root == null) {
            return false;
        }
        Node current = root;
        Node parent = null;
        boolean isLeftChild = false;
        while (current.data != key) {
            parent = current;
            if (current.data > key) {
                // 当前节点大于要删除的数据, 走树左边
                current = current.leftChild;
                isLeftChild = true;
            } else {
                // 当前节点小于要删除的数据, 走树右边
                current = current.rightChild;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }
        if(current.leftChild == null && current.rightChild == null) {
            // 情况1: 删除节点没有左右子节点
            if(current == root) {
                root = null;
            } else if(isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if(current.leftChild != null && current.rightChild == null) {
            // 情况2: 删除节点有左节点
            if(current == root) {
                root = current.leftChild;
            } else if(isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if(current.leftChild == null && current.rightChild != null) {
            // 情况3: 删除节点有右节点
            if(current == root) {
                root = current.rightChild;
            } else if(isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            // 情况4: 删除节点有左右节点

            // 后继节点
            Node successor = getSuccessor(current);
            if(current == root) {
                successor = root;
            } else if(isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    /**
     * 寻找删除节点的后继节点
     * @param delNode
     * @return
     */
    public Node getSuccessor(Node delNode) {
        // 要返回的节点
        Node successor = delNode;
        // 返回节点的父节点
        Node successorParent = delNode;
        // 遍历的节点 最先拿到删除节点的右子节点
        Node current = delNode.rightChild;
        while(current != null) {
            // 一直去寻找后续节点(删除节点的右子节点的左子节点)
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        // 后继节点不是删除节点的右子节点，将后继节点替换删除节点
        if(successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(87);
        bt.insert(100);
        //bt.delete(10);// 删除没有子节点的节点
        //bt.delete(30);// 删除有一个子节点的节点
        bt.delete(80);
        // 删除有两个子节点的节点
        System.out.println(bt);
    }
}

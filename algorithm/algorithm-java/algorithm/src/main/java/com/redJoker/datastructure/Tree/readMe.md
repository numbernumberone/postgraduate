## 树
### 基本概念
    1. 度: 拥有子节点个数,称为度. 度为0属于叶子节点, 大于0是分支节点
    2. 节点上的子树是该节点的孩子, 相反, 称之为双亲。同一个双亲的节点是兄弟节点。
    3. 深度: 数中节点最大层次叫深度。
    
### 二叉排序树
    定义: 左子树不为空, 左子树上所有节点小于根节点, 右子树不为空, 右子树所有节点大于根节点.
    二叉排序树的时间复杂度是n(lg n).
### 平衡二叉树
    定义: 首先是一个二叉排序树, 任何一个子节点左子树与右子树都是平衡二叉树,并且高度差不能
    超过1。
    
    平衡因子: 左子树深度减去右子树深度的值称之为平衡因子。平衡因子只会有以下几个值0,1,-1。
    分别对应着左右子树相等, 左子树高, 右子树高。
    
    最小失衡树: 新插入的叶子节点向上查找第一个平衡因子绝对值超过1的节点为根的子树, 称之为
    最小失衡树。
    
    
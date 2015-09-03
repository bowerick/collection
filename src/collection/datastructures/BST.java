package collection.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BST {

    private BSTNode root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public BST clear() {
        root = null;
        size = 0;
        return this;
    }

    public BST add(int data) {
        root = add(root, data);
        return this;
    }

    public boolean isSameTree(BST first, BST second) {
        return isSameTree(first.root, second.root);
    }

    private boolean isSameTree(BSTNode first, BSTNode second) {
        if (first == null && second == null) {
            return true;
        }
        else if (first != null && second != null) {
            return (first.data == second.data) && isSameTree(first.left, second.left) && isSameTree(first.right, second.right);
        }
        else {
            return false;
        }

    }
    
    public BST makeBad()
    {
        root.left.left.right.data=1000;
        return this;
    }
    
    public boolean isBSTFast()
    {
        return isBSTFast(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isBSTFast(BSTNode node,int min,int max)
    {
        if(node == null) return true;
        
        boolean leftOK = isBSTFast(node.left, findMin(node.left), node.data);
        if(!leftOK)
            return false;
        boolean rightOK = isBSTFast(node.right,node.data+1,findMax(node.right));
        return rightOK;
        
        
    }
    
    public boolean isBST()
    {
        return isBST(root);
    }
    
    private boolean isBST(BSTNode node)
    {
        if(node == null) return true;
        
        if(node.left != null && ((node.data < node.left.data) || findMax(node.left) > node.data))
            return false;
        if(node.right != null && ((node.data > node.right.data) || findMin(node.right) < node.data))
            return false;
        return isBST(node.left) && isBST(node.right);
    }
    
    public int countTrees(int keys) {
       if(keys <= 1)
           return 1;
       
       int left=0;
       int right=0;
       int sum = 0;
       for(int root=1 ; root <= keys ; root++)
       {
           left=countTrees(root-1);
           right=countTrees(keys-root);
           sum+= left*right;
       }
       return sum;
    }

    public BST doubleTree() {
        doubleTree(root);
        return this;
    }

    public void doubleTree(BSTNode node) {
        if (node == null) {
            return;
        }
        BSTNode dupNode = new BSTNode(node.data);
        BSTNode oldLeft = node.left;
        node.left = dupNode;
        dupNode.left = oldLeft;
        doubleTree(dupNode.left);
        doubleTree(node.right);
    }

    public BST mirror() {
        mirror(root);
        return this;
    }

    public void mirror(BSTNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        else {
            BSTNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            mirror(node.left);
            mirror(node.right);
        }
    }

    private void trace(int data) {
        List<String> path = new ArrayList<String>();
        trace(data, path);
        System.out.println(Arrays.toString(path.toArray()));
    }

    private void trace(int data, List<String> path) {
        trace(data, root, path);
    }

    private void trace(int data, BSTNode node, List<String> path) {
        if (node == null) {
            return;
        }
        if (node.data == data) {
            path.add(String.valueOf(node.data));
        }
        if (data < node.data) {
            path.add(String.valueOf(node.data));
            trace(data, node.left, path);
        }
        if (data > node.data) {
            path.add(String.valueOf(node.data));
            trace(data, node.right, path);
        }

    }

    public void printPaths() {
        List<String> paths = new ArrayList<String>();
        printPaths(root, paths);
        System.out.println(Arrays.toString(paths.toArray()));
        for (String path : paths) {
            trace(Integer.valueOf(path));
        }
    }

    public void printPaths(BSTNode node, List<String> paths) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            paths.add(String.valueOf(node.data));
        }
        printPaths(node.left, paths);
        printPaths(node.right, paths);
    }

    public boolean hasPathSum(int sum) {
        return hasPathSum(root, sum);
    }

    public boolean hasPathSum(BSTNode node, int sum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null && sum == node.data) {
            return true;
        }
        return hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data);
    }

    public int depth() {
        return depth(root);
    }

    public int getSize() {
        return getSize(root);
    }

    private int depth(BSTNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

    private int getSize(BSTNode node) {
        if (node != null) {
            return 1 + getSize(node.left) + getSize(node.right);
        }
        return 0;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public boolean find(int data) {
        return find(root, data);
    }

    public BSTNode get(int data) {
        return get(root, data);
    }

    public int findMax() {
        return findMax(root);
    }

    public int findMin() {
        return findMin(root);
    }

    public BST delete(int data) {
        root = delete(root, data);
        return this;
    }

    public BSTNode delete(BSTNode node, int data) {
        if (node != null) {
            if (data < node.data) {
                node.left = delete(node.left, data);
            }
            if (data > node.data) {
                node.right = delete(node.right, data);
            }
            if (data == node.data) {
                if (node.left == null) {
                    return node.right;
                }
                else if (node.right == null) {
                    return node.right;
                }
                else {
                    node.data = findMax(node.left);
                    node.left = delete(node.left, node.data);
                }
            }
            return node;
        }
        else {
            return null;
        }
    }

    private int findMin(BSTNode node) {
        if (node.left == null) {
            return node.data;
        }
        return findMin(node.left);
    }

    private int findMax(BSTNode node) {
        if (node.right == null) {
            return node.data;
        }
        return findMax(node.right);
    }

    private BSTNode get(BSTNode node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            return get(node.left, data);
        }
        if (data > node.data) {
            return get(node.right, data);
        }
        if (data == node.data) {
            return node;
        }
        return null;
    }

    private boolean find(BSTNode node, int data) {
        if (node == null) {
            return false;
        }
        if (data < node.data) {
            return find(node.left, data);
        }
        if (data > node.data) {
            return find(node.left, data);
        }
        if (data == node.data) {
            return true;
        }
        return false;
    }

    private BSTNode add(BSTNode node, int data) {
        if (node == null) {
            node = new BSTNode(data);
        }
        else {
            if (data < node.data) {
                node.left = add(node.left, data);
            }
            else {
                node.right = add(node.right, data);
            }
        }
        size++;
        return node;
    }

    private void inOrderTraversal(BSTNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }

    public int size() {
        return size;
    }
}

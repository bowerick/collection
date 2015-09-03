package collection.datastructures;

public class BSTDriver {

    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(50).add(40).add(110).add(30).add(45).add(99).add(115).add(111).add(119).add(1).add(35).add(41).add(49).add(32).inOrderTraversal();
        System.out.println("==");
        System.out.println(bst.find(41));
        System.out.println("==");
        System.out.println(bst.findMax());
        System.out.println("==");
        System.out.println(bst.findMin());
        System.out.println("==");
        bst.delete(50).inOrderTraversal();
        System.out.println("==");
        System.out.println(bst.getSize());
        System.out.println("==");
        System.out.println(bst.depth());
        System.out.println("==");
        System.out.println(bst.hasPathSum(253));
        System.out.println("==");
        bst.printPaths();
        System.out.println("==");
        bst.mirror().inOrderTraversal();
        System.out.println("==");
        bst.doubleTree().inOrderTraversal();
        System.out.println("==");
        bst.clear();
        bst.add(2).add(3).add(1).add(4);
        
        BST bst2 = new BST();
        bst2.add(3).add(2).add(1).add(4);
        
        System.out.println(bst.isSameTree(bst, bst2));
        
        System.out.println(bst.countTrees(4));
        bst = new BST();
        bst.add(50).add(40).add(110).add(30).add(45).add(99).add(115).add(111).add(119).add(1).add(35).add(41).add(49).add(32).inOrderTraversal();

        System.out.println(bst.isBST());
        //bst=bst.makeBad();
        System.out.println(bst.isBST());
        
        System.out.println(bst.isBSTFast());
    }
}

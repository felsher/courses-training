package siaod.lab1;

public class Lab1 {

    public static void main(String[] args) {

        MyBinarySearchTree tree = new MyBinarySearchTree();

        // let's fill the tree
        tree.fill(9,8,12,4,7,10,15,1,5,23,16);

        tree.print(tree.root, 0);

        int lvl = 3;
        int maxOnExactLvl = tree.findMaxOnExactLvl(lvl);

        System.out.println("- - - - - - - - - - - - - - - -");
        System.out.println("Here is your max integer: " + maxOnExactLvl + " On lvl: " + lvl);
    }

}

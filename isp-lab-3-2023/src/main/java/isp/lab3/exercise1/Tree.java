package isp.lab3.exercise1;

public class Tree {
    private int height;

    public Tree() {
        this.height = 15;
    }

    public void grow(int meters) {
        if (meters >= 1) {
            this.height += meters;
        }
    }

    public String toString() {
        return String.format("This tree is %d meters tall.", this.height);
    }

    public static void main(String[] args) {
        Tree myTree = new Tree();
        System.out.println(myTree.toString());

        myTree.grow(5);
        System.out.println("The tree has grown! " + myTree.toString());

        Tree anotherTree = new Tree();
        System.out.println(anotherTree.toString());
    }
}

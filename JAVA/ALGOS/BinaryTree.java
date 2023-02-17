// BinaryTree.java

class BinaryNode {
    public BinaryNode leftNode;
    public BinaryNode rightNode;
    private int value;

    public BinaryNode(int value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public int getValue() { return this.value; }
}


class BinaryTree {

    private BinaryNode topNode = null;

    public BinaryTree() {
    }

    public BinaryTree addNode(int value) {
        BinaryNode newBN = new BinaryNode(value);

        if (topNode == null)
            topNode = newBN;

        else {

            BinaryNode parNode = topNode;
            BinaryNode leafNode = topNode;

            while (leafNode != null) {

                parNode = leafNode;

                if (value < leafNode.getValue())
                    leafNode = leafNode.leftNode;
                else
                    leafNode = leafNode.rightNode;
            }

            if (value < parNode.getValue())
                parNode.leftNode = newBN;
            else
                parNode.rightNode = newBN;
        }

        return this;
    }

    //

    public void depthFirst() {

        if (topNode == null)
            return;

        BinaryNode curBN = topNode;

        System.out.format("%d \n", curBN.getValue());

        if (curBN.leftNode != null)
            depthFirst(curBN.leftNode);

        if (curBN.rightNode != null)
            depthFirst(curBN.rightNode);
    }

    public void depthFirst(BinaryNode curBN) {
        if (curBN == null)
            return;
        else {
            System.out.format("%d \n", curBN.getValue());
            depthFirst(curBN.leftNode);
            depthFirst(curBN.rightNode);
        }
    }


    public ArrayList<Integer> getOrderedList() { }

    ////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.addNode(18);
        bt.addNode(20);
        bt.addNode(17);

        bt.depthFirst();

    }
}

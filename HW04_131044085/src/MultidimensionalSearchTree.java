public class MultidimensionalSearchTree extends BinaryTree  implements SearchTree <MultidimensionalItems> {
    /**
     * MultidimensionalItems root
     */
    private Node<MultidimensionalItems> root;

    /**
     * Constructor
     */
    public  MultidimensionalSearchTree(){super();}
    /**
     * Constructor
     */
    public  MultidimensionalSearchTree(MultidimensionalItems dim){

        super();
        this.root=new Node<MultidimensionalItems>(dim);


    }
    /** Inserts item where it belongs in the tree.
     @param item The item to be inserted
     @return true If the item is inserted, false if the
     item was already in the tree.
     */


    @Override
    public boolean add(MultidimensionalItems item)
    {

        return true;
    }

    /** Determine if an item is in the tree
     @param target Item being sought in tree
     @return true If the item is in the tree, false otherwise
     */
    @Override
    public boolean contains(MultidimensionalItems target)
    {
        return true;
    }

    /** Find an object in the tree
     @param target The item being sought
     @return A reference to the object in the tree that compares
     equal as determined by compareTo to the target. If not found
     null is returned.
     */
    @Override
    public MultidimensionalItems find(MultidimensionalItems target)
    {
        return  null;
    }

    /** Removes target from tree.
     @param target Item to be removed
     @return A reference to the object in the tree that compares
     equal as determined by compareTo to the target. If not found
     null is returned.
     @post target is not in the tree
     */
    @Override
    public MultidimensionalItems delete(MultidimensionalItems target){
        return null;
    }

    /** Removes target from tree.
     @param target Item to be removed
     @return true if the object was in the tree, false otherwise
     @post target is not in the tree
     */
    @Override
    public  boolean remove(MultidimensionalItems target)
    {
        return true;
    }

    /** Perform a preOrderTraverse traversal.
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse(StringBuilder sb) {
        helperPreOrder(root,sb);
    }

    /**
     * Helper Funtion for PreOrderTraverse
     * @param node To be searched
     * @param sb The string buffer to save the output
     */
    public void helperPreOrder(Node <MultidimensionalItems> node, StringBuilder sb){
        if (node != null) {
            sb.append("  ");
            sb.append(node.toString());

            helperPreOrder(node.right,sb);
            helperPreOrder(node.left,sb);
        }
    }
    /**
     * To String Method using PreOrderTraverse
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(sb);
        return sb.toString();
    }


}

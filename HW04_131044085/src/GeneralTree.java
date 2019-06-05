import sun.text.normalizer.RangeValueIterator;

public class GeneralTree< E> extends BinaryTree  {
    /**
     * checks for postorder
     */
    private int check=0;
    private Node<E> temp=null;

    /**
     * Constructor
     */
    public GeneralTree(){ super(); }
    /**
     * Constructor
     * assign the given data to root
     * @param data To be Assigned
     */
    public GeneralTree(E data){

        super();
        Node<E> node=new Node<>(data);
        root=node;
    }
    /**
     * Constructor
     * assigns the given node to root
     * @param root To be Assigned
     */
    protected GeneralTree(Node < E > root) {
        super(root);
    }
    /**
     * Method which takes parent and child and inserts the child
     * as the last child of the parent
     * @param parent To be Searched
     * @param child To be Added
     * @return
     */
    public boolean add(E parent, E child){
        if(LevelOrderSearch(this.root,parent)) {
            if (!LevelOrderSearch(root,child)) {
                if(postOrderSearch(root,parent).left==null) {
                    Node<E> tree=new Node<>(child);
                    postOrderSearch(root,parent).left=tree;
                    return  true;
                }
                else{
                    addSiblings(postOrderSearch(root,parent).left,child);
                    return true;
                }
            }
            else
                System.out.println("This child "+child+" is already in tree");
        }
        else {
            System.out.println("There is no such "+parent+" parent");
        }

        return false;
    }
    /**
     * Add siblings
     * @param parent To be Searched
     * @param child To be Added
     */
    public void addSiblings(Node<E> parent, E child)
    {
        if(parent.right==null){
            parent.right=new Node<>(child);
            return;
        }
        else
            addSiblings(parent.right,child);
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
    /**
     *
     * @param node To be Searched
     * @param element To be Searched
     * @return
     */
    protected Node<E> postOrderSearch(Node < E > node, E element) {
        helperPostOrder(root,element);
        if(check==0)
            return null;
        check=0;
        return temp;
    }

    /** Perform a postOrderSearch .
     @param node The local root
     @param element To be Searched
     */
    protected void helperPostOrder(Node < E > node,
                                    E element) {

        if (root == null) {
            return;
        }
        if(element.equals(node.data)){
            //System.out.println("Parent " +node.data);
            temp=node;
            check=-1;
            return;
        }
        if (node.left!=null)
            helperPostOrder(node.left,element);

        if (node.right!=null)
            helperPostOrder(node.right,element);

    }

    /** Perform a levelOrder .
     @param node The local root
     @param element The string buffer to save the output
     */
    protected boolean LevelOrderSearch(Node < E > node,E element) {

        if (node == null) {
            return false;
        }
        else {
            if (node.data.equals(element)) {
                return true;
            }
            if (searchInChild(node.left,element)) {
                return true;
            }
            else
                return LevelOrderSearch(node.left, element);
        }
    }

    /**
     * Invert child subtree to String
     * @param node To be Searched
     * @param element To be Searched
     */
    private boolean searchInChild(Node<E> node,E element)
    {
        if(node==null){
            return false;}
        if(node.data.equals(element)) {
            return true;
        }
        else {
            return searchInChild(node.right,element);
        }

    }


    /** Perform a preOrder traversal.
     * @param sb The string buffer to save the output
     */
    protected void preOrderTraverse(StringBuilder sb) {
        helperPreOrder(root,sb);
    }

    /**
     * Helper Funtion for PreOrderTraverse
     * @param node To be Searched
     * @param sb The string buffer to save the output
     */
    public void helperPreOrder(Node < E > node, StringBuilder sb){
        if (node != null) {
            sb.append("  ");
            sb.append(node.toString());

            helperPreOrder(node.right,sb);
            helperPreOrder(node.left,sb);
        }
    }



}

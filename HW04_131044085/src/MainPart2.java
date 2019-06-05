public class MainPart2 {

    public static void main(String argv[]) {

        MultidimensionalItems dim=new MultidimensionalItems(1,2,3);
        MultidimensionalSearchTree tree=new MultidimensionalSearchTree(dim);
        System.out.println(tree.toString());
    }
}

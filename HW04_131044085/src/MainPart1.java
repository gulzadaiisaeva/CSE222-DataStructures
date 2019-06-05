public class MainPart1 {

    public static void main(String argv[])
    {
        System.out.println("Creating the tree with root 1");
        GeneralTree<Integer> general=new GeneralTree<>(1);
        System.out.println(general.toString());

        System.out.println("Adding parent=1, child=2");
        general.add(1,2);
        System.out.println(general.toString());

        System.out.println("Adding parent=2, child=3");
        general.add(2,3);
        System.out.println(general.toString());

        System.out.println("Adding parent=1, child=4");
        general.add(1,4);
        System.out.println(general.toString());

        System.out.println("Adding parent=1, child=7");
        general.add(1,7);
        System.out.println(general.toString());

        System.out.println("Adding parent=2, child=6");
        general.add(2,6);
        System.out.println(general.toString());

        System.out.println("Adding parent=3, child=5");
        general.add(3,5);
        System.out.println(general.toString());

        System.out.println("Adding parent=5, child=8");
        general.add(5,8);
        System.out.println(general.toString());

        System.out.println("Adding parent=3, child=9");
        general.add(3,9);
        System.out.println(general.toString());

        System.out.println("Adding parent=9, child=12");
        general.add(9,12);
        System.out.println(general.toString());











    }
}

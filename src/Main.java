import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Collection");
        ArrayList<Integer> collection = new ArrayList<>();
        for (int i = 10; i >= 1; i--) {
            collection.add(i);
        }

        System.out.println(collection);
        MyArrayList.bubbleSortForAnotherListTypes(collection);
        System.out.println(collection);

        // ------------------------------ //
        System.out.println("\nlist");

        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(1);
        System.out.println(list);
        list.add(0, 2);
        System.out.println(list);
        list.set(0, 5);
        System.out.println(list);
        System.out.println(list.get(1));
        list.addAll(collection);
        System.out.println(list);

        // ------------------------------ //
        System.out.println("\nlist1");

        MyArrayList<String> list1 = new MyArrayList<>(2);
        list1.add("dog");
        list1.add(0, "cat");
        System.out.println(list1);
        list1.add(1, "owl");
        System.out.println(list1);
        list1.remove(0);
        list1.remove("dog");
        System.out.println(list1);

        // ------------------------------ //
        System.out.println("\nlist2");

        MyArrayList<Integer> list2 = new MyArrayList<>(collection);
        System.out.println(list2);
        list2.addAll(1, collection);
        System.out.println(list2);
        list2.bubbleSortForMyArrayList();
        System.out.println(list2);
        System.out.println(list2.size());
    }
}

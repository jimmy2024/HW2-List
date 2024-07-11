public class Main {
    public static void main(String[] args) {
        MyList<Integer> lst = new MyList<>();

        for (int i = 15; i >= 0; i--) {
            lst.add(i);
        }
        System.out.println(lst);

        lst.removeAt(15);
        System.out.println(lst);

        lst.removeAt(0);
        System.out.println(lst);

        lst.remove(14);
        System.out.println(lst);

        lst.remove(1);
        System.out.println(lst);

        lst.sort();
        System.out.println(lst);

    }
}
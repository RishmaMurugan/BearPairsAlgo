import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main (String[] args) {
        ArrayList<Integer> ages = new ArrayList<Integer>(Arrays.asList(18, 19, 20));
        ArrayList<Character> test_matchGenders1 = new ArrayList<Character>(Arrays.asList('f'));
        ArrayList<Character> test_matchGenders2 = new ArrayList<Character>(Arrays.asList('m'));
        User Ariana = new User("Ariana", 'f', test_matchGenders2, 18, ages, 'a', 'a', 'a', 'a', 'a');
        User Alex = new User("Alex", 'm', test_matchGenders1, 18, ages, 'b', 'b', 'b', 'b', 'b');
        User Betty = new User("Betty", 'f', test_matchGenders2, 18, ages, 'c', 'c', 'c', 'c', 'c');
        User Ben = new User("Ben", 'm', test_matchGenders1, 18, ages, 'd', 'd', 'd', 'd', 'd');
        User Cassie = new User("Cassie", 'f', test_matchGenders2, 18, ages, 'e', 'e', 'e', 'e', 'e');
        User Charlie = new User("Charlie", 'm', test_matchGenders1, 18, ages, 'f', 'f', 'f', 'f', 'f');

        ArrayList<User> pool = new ArrayList<User>();
        pool.add(Ariana);
        pool.add(Alex);
        pool.add(Betty);
        pool.add(Ben);
        pool.add(Cassie);
        pool.add(Charlie);

        Comp.comparePool(pool);

        Pool.poolMatch(pool);
    }
}

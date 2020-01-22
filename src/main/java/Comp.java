import java.util.*;

public class Comp {

    public static void comparePool (ArrayList<User> pool) {
        for (User user : pool) {
            for (User otherUser: pool) {
                if (! user.equals(otherUser)) {
                    compareTwoProfiles(user, otherUser);
                }
            }
        }
    }
    public static int  compareTwoProfiles (User a, User b) {
        int comp = 0;
        //Check that gender is a match for both users
        if (!a.matchGender.contains(b.gender) || !b.matchGender.contains(a.gender)) {
            //Returns an arbitrarily large number to ensure that they are not matched
            return 2^80;
        }
        //Check that ages are within preference range
        if (!a.matchAge.contains(b.age) || !b.matchAge.contains(b.age)) {
            //Returns an arbitrarily large number to ensure that they are not matched
            return 2^80;
        }

        //Check ideal date, music, food, movie
        comp += Math.abs((int)a.idealDate - (int) b.idealDate);
        comp += Math.abs((int)a.music - (int) b.music);
        comp += Math.abs((int)a.food - (int) b.food);
        comp += Math.abs((int)a.movie - (int) b.movie);
        a.preferences.put(b, comp);
        return comp;
    }
}

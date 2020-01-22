import java.util.*;


public class Pool {
    public static ArrayList<Match> matches = new ArrayList<Match>();

    public static class Match {
        User a;
        User b;

        public Match(User first, User second) {
            a = first;
            b = second;
        }
    }

    public static boolean checkMatchExists(User first, User second) {
        for (Match match : matches) {
            if ((match.a.equals(first) && match.b.equals(second))
                    || (match.a.equals(second) && match.b.equals(first))) {
                return true;
            }
        }
        return false;
    }

    public static void poolMatch(ArrayList<User> poolList) {
        for (User user : poolList) {
            user.calculatePoolScore();
            user.sortPreferences();
        }

        //Create hashmap that links user to poolscore
        HashMap<User, Integer> poolScores = new HashMap<User, Integer>();
        for (User user : poolList) {
            poolScores.put(user, user.poolScore);
        }

        //Sort poolScores
        Map<User, Integer> sortedPoolScores = sortByValues(poolScores);

        //Iterate through sortedPoolScores
        for (User user : sortedPoolScores.keySet()) {
            //Iterate through sortedPreference list
            for (User prefUser : user.sortedPreferences) {
                if ((double) (user.sortedPreferences.indexOf(prefUser) + 1) / user.sortedPreferences.size() >=
                        (double) (prefUser.sortedPreferences.indexOf(user) + 1) / prefUser.sortedPreferences.size() || prefUser.sortedPreferences.size() == 1) {
                    if (!checkMatchExists(user, prefUser)) {
                        matches.add(new Match(user, prefUser));
                        System.out.println(user.name + " " + prefUser.name);
                    }
                    break;
                }
            }
        }
    }

    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
import javax.print.DocFlavor;
import java.util.*;

public class User {
    public String name;
    public char gender;
    public ArrayList<Character> matchGender;
    public int age;
    public ArrayList<Integer> matchAge;
    public char idealDate;
    public char food;
    public char movie;
    public char music;
    public char genre;
    public HashMap<User, Integer> preferences = new HashMap<User, Integer>();
    public ArrayList<User> sortedPreferences = new ArrayList<User>();
    public int poolScore;

    public User(String name, char gender, ArrayList<Character> matchGender, int age, ArrayList<Integer> matchAge, char idealDate, char food, char movie, char genre, char music) {
        this.name = name;
        this.gender = gender;
        this.matchGender = matchGender;
        this.age = age;
        this.matchAge = matchAge;
        this.idealDate = idealDate;
        this.food = food;
        this.movie = movie;
        this.music = music;
        this.genre = genre;
    }

    public void calculatePoolScore() {
        for (User other : preferences.keySet()) {
            poolScore += preferences.get(other);
        }
    }

    public void sortPreferences() {
        LinkedHashMap<User, Integer> tempPreference = sortByValues(preferences);
        for (User u : tempPreference.keySet()) {
            this.sortedPreferences.add(u);
        }
    }
    private static LinkedHashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        LinkedHashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

}


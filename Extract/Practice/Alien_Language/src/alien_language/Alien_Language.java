package alien_language;

import java.util.*;
import java.util.Scanner;

public class Alien_Language {

    public static class Vertex<T> {

        private final T mItem;
        private Set<Vertex<T>> mNeighbours = new HashSet<>();

        public Vertex(T item) {
            mItem = item;
        }

        public boolean addEdgeTo(Vertex<T> other) {
            return mNeighbours.add(other);
        }

        public T getItem() {
            return mItem;
        }

        public Set<Vertex<T>> getNeighbours() {
            return mNeighbours;
        }

        @Override
        public String toString() {
            return "Vertex{item=" + mItem + ", neighbours=" + mNeighbours + "}";
        }

        @Override
        public int hashCode() {
            return mItem.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj instanceof Vertex) {
                Vertex other = (Vertex) obj;
                return mItem.equals(other.mItem);
            }
            return false;
        }
    }

    public interface Listener {

        void onOrderedPair(char u, char v);
    }

    public static class Scanne {

        public void scan(List<String> words, Listener cb) {
            if (words.size() > 1) {
                for (int i = 1; i < words.size(); ++i) {
                    String first = words.get(i - 1);
                    String second = words.get(i);
                    int minLength = Math.min(first.length(), second.length());
                    for (int j = 0; j < minLength; ++j) {
                        if (first.charAt(j) != second.charAt(j)) {
                            cb.onOrderedPair(first.charAt(j), second.charAt(j));
                            break;
                        }
                    }
                }
            }
        }
    }

    public static class Ordering implements Listener {

        private final Map<Character, Vertex<Character>> mVertices = new HashMap<>();

        private Ordering() {
        }

        public static Ordering seedWords(List<String> words) {
            Ordering o = new Ordering();
            Scanne scanner = new Scanne();
            scanner.scan(words, o);

            return o;
        }

        public List<Character> findTopologicalOrder() {
            Set<Vertex<Character>> unmarked = new HashSet<>(mVertices.values());
            Set<Vertex<Character>> visiting = new HashSet<>();
            Set<Vertex<Character>> visited = new HashSet<>();

            List<Character> ordered = new LinkedList<>();
            while (!unmarked.isEmpty()) {
                Vertex<Character> v = unmarked.iterator().next();
                visit(v, unmarked, visiting, visited, ordered);
            }

            Collections.reverse(ordered);
            return ordered;
        }

        private static void visit(Vertex<Character> v,
                Set<Vertex<Character>> unmarked, Set<Vertex<Character>> visiting, Set<Vertex<Character>> visited,
                List<Character> ordered) {

            if (visiting.contains(v)) {
                throw new RuntimeException("Cyclic graph. No ordering possible.");
            }

            if (unmarked.remove(v)) {
                visiting.add(v);
                for (Vertex<Character> n : v.getNeighbours()) {
                    visit(n, unmarked, visiting, visited, ordered);
                }
                visiting.remove(v);
                visited.add(v);
                ordered.add(v.getItem());
            }
        }

        @Override
        public void onOrderedPair(char u, char v) {
            mVertices.computeIfAbsent(u, Vertex::new).addEdgeTo(mVertices.computeIfAbsent(v, Vertex::new));
        }
    }

    public static void main(String[] args) {

        int t, n, k;

        int a = 0;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int[] output = new int[t];

        while (a < t) {
            n = sc.nextInt();
            k = sc.nextInt();
            String dic[] = new String[n];
            String inp;

            for (int i = 0; i < n; i++) {
                inp = sc.next();
                if (inp.length() <= 1000) {
                    dic[i] = inp;
                }
            }
            Ordering partialOrdering = Ordering.seedWords(Arrays.asList(dic));
            //System.out.println(partialOrdering.findTopologicalOrder());
            output[a] = 1;

            a++;

        }
        for (int i = 0; i < t; i++) {
            System.out.println(output[i]);
        }
    }
}

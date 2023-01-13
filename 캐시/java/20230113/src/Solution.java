import java.util.*;

class Solution {
    public void test() {
        System.out.println("cacheHit(List.of(\"jeju\"),\"Jeju\"): true = " + cacheHit(List.of("jeju"),"Jeju"));

        System.out.println("nextCacheArray(3,List.of(),\"Jeju\"): [\"jeju\"] = " + nextCacheArray(3,List.of(),"Jeju"));
        System.out.println("nextCacheArray(1,List.of(\"jeju\"),\"Jeju\"): [\"jeju\"] = " + nextCacheArray(1,List.of("jeju"),"Jeju"));
        System.out.println("nextCacheArray(1,List.of(\"jeju\"),\"pangyo\"): [\"pangyo\"] = " + nextCacheArray(1,List.of("jeju"),"pangyo"));
        System.out.println("nextCacheArray(3,List.of(\"jeju\",\"pangyo\",\"seoul\"),\"NewYork\"): [\"pangyo\",\"seoul\",\"newyork\"] = " + nextCacheArray(3,List.of("jeju","pangyo","seoul"),"NewYork"));

        System.out.println("totalRuntime(3,new String[]{\"Jeju\", \"Pangyo\", \"Seoul\", \"NewYork\", \"LA\", \"Jeju\", \"Pangyo\", \"Seoul\", \"NewYork\", \"LA\"}: 50 = " + totalRuntime(3,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println("totalRuntime(3,new String[]{\"Jeju\", \"Pangyo\", \"Seoul\", \"Jeju\", \"Pangyo\", \"Seoul\", \"Jeju\", \"Pangyo\", \"Seoul\"}: 21 = " + totalRuntime(3,new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println("totalRuntime(2,new String[]{\"Jeju\", \"Pangyo\", \"Seoul\", \"NewYork\", \"LA\", \"SanFrancisco\", \"Seoul\", \"Rome\", \"Paris\", \"Jeju\", \"NewYork\", \"Rome\"}: 60 = " + totalRuntime(2,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
    }

    public int solution(int cacheSize, String[] cities) {
//        test();
        int answer = totalRuntime(cacheSize, cities);
        return answer;
    }

    public boolean cacheHit(List<String> cacheArray, String city) {
        if (cacheArray.contains(city.toLowerCase())) {
            return true;
        }

        return false;
    }

    public List<String> nextCacheArray(int cacheSize, List<String> cacheArray, String city) {
        List<String> nextArray = new ArrayList<>(cacheArray);

        if (cacheArray.size() > 0 && cacheArray.get(cacheArray.size() - 1).equals(city.toLowerCase())) {
            return nextArray;
        }

        if (cacheHit(cacheArray, city)) {
            nextArray.remove(city.toLowerCase());
            nextArray.add(city.toLowerCase());

            return nextArray;
        }

        if (cacheArray.size() < cacheSize) {
            nextArray.add(city.toLowerCase());

            return nextArray;
        }

        nextArray.remove(0);
        nextArray.add(city.toLowerCase());

        return nextArray;
    }

    public int totalRuntime(int cacheSize, String[] cities) {
        List<String> cacheArray = new ArrayList<>();
        int runtime = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (int i = 0; i < cities.length; i += 1) {
            if (cacheHit(cacheArray, cities[i])) {
                runtime += 1;
            }

            if (!cacheHit(cacheArray, cities[i])) {
                runtime += 5;
            }

            cacheArray = nextCacheArray(cacheSize, cacheArray, cities[i]);
        }

        return runtime;
    }
}

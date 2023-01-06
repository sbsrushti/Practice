package paloalto;

import java.util.*;

public class Interview {

    public static void main(String[] args) {
        Map<String, Integer> urlCounts = new HashMap<>();
        urlCounts.put("mail.google.com", 200);
        urlCounts.put("search.google.com", 400);
        urlCounts.put("news.yahoo.com", 300);
        urlCounts.put("sports.yahoo.com", 100);
        urlCounts.put("dmv.ca.gov", 100);
        urlCounts.put("county.ca.gov", 150);
        //county.ca.gov: 150


        Map<String, Integer> result = agrregateCount(urlCounts);

        for (Map.Entry<String, Integer> entry: result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    private static Map<String, Integer> agrregateCount(Map<String, Integer> urlCounts) {

        Map<String, Integer> aggregatedResult = new HashMap<>();

        int sum = 0;

        for (Map.Entry<String, Integer> entry: urlCounts.entrySet()) {

            String url = entry.getKey();
            int count = entry.getValue();
            sum += count;

            aggregatedResult.put(url, count);

            int idx = url.indexOf('.');

            while (idx != -1) {

                url = url.substring(idx + 1);

                if (!aggregatedResult.containsKey(url)) {
                    aggregatedResult.put(url, 0);
                }

                aggregatedResult.put(url, aggregatedResult.get(url) + count);

                idx = url.indexOf('.');
            }
        }

        aggregatedResult.put("*", sum);
        return aggregatedResult;
    }
}

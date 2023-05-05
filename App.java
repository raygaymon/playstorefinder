package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        String source = args[0];

        List<String> apps = new ArrayList<>();

        File excel = new File(source);

        if (!excel.exists()) {

            System.out.println("File not found");
        }

        FileReader fr = new FileReader(excel);
        BufferedReader br = new BufferedReader(fr); // correct

        String app;

        while ((app = br.readLine()) != null) {

            if (!app.contains("NaN")) {

                apps.add(app);
            }

        }

        br.close();

        List<Apps> appList = new LinkedList<>();
        List<String> appCats = new LinkedList<>();

        for (int i = 1; i < apps.size(); i++) {

            String appDeets[] = apps.get(i).split(",");
            String name = appDeets[0];
            String cat = appDeets[1];
            Float rating = Float.parseFloat(appDeets[2]);
            Apps a = new Apps(cat, name, rating);
            appList.add(a);
            if (!appCats.contains(cat)) {
                appCats.add(cat);
            }

        }

        Map<String, List<Apps>> sortedList = appList.stream()
                .collect(Collectors.groupingBy(Apps -> Apps.getCategory()));

        Map<String, String> topratings = new HashMap<>();
        Map<String, String> lowratings = new HashMap<>();
        Apps highest = new Apps();
        Apps highestApp = new Apps();

        for (int i = 0; i < appCats.size(); i++) {

            topratings.putIfAbsent(appCats.get(i), highestApp.findHighApp(sortedList.get(appCats.get(i))).getAppName()
                    + " with a rating of " + Float.toString(highest.findHigh(sortedList.get(appCats.get(i)))));
            lowratings.putIfAbsent(appCats.get(i), highestApp.findLowApp(sortedList.get(appCats.get(i))).getAppName()
                    + " with a rating of " + Float.toString(highest.findLow(sortedList.get(appCats.get(i)))));

        }

        // highest.appSearcher(topratings, lowratings, "PERSONALIZATION");
        // highest.findAvgRating(sortedList.get("PERSONALIZATION"),"PERSONALIZATION" );

        // for (int i = 0; i < topratings.size(); i++) {

        // System.out.println("Category: " + appCats.get(i) + "\nBest rated app: " +
        // topratings.get(appCats.get(i)));
        // }

        // for (int i =0; i < lowratings.size(); i++) {

        // System.out.println("Category: " + appCats.get(i) + "\nLowest rated app: " +
        // lowratings.get(appCats.get(i)));
        // }

        // for (int i =0; i < sortedList.size(); i++) {

        // System.out.println(highest.findAvgRating(sortedList.get(appCats.get(i)),
        // appCats.get(i)));
        // }

        Console cons = System.console();

    
        String input = "";

        while (!input.equals("done")) {

            input = cons.readLine("Please enter a play store category. Enter 'help' for a list of categories: \n");

            if (input.equals("help")) {
                System.out.println("The list of categories are: \n");
                for (String cats : appCats) {
                    System.out.println(cats + "\n");
                }
            }

            else if (!topratings.containsKey(input)) {

                System.out.println("You can't do that");
            }

            else {
                System.out.println("For " + input + ", the best rated app is " + topratings.get(input));
                System.out.println("For " + input + ", the worst rated app is " + lowratings.get(input));
                System.out.println(highest.findAvgRating(sortedList.get(input), input));

            }
        }
        
        
        

        // prof's code not mine
        // FileReader fr2 = new FileReader (source);
        // BufferedReader br2 = new BufferedReader(fr2);
        // Map<String, playstorestats> stats = new HashMap<>();

        // br2.lines()
        // .skip(1)
        // .filter(line -> !line.contains("NaN"))
        // .map(line -> line.split(","))
        // .map(cols -> new PlaystoreEntries(cols[0].trim(), cols[1].trim(),
        // Float.parseFloat(cols[2].trim())))
        // .collect(Collectors.groupingBy(entry -> entry.category())) // entry becomes
        // Map<String, List<PlaystoreEntry>>, the map of string and maps we tried to do
        // .forEach((String category, List<PlaystoreEntries> entries) -> {
        // playstorestats s = new playstorestats(category);
        // for (PlaystoreEntries e : entries) {
        // s.compute(e);
        // }
        // stats.put(category, s);
        // })
        // ;

        // br2.close();
        // fr2.close();

        // for (String c : stats.keySet()) {
        // playstorestats s = stats.get(c);
        // System.out.printf("%s: avg: %f, ^%s: %f, V%s: %f\n", c, s.averageRating(),
        // s.getBestApp(),
        // s.getHighest(), s.getWorstApp(), s.getLowest());
        // }

    }
}

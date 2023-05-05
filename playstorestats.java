package sg.edu.nus.iss;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class playstorestats {
    
    private String category;
    private float highest = -1;
    private float lowest = 6;
    private String bestApp;
    private String worstApp;
    private List<Float> allRatings = new LinkedList<>();

    public playstorestats(String c) {
        category = c;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getHighest() {
        return highest;
    }
    public void setHighest(float highest) {
        this.highest = highest;
    }
    public float getLowest() {
        return lowest;
    }
    public void setLowest(float lowest) {
        this.lowest = lowest;
    }
    public String getBestApp() {
        return bestApp;
    }
    public void setBestApp(String bestApp) {
        this.bestApp = bestApp;
    }
    public String getWorstApp() {
        return worstApp;
    }
    public void setWorstApp(String worstApp) {
        this.worstApp = worstApp;
    }
    public List<Float> getAllRatings() {
        return allRatings;
    }
    public void setAllRatings(List<Float> allRatings) {
        this.allRatings = allRatings;
    }

    public void compute(PlaystoreEntries entry) {

        
        allRatings.add(entry.rating());
        if(entry.rating() < getLowest()) {

            setLowest(entry.rating());
            setWorstApp(entry.appName());
        }

        allRatings.add(entry.rating());
        if(entry.rating() > getHighest()) {

            setHighest(entry.rating());
            setBestApp(entry.appName());
        }


    }


    public Float averageRating() {
        return allRatings.stream().reduce(0f, (acc, v) -> acc + v) / allRatings.size();
    }
    
}

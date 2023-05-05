package sg.edu.nus.iss;

import java.util.List;
import java.util.Map;

public class Apps {

    public String category;
    public String appName;
    public float rating;

    
    public Apps(String category, String appName, float rating) {
        this.category = category;
        this.appName = appName;
        this.rating = rating;
    }
    
    public Apps() {
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getAppName() {
        return appName;
    }
    public void setAppName(String appName) {
        this.appName = appName;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }

    public float findHigh (List <Apps> a) {

        Apps top = new Apps();
        float rate = 0;
        for (int i = 0; i < a.size(); i++) {

            if (a.get(i).getRating() > rate) {

                rate = a.get(i).getRating();
                top = a.get(i);
            }
            else {}
        }
        return rate;
    }

    public Apps findHighApp (List <Apps> a) {

        Apps top = new Apps();
        float rate = 0;
        for (int i = 0; i < a.size(); i++) {

            if (a.get(i).getRating() > rate) {

                rate = a.get(i).getRating();
                top = a.get(i);
            }
            else {}
        }
        return top;
    }

    public float findLow(List <Apps> a) {

        Apps top = new Apps();
        float rate = 5;
        for (int i = 0; i < a.size(); i++) {

            if (a.get(i).getRating() < rate) {

                rate = a.get(i).getRating();
                top = a.get(i);
            }
            else {}
        }
        return rate;
    }

    public Apps findLowApp (List <Apps> a) {

        Apps top = new Apps();
        float rate = 5;
        for (int i = 0; i < a.size(); i++) {

            if (a.get(i).getRating() < rate) {

                rate = a.get(i).getRating();
                top = a.get(i);
            }
            else {}
        }
        return top;
    }

    public String findAvgRating (List <Apps> a, String name) {

        float f = 0;
        int n = 0;
        for (int i = 0; i < a.size(); i++) {

            f = f + a.get(i).getRating();
            n += 1;

        }

        float avg = f/n;
        String result= "The average rating of " + name + " is " + avg;
        return result;

    }

    public void appSearcher (Map<String, String> m, Map<String, String> n, String category) {

        System.out.println("The highest rated app in " + category + " is " + m.get(category) + " and the lowest rated app in " + category + " is " + n.get(category));
    }

    

    
}

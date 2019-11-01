package misc;

import java.util.ArrayList;
import java.util.List;

public class CompetitorReviewCount {
    public ArrayList<String> getTopNCompetitors(int topNCompetitor, int totalCompetitor, List<String> competitors, int totalReviews, List<String> reviews) {
        ArrayList<String> results = new ArrayList<>();
        if (topNCompetitor < 1) return results;
        if (totalCompetitor != competitors.size()) return results;
        if (totalReviews != reviews.size()) return results;

        String[][] reviewsArr = new String[totalCompetitor][2];

        for (String competitor : competitors) {
            for (String review : reviews) {
                review.split(competitor);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        String s1 = "rohan aa bb cc";
        String s2 = "aa rohan bb ";
        String s3 = "aa vvv rohan";
        String s4 = "rohan ss rohan";
        System.out.println(s1.split("rohan").length);
        System.out.println(s2.split("rohan").length);
        System.out.println(s3.split("rohan").length);
        System.out.println(s4.split("rohan").length);
    }
}

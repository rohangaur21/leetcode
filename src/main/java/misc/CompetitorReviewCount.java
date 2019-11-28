package misc;

import java.util.*;

public class CompetitorReviewCount {
    public static ArrayList<String> getTopNCompetitors(int topNCompetitor, int totalCompetitor, List<String> competitors, int totalReviews, List<String> reviews) {
        ArrayList<String> results = new ArrayList<>();
        if (topNCompetitor < 1) return results;
        if (totalCompetitor != competitors.size()) return results;
        if (totalReviews != reviews.size()) return results;

        Set<CompetitorReview> competitorReviewSet = new TreeSet<>(new Comparator<CompetitorReview>() {
            @Override
            public int compare(CompetitorReview o1, CompetitorReview o2) {
                return o2.reviewCount.compareTo(o1.reviewCount);
            }
        });

        int count = 0;
        boolean found = false;
        for (String competitor : competitors) {
            for (String review : reviews) {
                count = review.endsWith(competitor) ? review.split(competitor).length : review.split(competitor).length - 1;
                found = false;
                for (CompetitorReview cr : competitorReviewSet) {
                    if (cr.competitor.equals(competitor)) {
                        found = true;
                        cr.reviewCount += count;
                    }
                }
                if (!found) {
                    competitorReviewSet.add(new CompetitorReview(competitor, count));
                }
            }
        }

        for (CompetitorReview cr : competitorReviewSet) {
            System.out.println(cr.competitor+" "+cr.reviewCount);
        }

        for (CompetitorReview cr : competitorReviewSet) {
            if (topNCompetitor == 0) break;
            results.add(cr.competitor);
            topNCompetitor--;
        }
        return results;
    }

    static class CompetitorReview {
        public String competitor;
        public Integer reviewCount;

        public CompetitorReview(String competitor, Integer reviewCount) {
            this.competitor = competitor;
            this.reviewCount = reviewCount;
        }
    }

    public static void main(String[] args) {
        String s1 = " aa bb rohan cc sunny";
        String s2 = "gaur aa rohan bb ";
        String s3 = "aa gaur vvv sunny";
        String s4 = "rohan ss gaur";
        String s5 = "sunny ss rohan";
        System.out.println(getTopNCompetitors(10, 3, Arrays.asList("rohan", "gaur", "sunny"), 5, Arrays.asList(s1, s2, s3, s4, s5)));
    }
}

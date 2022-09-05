package removier.mvc.view;

import removier.mvc.dto.Movie;
import removier.mvc.dto.Review;
import removier.mvc.dto.User;
import removier.mvc.util.ViewUtil;

import java.util.List;

public class OutputView {
    public static void printMovieReview(List<Review> reviews) {
        for (Review review : reviews) {
            final StringBuilder sb = new StringBuilder();
            sb.append("[작성자]  ").append(review.getUserLoginId() + "\t");
            sb.append("[평점]  ").append(review.getReview_stars() + "/5").append("\n");
            sb.append("[리뷰]  ").append(review.getReview_content());
            ViewUtil.printMessage(sb.toString());
        }
    }

    public static void printUserReview(User user, Movie movie) {
        Review review = null;
        for (Review userReview : user.getReviews()) {
            for (Review movieReview : movie.getReviewList()) {
                if (userReview.getUser_id() == movieReview.getUser_id()) {
                    review = userReview;
                    break;
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("[작성자]  ").append(user.getLogingId() + "\t");
        sb.append("[평점]  ").append(review.getReview_stars() + "/5").append("\n");
        sb.append("[리뷰]  ").append(review.getReview_content() + "\n");
        ViewUtil.printMessage(sb.toString());
    }
}

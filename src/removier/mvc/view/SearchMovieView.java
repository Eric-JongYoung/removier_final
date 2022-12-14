package removier.mvc.view;

import removier.mvc.controller.MovieController;
import removier.mvc.controller.ReviewController;
import removier.mvc.controller.UserController;
import removier.mvc.dto.Movie;
import removier.mvc.dto.Review;
import removier.mvc.dto.User;
import removier.mvc.util.ViewUtil;


public class SearchMovieView {
    public static void searchMovie(User user) {
        ViewUtil.printMessage("----- 현재 로그인된 사용자 : " + user.getLogingId() + " -----");
        ViewUtil.printMessage("★★★★★★★★★★★  영화검색  ★★★★★★★★★★★");
        ViewUtil.printMessage("1. 영화이름    2. 배우이름    3. 장르");
        int input = Integer.parseInt(ViewUtil.input("선택 > "));
        switch (input) {
            case 1:
                String movieName = searchMovieTitle();
//                UserController.updatedUserInfo(user);
                MovieController.movieSelectByMovieTitle(movieName);
                break;
            case 2:
                String actorName = searchActorName();
//                UserController.updatedUserInfo(user);
                MovieController.movieSelectByActor(actorName);
                break;
            case 3:
                String movieGenre = searchMovieGenre();
                MovieController.movieSelectByGenre(movieGenre);
                break;

        }
    }

    private static String searchMovieGenre() {
        ViewUtil.printMessage("================ 영화장르를 검색하세요 ================");
        System.out.println();
        return ViewUtil.input("영화장르 ▶ ");

    }

    private static String searchMovieTitle() {
        ViewUtil.printMessage("=== 영화이름을 검색하세요 (정확한 영화이름으로 검색하세요!!) ===");
        return ViewUtil.input("영화이름 > ");
    }

    private static String searchActorName() {
        ViewUtil.printMessage("=== 배우이름을 검색하세요 ===");
        return ViewUtil.input("배우이름 > ");
    }

    public static void movieResult(User user, Movie movie) throws Exception {
        boolean run = true;
        while (run) {
            User updatedUser = UserController.updatedUserInfo(user);
            Movie updatedMovie = MovieController.updatedMovieInfo(movie);
            SuccessView.printMovieInfo(updatedMovie);

            if (updatedMovie.getReviewList() == null || updatedMovie.getReviewList().size() == 0) {
                ViewUtil.printMessage("작성된 리뷰가 없습니다.");
            } else {
                SuccessView.printMovieReview(updatedMovie.getReviewList());
            }
            ViewUtil.printMessage("=== 1. 리뷰 작성  2. 리뷰 수정하기  3. 리뷰 삭제하기  4. 즐겨찾기 추가  5. 즐겨찾기 취소  9. 메인으로 ===");

            int input = Integer.parseInt(ViewUtil.input("선택 > "));
            switch (input) {
                case 1:
                    int result = 0;
                    User updatedUserInfo = UserController.updatedUserInfo(updatedUser);
                    for (Review userReview : updatedUserInfo.getReviews()) {
                        if (userReview.getMovie_id() == updatedMovie.getMovie_pk()) {
                            result = 1;
                        }
                    }
                    if (result == 1) {
                        ViewUtil.printMessage("이미 작성하신 리뷰가 존재합니다!!!!");
                        break;
                    }

                    Review newReview = createReview(updatedUser, updatedMovie);
                    ReviewController.createReview(newReview);
                    break;
                case 2:
                    User updatedUserInfo2 = UserController.updatedUserInfo(updatedUser);
                    Review updateReview = updateReview(updatedUserInfo2, updatedMovie);
                    if (updateReview == null) {
                        ViewUtil.printMessage("작성하신 리뷰가 없습니다.");
                        break;
                    }
                    ReviewController.updateReview(updateReview);
                    break;
                case 3:
                    int deleteResult = 0;
                    User updatedUserInfo3 = UserController.updatedUserInfo(updatedUser);
                    for (Review review : updatedMovie.getReviewList())
                        if (review.getUser_id() == updatedUserInfo3.getMember_pk()) {
                            deleteResult = 1;
                        }
                    if (deleteResult == 1) {
                        if (Integer.parseInt(ViewUtil.input("정말 삭제하시겠습니까? \n ( 메인으로가기 : 1 || 삭제하기 : 2 ) > ")) == 2) {
                            deleteReview(updatedUser, updatedMovie);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        ViewUtil.printMessage("삭제하실 리뷰가 없습니다.");
                        break;
                    }
                case 4:
                    UserController.addBookmark(user, movie);
                    break;
                case 5:
                    UserController.deleteBookmark(user, movie);
                    break;
                case 9:
                    run=false;

            }

        }
    }

    private static void deleteReview(User user, Movie movie) {
        ReviewController.deleteReview(user, movie);
    }

    private static Review updateReview(User user, Movie movie) {
        int review_star = 0;
        String review_contents = null;
        Review review = null;

        for (Review userReview : user.getReviews()) {
            if (userReview.getMovie_id() == movie.getMovie_pk()) {
                SuccessView.printUserReview(user, movie);
                review_star = Integer.parseInt(ViewUtil.input("평점 > "));
                review_contents = ViewUtil.input("리뷰 > ");
                userReview.setReview_stars(review_star);
                userReview.setReview_content(review_contents);
                review = userReview;
            }
        }
        return review;
    }


    private static Review createReview(User user, Movie movie) {
        int review_star = 0;
        String review_contents = null;
        ViewUtil.printMessage("=== 리뷰작성 ===");

        while (true) {
            review_star = Integer.parseInt(ViewUtil.input("별점 > "));

            if (isNotValidRange(review_star)) {
                ViewUtil.errorMessage("1 ~ 5사이의 숫자를 입력해주세요!");
                continue;
            }

            review_contents = ViewUtil.input("리뷰 > ");
            return new Review(review_star, review_contents, user, movie);

        }
    }

    private static boolean isNotValidRange(int review_star) {
        return review_star < 0 || review_star > 5;
    }


    public static void showTopFive() {
        MovieController.movieTopFive();
    }

    public static void showBestMyGenreMovie(User user) {
        MovieController.showBestMyGenreMovie(user);
    }
}



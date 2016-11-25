package ge.mziuri.restaraunt.model;

public class FoodReview {

    private String foodName;

    private String commnet;

    private int rating;

    public FoodReview() {
    }

    public FoodReview(String foodName, String commnet, int rating) {
        this.foodName = foodName;
        this.commnet = commnet;
        this.rating = rating;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCommnet() {
        return commnet;
    }

    public void setCommnet(String commnet) {
        this.commnet = commnet;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return  "კერძი: " + foodName + " კომენტარი: " + commnet + " შეფასება: " + rating;

    }
}

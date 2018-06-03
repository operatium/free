package m.main;

/**
 * Created by Administrator on 2018/6/2.
 */

public class FunctionItemData {
    private String imageUrl;
    private int res;
    private int backgroundColor;
    private String text;

    public FunctionItemData(String imageUrl, int res, int backgroundColor, String text) {
        this.imageUrl = imageUrl;
        this.res = res;
        this.backgroundColor = backgroundColor;
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}

package m;

/**
 * Created by opera on 2018/6/1.
 */

public class MessageEvent {
    private String str1;
    private String str2;
    private int int1;
    private int int2;
    private Object object1;
    private Object object2;

    public String getStr1() {
        return str1;
    }

    public MessageEvent setStr1(String str1) {
        this.str1 = str1;
        return this;
    }

    public String getStr2() {
        return str2;
    }

    public MessageEvent setStr2(String str2) {
        this.str2 = str2;
        return this;
    }

    public int getInt1() {
        return int1;
    }

    public MessageEvent setInt1(int int1) {
        this.int1 = int1;
        return this;
    }

    public int getInt2() {
        return int2;
    }

    public MessageEvent setInt2(int int2) {
        this.int2 = int2;
        return this;
    }

    public Object getObject1() {
        return object1;
    }

    public MessageEvent setObject1(Object object1) {
        this.object1 = object1;
        return this;
    }

    public Object getObject2() {
        return object2;
    }

    public MessageEvent setObject2(Object object2) {
        this.object2 = object2;
        return this;
    }
}

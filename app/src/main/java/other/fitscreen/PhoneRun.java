package other.fitscreen;

/**
 * Created by opera on 2018/5/30.
 */

public enum PhoneRun {
    Good(500)//性能优秀
    ,Ordinary(2000)//能用
    ,Worst(10000)//特别垃圾的设备
    ,NULL(-1);

    private int time;

    PhoneRun(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

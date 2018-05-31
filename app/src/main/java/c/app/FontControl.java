package c.app;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Administrator on 2017/11/11.
 */

public class FontControl {
    private static Typeface WeiRuanYaHeiTi;
    private static Typeface FangZhengKaiTiJianTi;
    private static Typeface HuaKangHaiBaoTi;

    //方正楷体简体
    public static Typeface getFont_FangZhengKaiTiJianTi(Context context) {
        if (FangZhengKaiTiJianTi == null)
            FangZhengKaiTiJianTi = Typeface.createFromAsset(context.getAssets(), "fonts/fzktjt.TTF");
        return FangZhengKaiTiJianTi;
    }

    //华康海报体
    public static Typeface getFont_HuaKangHaiBaoTi(Context context) {
        if (HuaKangHaiBaoTi == null)
            HuaKangHaiBaoTi = Typeface.createFromAsset(context.getAssets(), "fonts/hkhb.TTF");
        return HuaKangHaiBaoTi;
    }

    //微软雅黑
    public static Typeface getFont_WeiRuanYaHeiTi(Context context) {
        if (WeiRuanYaHeiTi == null)
            WeiRuanYaHeiTi = Typeface.createFromAsset(context.getAssets(), "fonts/wryh.TTF");
        return WeiRuanYaHeiTi;
    }
}

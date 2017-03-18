package com.azoft.carousellayoutmanager;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * 作者： gaowei on 2017/3/17 17:34
 * 邮箱： gaoweivf@aliyun.com
 */

public class CarouseListPostLayoutListener  implements CarouselLayoutManager.PostLayoutListener {
    @Override
    public ItemTransformation transformChild(@NonNull View child, float itemPositionToCenterDiff, int orientation) {
        return new ItemTransformation(1,1,Math.abs(itemPositionToCenterDiff*100),100);
    }
}

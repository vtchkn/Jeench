package com.example.evetochkin.jeench.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.example.evetochkin.jeench.R;

public class RaitingView extends View {
    public static final int MAX = 1000;
    public static final int GAP = 10;
    final Paint raitngPaint = new Paint();
    final Paint allPaint = new Paint();
    private long raitng;


    public RaitingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        raitngPaint.setColor(getResources().getColor(R.color.progressColor));
        raitngPaint.setStyle(Paint.Style.STROKE);
        raitngPaint.setStrokeWidth(10);
        allPaint.setColor(getResources().getColor(R.color.progressBg));
        allPaint.setStyle(Paint.Style.STROKE);
        allPaint.setStrokeWidth(10);

    }

    public void update(long raitng) {
        this.raitng = raitng;
        invalidate();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (raitng == 0)
            return;

        float raitingAngle = 360.f * raitng / MAX, allAngle = 360.f * MAX / raitng;
        int size = Math.min(getWidth() - GAP, getHeight() - GAP * 2);
        final int xMargin = (getWidth() - size - GAP) / 2, yMargin = (getHeight() - size - GAP) / 2;

        canvas.drawArc(xMargin, yMargin, getWidth() - xMargin, getHeight() - yMargin, 360 - allAngle / 2, allAngle, false, allPaint);
        canvas.drawArc(xMargin, yMargin, getWidth() - xMargin, getHeight() - yMargin, 180 - raitingAngle / 2, raitingAngle, false, raitngPaint);
    }
}

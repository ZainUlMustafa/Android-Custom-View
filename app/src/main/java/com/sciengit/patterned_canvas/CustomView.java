package com.sciengit.patterned_canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {

    private Paint paint;
    private double heightOfCanvas;
    private double widthOfCanvas;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public void refresh() {
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // acquiring the canvas height and width [depends on phone] and coloring it
        heightOfCanvas = canvas.getHeight();
        widthOfCanvas = canvas.getWidth();
        canvas.drawColor(Color.BLACK);

        // creating a blue box
        drawBlueBox(canvas);
    }

    private void tileSymbols(int resourceId) {

    }

    private void drawBlueBox(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(204, 255, 255));
        float boxSize = widthOfCanvas >= 1000 ? 1000 : 500;
        float top = (((float) heightOfCanvas) / 2) - (boxSize / 2);
        float bottom = (((float) heightOfCanvas) / 2) + (boxSize / 2);
        float left = (((float) widthOfCanvas) / 2) - (boxSize / 2);
        float right = (((float) widthOfCanvas) / 2) + (boxSize / 2);
        canvas.drawRect(left, top, right, bottom, paint);
    }
}

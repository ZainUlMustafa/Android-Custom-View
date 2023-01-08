package com.sciengit.patterned_canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

public class CustomView extends View {

    private Paint paint;
    private Paint bitmapPaint;
    private double heightOfCanvas;
    private double widthOfCanvas;

    private static final String TAG = "CUST";

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
        canvas.drawColor(Color.LTGRAY);

        // creating a blue box
        float boxSize = widthOfCanvas >= 1000 ? 1000 : 500;
        drawBlueBox(canvas, boxSize);
        drawTilesWithBitmap(canvas, R.drawable.pothole, 10, 10, boxSize);
    }

    private void drawBlueBox(Canvas canvas, float ltrb[]) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(204, 255, 255));

        float left= ltrb[0];
        float top= ltrb[1];
        float right= ltrb[2];
        float bottom= ltrb[3];
        canvas.drawRect(left, top, right, bottom, paint);
    }

    private void drawRedBox(Canvas canvas, float ltrb[]) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(204, 0, 0));

        float left= ltrb[0];
        float top= ltrb[1];
        float right= ltrb[2];
        float bottom= ltrb[3];
        canvas.drawRect(left, top, right, bottom, paint);
    }

    private void drawTilesWithBitmap(Canvas canvas, int resourceId,int iconSize, float ltrb[]) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
        bitmap = Bitmap.createScaledBitmap(bitmap, iconSize, iconSize, false);
        bitmapPaint = new Paint(Paint.FILTER_BITMAP_FLAG);
        Shader mShader1 = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        bitmapPaint.setShader(mShader1);

        float left= ltrb[0];
        float top= ltrb[1];
        float right= ltrb[2];
        float bottom= ltrb[3];
        canvas.drawRect(left, top, right, bottom, bitmapPaint);
    }

    private void drawTilesWithBitmap(Canvas canvas, int resourceId,int iconSize, float boxSize) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
        bitmap = Bitmap.createScaledBitmap(bitmap, iconSize, iconSize, false);
        paint = new Paint(Paint.FILTER_BITMAP_FLAG);
        Shader mShader1 = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paint.setShader(mShader1);

        float top = (((float) heightOfCanvas) / 2) - (boxSize / 2);
        float bottom = (((float) heightOfCanvas) / 2) + (boxSize / 2);
        float left = (((float) widthOfCanvas) / 2) - (boxSize / 2);
        float right = (((float) widthOfCanvas) / 2) + (boxSize / 2);
        canvas.drawRect(left, top, right, bottom, paint);
    }

    private void drawTilesWithBitmap(Canvas canvas, int resourceId,int iconWidth, int iconHeight, float boxSize) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
        bitmap = Bitmap.createScaledBitmap(bitmap, iconWidth, iconHeight, false);
        paint = new Paint(Paint.FILTER_BITMAP_FLAG);
        Shader mShader1 = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paint.setShader(mShader1);

        float top = (((float) heightOfCanvas) / 2) - (boxSize / 2);
        float bottom = (((float) heightOfCanvas) / 2) + (boxSize / 2);
        float left = (((float) widthOfCanvas) / 2) - (boxSize / 2);
        float right = (((float) widthOfCanvas) / 2) + (boxSize / 2);
        canvas.drawRect(left, top, right, bottom, paint);
    }

    private void drawBlueBox(Canvas canvas, float boxSize) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(204, 255, 255));

        float top = (((float) heightOfCanvas) / 2) - (boxSize / 2);
        float bottom = (((float) heightOfCanvas) / 2) + (boxSize / 2);
        float left = (((float) widthOfCanvas) / 2) - (boxSize / 2);
        float right = (((float) widthOfCanvas) / 2) + (boxSize / 2);
        canvas.drawRect(left, top, right, bottom, paint);
    }
}

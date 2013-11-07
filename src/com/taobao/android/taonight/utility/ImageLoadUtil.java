package com.taobao.android.taonight.utility;

import android.content.Context;
import android.graphics.*;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 13-1-14
 * To change this template use File | Settings | File Templates.
 */
public class ImageLoadUtil {

    public static final Bitmap loadImage(Context context, int bitAdress) {

        Bitmap bitmaptemp = null;

        bitmaptemp = BitmapFactory.decodeResource(context.getResources(), bitAdress);

        return bitmaptemp;

    }

    public static final void cuteImage(Canvas g, Paint paint, Bitmap imgBit, int x,

                                       int y, int w, int h, int line, int row) {

        g.clipRect(x, y, x + w, h + y);

        g.drawBitmap(imgBit, x - line * w, y - row * h, paint);

        g.restore();

    }

    public static Bitmap zoomImage(Bitmap bgimage, int newWidth, int newHeight) {

        int width = bgimage.getWidth();

        int height = bgimage.getHeight();

        Matrix matrix = new Matrix();
        float scaleWidth = ((float) newWidth) / width;

        float scaleHeight = ((float) newHeight) / height;
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, width, height,

                matrix, true);

        return bitmap;

    }

    public static void drawText(String strMsg, Canvas g, Paint paint, int setx,

                                int sety, int fg, int bg) {

        paint.setColor(bg);

        g.drawText(strMsg, setx + 1, sety, paint);

        g.drawText(strMsg, setx, sety - 1, paint);

        g.drawText(strMsg, setx, sety + 1, paint);

        g.drawText(strMsg, setx - 1, sety, paint);

        paint.setColor(fg);

        g.drawText(strMsg, setx, sety, paint);

        g.restore();

    }
}

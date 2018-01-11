package com.knitcode.transparentparentlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import static android.widget.ImageView.ScaleType.CENTER;
import static android.widget.ImageView.ScaleType.CENTER_CROP;
import static android.widget.ImageView.ScaleType.CENTER_INSIDE;
import static android.widget.ImageView.ScaleType.FIT_CENTER;
import static android.widget.ImageView.ScaleType.FIT_END;
import static android.widget.ImageView.ScaleType.FIT_START;
import static android.widget.ImageView.ScaleType.FIT_XY;
import static android.widget.ImageView.ScaleType.MATRIX;

public class TransparentParentLayoutWithXMLLayout extends FrameLayout {

    private float opacity = 1f;


    private AppCompatImageView.ScaleType scaleType = CENTER_CROP;

    private AppCompatImageView imgBG;

    public TransparentParentLayoutWithXMLLayout(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public TransparentParentLayoutWithXMLLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        // Inflating Layout
        inflate(getContext(), R.layout.transparent_view_layout, this);
        // Default values
        opacity = 1f;
        // Finding Views
        imgBG = findViewById(R.id.imgBg);
        imgBG.setScaleType(scaleType);
        // Set Attirbutes here
        if (attrs != null) {
            final TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.TransparentParentLayoutWithXMLLayout, 0, 0);
            try {
                opacity = attrArray.getFloat(R.styleable.TransparentParentLayoutWithXMLLayout_tplwxl_opacity, opacity);
                scaleType = getScaleType(attrArray.getInteger(R.styleable.TransparentParentLayoutWithXMLLayout_tplwxl_scaletype, 6));
            } finally {
                attrArray.recycle();
            }
        }
    }

    private ImageView.ScaleType getScaleType(int value) {

        if (value == 0) return MATRIX;
        else if (value == 1) return FIT_XY;
        else if (value == 2) return FIT_START;
        else if (value == 3) return FIT_CENTER;
        else if (value == 4) return FIT_END;
        else if (value == 5) return CENTER;
        else if (value == 6) return CENTER_CROP;
        else return CENTER_INSIDE;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        renderView();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        renderView();
    }

    private void renderView() {
        imgBG.setAlpha(opacity);
        imgBG.setScaleType(scaleType);
    }

}


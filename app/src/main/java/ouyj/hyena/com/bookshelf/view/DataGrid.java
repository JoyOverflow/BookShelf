package ouyj.hyena.com.bookshelf.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

import ouyj.hyena.com.bookshelf.R;

/**
 * 自定义GridView视图
 */
public class DataGrid extends GridView implements View.OnClickListener{

    private Bitmap background;
    private Bitmap bookshelf_dock;

    /**
     * 构造方法
     * @param context
     */
    public DataGrid(Context context) {
        this(context, null);
    }
    public DataGrid(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public DataGrid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.shelf_center);
        bookshelf_dock = BitmapFactory.decodeResource(getResources(), R.drawable.shelf_docker);
    }
    @Override
    public void onClick(View v) {

    }


    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }
}

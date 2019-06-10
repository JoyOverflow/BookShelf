package ouyj.hyena.com.bookshelf.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import ouyj.hyena.com.bookshelf.MainActivity;
import ouyj.hyena.com.bookshelf.R;

/**
 * 自定义GridView视图
 */
public class DataGrid extends GridView implements View.OnClickListener{

    private Bitmap background;
    private Bitmap bookshelf_dock;
    private Context mcontext;

    private int i = 0;
    private View firtView;
    private TextView firstTextView;
    private final int[] location = new int[2];
    private final String TAG = MainActivity.class.getSimpleName();

    private int mNumColumns;
    private boolean mNumColumnsSet;
    private int mColumnWidth;
    private int mHorizontalSpacing;
    private int mStatusHeight;

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
        this.mcontext = context;

        mStatusHeight = getStatusHeight(context);
        Log.d(TAG," 状态栏高度 ：" + mStatusHeight);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.shelf_center);
        bookshelf_dock = BitmapFactory.decodeResource(getResources(), R.drawable.shelf_docker);

        if(!mNumColumnsSet){
            mNumColumns = AUTO_FIT;
        }
    }
    @Override
    public void onClick(View v) {
        Log.d("deleteImageButton","ok");
    }
    public int[] getFirstLocation() {
        return location;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        i++;

        //项视图数
        int count = getChildCount();
        //Log.d(TAG,"dispatchDraw ："+count);
        int backgroundHeightPanding = (int) convertDpToPixel(mcontext,4);
        int dockHightPanding = (int) convertDpToPixel(mcontext,3);


        //返回视图的宽高度（象素）
        int width = getWidth();
        int height = getHeight();

        int backgroundWidth = background.getWidth();
        int backgroundHeight = background.getHeight()-backgroundHeightPanding;


        int top = count > 0 ? getChildAt(0).getTop() : 0;
        for (int y = top; y < height; y += backgroundHeight) {
            for (int x = 0; x < width; x += backgroundWidth) {
                canvas.drawBitmap(background, x, y, null);
            }
            if(y > top) {
                //画隔断
                canvas.drawBitmap(
                        bookshelf_dock,
                        0 ,
                        y-dockHightPanding,
                        null
                );
            }
        }

        //得到第一项子视图
        if(i == 1) {
            firtView = getChildAt(0);
            firstTextView =  firtView.findViewById(R.id.book_name);
            firstTextView.getLocationInWindow(location);
        }

        //调用基类的绘制（注需先绘制以上的书柜背景）
        super.dispatchDraw(canvas);
    }
    public float convertDpToPixel(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
    }
    /**
     * 获得状态栏的高度
     * @param context
     * @return
     */
    public static int getStatusHeight(Context context)
    {
        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }






    @Override
    public void setHorizontalSpacing(int horizontalSpacing) {
        super.setHorizontalSpacing(horizontalSpacing);
        this.mHorizontalSpacing = horizontalSpacing;
    }
    @Override
    public void setColumnWidth(int columnWidth) {
        super.setColumnWidth(columnWidth);
        mColumnWidth = columnWidth;
    }
    @Override
    public void setNumColumns(int numColumns) {
        super.setNumColumns(numColumns);
        mNumColumnsSet = true;
        this.mNumColumns = numColumns;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mNumColumns == AUTO_FIT) {
            int numFittedColumns;
            if (mColumnWidth > 0) {
                int gridWidth = Math.max(MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()
                        - getPaddingRight(), 0);
                numFittedColumns = gridWidth / mColumnWidth;
                if (numFittedColumns > 0) {
                    while (numFittedColumns != 1) {
                        if (numFittedColumns * mColumnWidth + (numFittedColumns - 1)
                                * mHorizontalSpacing > gridWidth) {
                            numFittedColumns--;
                        } else {
                            break;
                        }
                    }
                } else {
                    numFittedColumns = 1;
                }
            } else {
                numFittedColumns = 2;
            }
            mNumColumns = numFittedColumns;
        }
    }
}

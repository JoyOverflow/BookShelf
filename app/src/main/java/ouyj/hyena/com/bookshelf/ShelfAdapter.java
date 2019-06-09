package ouyj.hyena.com.bookshelf;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 自定义适配器类
 */
public class ShelfAdapter extends BaseAdapter {

    //上下文对象和数据源
    private Context contex;
    private List<BookList> list;

    /**
     * 构造方法
     * @param context
     * @param list
     */
    public ShelfAdapter(Context context, List<BookList> list){
        this.contex = context;
        this.list = list;
    }
    /**
     * 数据源的记录数
     * @return
     */
    @Override
    public int getCount() {
        if(list.size() < 10)
            return 10;
        else
            return list.size();
    }
    /**
     * 返回指定项
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    /**
     * 每一项的视图
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }






}

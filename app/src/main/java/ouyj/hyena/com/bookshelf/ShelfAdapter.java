package ouyj.hyena.com.bookshelf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * 自定义适配器类
 */
public class ShelfAdapter extends BaseAdapter {

    //上下文对象和数据源
    private Context context;
    private List<Book> list;

    /**
     * 构造方法
     * @param context
     * @param list
     */
    public ShelfAdapter(Context context, List<Book> list){
        this.context = context;
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
     * 每一列表项的视图
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, null);
            viewHolder = new ViewHolder(convertView);

            //将查找到的视图缓存起来方便重用
            convertView.setTag(viewHolder);
        }
        else
            viewHolder = (ViewHolder) convertView.getTag();


        Book book=list.get(position);
        if(book.getPicture()>0){
            int pid=list.get(position).getPicture();
            viewHolder.name.setBackgroundResource(pid);

            //设置控件的drawable(Left/Right/Top/Bottom)
            viewHolder.name.setCompoundDrawables(null, null, null, null);
        }
        else{
            //设置项内视图的文本
            String bookName = book.getName();
            viewHolder.name.setText(bookName);
        }


        return convertView;
    }
    /**
     * 解析传入的ConvertView（得到项内视图引用的容器）
     */
    static class ViewHolder {
        public TextView name;
        public ImageButton img;
        public ViewHolder(View view) {
            name = view.findViewById(R.id.book_name);
            img = view.findViewById(R.id.img_close);
        }
    }
}

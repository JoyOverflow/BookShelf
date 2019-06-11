package ouyj.hyena.com.bookshelf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import ouyj.hyena.com.bookshelf.view.DataGrid;

public class MainActivity extends AppCompatActivity {

    private DataGrid bookShelf;
    private ShelfAdapter adapter;
    private List<Book> bookList;
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Book tmp = new Book(i,String.format("我的第%d本书", i));
            bookList.add(tmp);
        }
        bookList.get(0).setPicture(R.drawable.dinosaur);
        bookList.get(1).setPicture(R.drawable.seabed);
        bookList.get(2).setPicture(R.drawable.alice);
        bookList.get(3).setPicture(R.drawable.magiccube);

        //为书柜视图设置适配器
        bookShelf= findViewById(R.id.bookShelf);
        adapter = new ShelfAdapter(MainActivity.this, bookList);
        bookShelf.setAdapter(adapter);

        bookShelf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"onItemClick！");
            }
        });
    }



}

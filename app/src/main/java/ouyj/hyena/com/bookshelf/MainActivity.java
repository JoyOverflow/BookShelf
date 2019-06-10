package ouyj.hyena.com.bookshelf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import ouyj.hyena.com.bookshelf.view.DataGrid;

public class MainActivity extends AppCompatActivity {

    private DataGrid bookShelf;
    private ShelfAdapter adapter;
    private List<BookList> bookLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookLists = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BookList tmp = new BookList(i,String.format("我的第%d本书", i));
            bookLists.add(tmp);
        }

        //为书柜视图设置适配器
        bookShelf= findViewById(R.id.bookShelf);
        adapter = new ShelfAdapter(MainActivity.this,bookLists);
        bookShelf.setAdapter(adapter);
    }



}

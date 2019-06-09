package ouyj.hyena.com.bookshelf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

        //为书柜视图设置适配器
        bookShelf= findViewById(R.id.bookShelf);
        adapter = new ShelfAdapter(MainActivity.this,bookLists);
        bookShelf.setAdapter(adapter);
    }



}

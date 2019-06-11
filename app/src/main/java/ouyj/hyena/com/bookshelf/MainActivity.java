package ouyj.hyena.com.bookshelf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import ouyj.hyena.com.bookshelf.view.DataGrid;

public class MainActivity extends AppCompatActivity {

    private DataGrid bookShelf;
    private ShelfAdapter adapter;
    private List<Book> bookList;
    private final String TAG = MainActivity.class.getSimpleName();
    private static Boolean allowExit = false;

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
        bookList.get(0).setCodePath("dinosaur");
        bookList.get(1).setPicture(R.drawable.seabed);
        bookList.get(2).setPicture(R.drawable.alice);
        bookList.get(3).setPicture(R.drawable.magiccube);

        //为书柜视图设置适配器
        bookShelf= findViewById(R.id.bookShelf);
        adapter = new ShelfAdapter(MainActivity.this, bookList);
        bookShelf.setAdapter(adapter);

        //为书柜视图设置项点击事件处理
        bookShelf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"onItemClick！");
                //保证点击位置的有效
                if (bookList.size() > position) {
                    final Book book = bookList.get(position);
                    ReadActivity.openBook(book, MainActivity.this);
                }
            }
        });
    }




    /**
     * 2秒内连续按返回键两次才会退出应用
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitApplication();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exitApplication() {
        Timer tExit;
        if (!allowExit) {
            allowExit = true;

            Toast.makeText(
                    this,
                    this.getResources().getString(R.string.press_twice_to_exit),
                    Toast.LENGTH_SHORT
            ).show();

            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    allowExit = false;
                }
            }, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

}

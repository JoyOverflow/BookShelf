package ouyj.hyena.com.bookshelf;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReadActivity extends AppCompatActivity {

    private final static String EXTRA_BOOK = "book";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
    }

    /**
     * 打开指定活动（Book类需实现Serializable）
     * @param book
     * @param context
     * @return
     */
    public static boolean openBook(final Book book, Activity context) {
        if (book == null){
            throw new NullPointerException("Book can not be null");
        }
        Intent intent = new Intent(context, ReadActivity.class);
        intent.putExtra(EXTRA_BOOK, book);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        //Activity在切换时的动画（进入时动画，离开时动画）
        context.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        context.startActivity(intent);
        return true;
    }

}

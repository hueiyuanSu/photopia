import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.*;
import android.database.Cursor;

/**
 * Created by KeIS on 6/12/2017.
 */

public class MyDBhelper extends SQLiteOpenHelper {
    static final String db_name="photpia";    // 資料庫名稱
    static final String tb_name="photo";        // 資料表名稱
    SQLiteDatabase db;    //資料庫

    public MyDBhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}

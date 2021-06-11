package ma.atmar.AppAtmar.HelperClasses;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DB_sqlite extends SQLiteOpenHelper {
    public static String name = "Products.db";

    public DB_sqlite(@Nullable @org.jetbrains.annotations.Nullable Context context)
    {
        super(context, name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table produits (id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT,description TEXT,cat TEXT)");
        db.execSQL("INSERT INTO produits (title,description,cat) VALUES ('Disques de labour','Nous sommes le plus ancien et le plus important fabriquant de disques agricoles en Afrique du nord, et nous sommes en mesure de satisfaire tous vos besoins en disques lisses ou crénelés','outil_dis')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS produits");
        onCreate(db);
    }

    public ArrayList<Produits> getProducts(String cate)
    {
        ArrayList<Produits> arr = new ArrayList<Produits>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res=null;
        if(db != null)
        {
            res = db.rawQuery("select *from produits where cat='"+cate+"'",null);
            res.moveToFirst();
            while(res.isAfterLast() == false) {
                arr.add(new Produits(Integer.parseInt(res.getString(res.getColumnIndex("id"))),res.getString(res.getColumnIndex("title")),res.getString(res.getColumnIndex("description"))));
                res.moveToNext();
            }
        }
        return arr;
    }

}

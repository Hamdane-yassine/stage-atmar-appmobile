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
        db.execSQL("create table produits (id INTEGER PRIMARY KEY,title TEXT,description TEXT,cat TEXT)");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (1,'Disques de labour','Nous sommes le plus ancien et le plus important fabriquant de disques agricoles en Afrique du nord, et nous sommes en mesure de satisfaire tous vos besoins en disques lisses ou crénelés','outil_dis')");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (2,'Charrue Fixe','Disques en aciers traités de 660 mm de diamètre; Porte disques en acier coulé équipé de roulements à rouleaux coniques et arrêts d’huile; Roue de Sillon munie; Levier de pivotement manuel; Profondeur de travail : 30 à 35 cm.','outil_dis')");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (3,'Charrue Reversible','Disques en aciers traités de 660 mm de diamètre; Porte disques en acier coulé équipé de roulements à rouleaux coniques et arrêts d’huile; Roue de Sillon munie; Levier de pivotement manuel; Profondeur de travail : 30 à 35 cm.','outil_dis')");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (4,'Covercrop Traine','Disques: 610 mm de diamètre; Paliers en fonte ou à roulements; Ouverture réglable à partir de tracteur; Décrottoirs réglables; Écartement entre Disques: 230 mm; Profondeur de travail : 150 mm.','outil_dis')");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (5,'Stuble Plow','Disques en aciers traités de 710 mm de diamètre; Ouverture réglable à partir de tracteur; Décrottoirs réglables et amovibles; Écartement entre Disques: 280 mm; Profondeur de travail : 250 mm.','outil_dis')");
        //another cat
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (6,'Sous soleur','Dents découpées à partir de tôle forte de 40 mm et d’une dureté de 400 Brinell;','outil_dan')");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (7,'Chisel','Lames maîtresses en acier à ressorts trempées et revenues;\n" +
                "2 Ressorts à boudins servant de système d’effacement en cas d’obstacles majeurs;\n" +
                "Soc réversible en acier;\n" +
                "Écartement entre dents: 43 cm;\n" +
                "Profondeur de travail : 35 cm.','outil_dan')");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (8,'Canadien','Dents rigides forgés escamotable;\n" +
                "2 ressorts de rappel par dent;\n" +
                "Socs droits réversibles en forme de pattes d’oie;\n" +
                "Écartement entre dents : 250 mm;\n" +
                "Profondeur de Travail 150 mm.','outil_dan')");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (9,'Cultivateur','Dent carré de 25 mm traité en forme de queue de cochon;\n" +
                "Soc réversible traité;\n" +
                "Écartement entre dents : 250 mm;\n" +
                "Profondeur de Travail 150 mm.','outil_dan')");
        //another cat
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (10,'BETONNIERE A BASCULEMENT MECANIQUE','Les bétonnières BM 350 permettent une production horaire de béton très élevée.\n" +
                "\n" +
                "Le système de malaxage avec cuve à basculement mécanique permet la production de mortiers, chaux, béton et des revêtements muraux\n" +
                "\n" +
                "Le chargeur avec câble à basculement mécanique permet de préparer une gâchée pendant le malaxage du béton,\n" +
                "\n" +
                "Le déversement du matériau se fait par un basculement mécanique de la cuve.','mat')");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (11,'BETONNIERE A BASCULEMENT HYDRAULIQUE','Les bétonnières BH 350 permettent une production horaire de béton très élevée.\n" +
                "\n" +
                "Le système de malaxage avec cuve à basculement hydraulique permet la production de mortiers, chaux, béton et des revêtements muraux\n" +
                "\n" +
                "Le chargeur à basculement hydraulique permet de préparer une gâchée pendant le malaxage du béton.\n" +
                "\n" +
                "Le déversement du matériau se fait par un basculement hydraulique de la cuve.','mat')");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (12,'Charrue vigneronne','Socs en acier traité interchangeables;\n" +
                "Versoirs en tôle traitée interchangeables;\n" +
                "Carrelets de forme carré permettant plusieurs réglages;\n" +
                "Profondeur de Travail : 20 cm.','mat')");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (13,'Epandeur vigneron','Attelage 3 points;2 rangs réglables en largeur;\n" +
                "trémie surbaissée de 360 litres;\n" +
                "boîtier à renvoie d’angle;\n" +
                "cardan télescopique','mat')");
        //another cat
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (14,'Rotovateur','Attelage amovible avec chaîne et déportable sur les côtés – Boîtiers haute résistance – Hauteur de coupe réglable sur patins;\n" +
                "Système de coupe sur disque 3 couteaux 450x100x12;\n" +
                "Cardan muni d’un embrayage à friction','div')");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (15,'Tariere Portee','Réducteur à engrenage, rapport 3/1;\n" +
                "Vrille en acier traité;\n" +
                "Pointes de forage mécano soudé interchangeable;\n" +
                "Couteaux des spires en acier; 1 cardan.','div')");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (16,'Niveleuse orientable','Lame en acier traité; Lame orientable à 360°;\n" +
                "Utilisation en marche avant (tirage) ou en marche arrière (poussée).','div')");
        db.execSQL("INSERT INTO produits (id,title,description,cat) VALUES (17,'Niveleuse a dents','Outil présentant 3 positions de travail :\n" +
                "Scarificateur à dents – rigides – Lame niveleuse en marche arrière – Lame niveleuse en marche avant;\n" +
                "Lame en acier traité;\n" +
                "Socs en acier coulé.','div')");



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

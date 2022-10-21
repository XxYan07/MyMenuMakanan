package aplikasi.mobile.listviewimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Menu_Daftar_Makanan extends AppCompatActivity {

    ListView lvItem;
    EditText Edtcari;
    ListViewAdapterCall adapter;
    ArrayList<ListViewAdapterMenu> arraylist = new ArrayList<ListViewAdapterMenu>();

    int[] Gambar;
    String[] NamaItem;
    String[] HargaItem;
    String[] Deskripsi;
    String[] NomorHP;
    String[] Lat;
    String[] Long;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_daftar_makanan);

        lvItem		= (ListView)findViewById(R.id.listView1);
        Edtcari     = (EditText)findViewById(R.id.editText1);


        Gambar		= new int[]{
                R.mipmap.a_indomitelurkornet,
                R.mipmap.b_magelangan,
                R.mipmap.c_tahucampurlamongan,
                R.mipmap.d_rujakcingur,
                R.mipmap.e_spaghetticarbonara};

        NamaItem 	= new String[]{
                "Indomie Tekor",
                "Nasi Magelangan",
                "Tahu Lamongan",
                "Rujak Cingur",
                "Spaghetti"};

        HargaItem 	= new String[]{
                "Rp. 15.000",
                "Rp. 20.000",
                "Rp. 25.000",
                "Rp. 25.000",
                "Rp. 40.000"};

        Deskripsi 	= new String[]{
                "Indomie Tekor merupakan makanan kesukaan para kaum tanggal tua" +
                        " dengan harga yang murah",

                "Nasi Magelangan adalah makanan kesukaan para anak kost, karena" +
                        " di dalam magelangan terkandung banyak nasi dan mie yang mengenyangkan",

                "Tahu Lamongan ialah makanan favorit masyarakat" +
                        " Jawa timur. Isinya Terdapat tahu, mie, kecambah, kuah gurih, dan petis",

                "Rujak Cingur yaitu rujak yang isinya terdapat beberapa lauk"+
                        " seperti sayur-sayuran, cingur (hidung) sapi, dan dibumbui dengan petis",

                "Spaghetti Carbonara khas Italia yang Al Dente"};


        NomorHP  = new String[]{
                "+6285244749936",
                "+6285244749936",
                "+6285244749936",
                "+6285244749936",
                "+6285244749936"
        };

        Lat  = new String[]{
                "-7.0268812",
                "-7.0268812",
                "-7.0268812",
                "-7.0268812",
                "-7.0268812"
        };

        Long  = new String[]{
                "110.424669",
                "110.424669",
                "110.424669",
                "110.424669",
                "110.424669"
        };


        for (int i = 0; i < NamaItem.length; i++)
        {
            ListViewAdapterMenu wp = new ListViewAdapterMenu(NamaItem[i], HargaItem[i], Deskripsi[i], Gambar[i], NomorHP[i], Lat[i], Long[i]);
            arraylist.add(wp);
        }

        adapter = new ListViewAdapterCall(this, arraylist);
        lvItem.setAdapter(adapter);

        Edtcari.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                String text = Edtcari.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
                showToastMessage("Pencarian dilakukan");
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
        });

    }

    void showToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}

package test.tomek.com.cwiczenie2_umawianiewizyt;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;


public class Ekran4 extends ActionBarActivity {

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekran4);


        TextView pds = (TextView) findViewById(R.id.podsumowanie);
        DaneWizyty dane = (DaneWizyty) getIntent().getSerializableExtra("dane");

        StringBuilder raport = new StringBuilder();
        raport.append("Specjalizacja: <b>").append(dane.specjalizacja).append("</b>");



    }


}

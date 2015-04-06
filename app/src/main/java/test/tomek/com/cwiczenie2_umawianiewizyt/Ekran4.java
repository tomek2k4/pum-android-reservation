package test.tomek.com.cwiczenie2_umawianiewizyt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        raport.append("<p>");
        raport.append("Specjalizacja: <b>").append(dane.specjalizacja).append("</b>");
        raport.append("</p>");
        if(dane.czyPierwszyRaz)
        {
            raport.append("<p>");
            raport.append("<b>Jest to pierwsza wizyta u tego specjalisty</b>");
            raport.append("</p>");
        }

        raport.append("<p>").append("Wizyta od: <b>").append(DATE_FORMAT.format(dane.dataOd)).append("</b>").append("</p>");
        raport.append("<p>").append("Wizyta do: <b>").append(DATE_FORMAT.format(dane.dataDo)).append("</b>").append("</p>");
        raport.append("<p>").append("Twoj komentarz: <b>").append(dane.komentarz).append("</b>").append("</p>");


        pds.setText(Html.fromHtml(raport.toString()));

    }


    public void onResetButtonClick(View v){
        Log.d("Tomek","Reset button click'd");

        DaneWizyty dane = (DaneWizyty) getIntent().getSerializableExtra("dane");
        dane.clear();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        prefs.edit().putString("comment","");
        prefs.edit().clear().apply();

        Intent pierwszyEkran = new Intent(this,Ekran1.class);
        pierwszyEkran.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        pierwszyEkran.putExtra("dane",dane);

        startActivity(pierwszyEkran);
        finish();

    }

    public void onSendButtonClick(View v){
        Log.d("Tomek","Buttonb Send click'd");
        Toast.makeText(this,"Rezerwacja zostala wyslana",Toast.LENGTH_LONG).show();
    }


}

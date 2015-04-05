package test.tomek.com.cwiczenie2_umawianiewizyt;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;


public class Ekran1 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekran1);
    }


    public void onDalejClicked(View v){

        Spinner spec = (Spinner) findViewById(R.id.spinner_WyborSpecjalizacji);
        CheckBox pierwszaWizyta = (CheckBox) findViewById(R.id.checkBox_pierwszaWizyta);


        DaneWizyty dane = new DaneWizyty();

        dane.specjalizacja = (String) spec.getSelectedItem();
        dane.czyPierwszyRaz = (boolean) pierwszaWizyta.isChecked();

        Intent drugiEkran = new Intent(this,Ekran2.class);
        drugiEkran.putExtra("dane",dane);

        startActivity(drugiEkran);
    }

}

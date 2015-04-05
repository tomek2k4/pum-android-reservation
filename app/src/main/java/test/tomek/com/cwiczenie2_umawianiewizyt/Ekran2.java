package test.tomek.com.cwiczenie2_umawianiewizyt;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Ekran2 extends ActionBarActivity {


    private static final int DEFAULT_DATE_TO_OFFSET = 6;
    private DatePicker dataOdDatePicker;
    private DatePicker dataDoDatePicker;
    private Button buttonDalej;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekran2);

        dataOdDatePicker = (DatePicker) findViewById(R.id.dataOd);
        dataDoDatePicker = (DatePicker) findViewById(R.id.dataDo);
        buttonDalej = (Button) findViewById(R.id.button_DalejEkran2);

        Date dataOd = (Date) new Date( dataOdDatePicker.getCalendarView().getDate() );
        Date dataDo = addDaysToDate(dataOd,DEFAULT_DATE_TO_OFFSET);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Toast.makeText(this,sdf.format(dataDo),Toast.LENGTH_LONG).show();

        dataDoDatePicker.getCalendarView().setDate(dataDo.getTime());

    }

    public void onDalejButtonClicked(View view){
        Toast.makeText(this,"Dalej clicked",Toast.LENGTH_LONG);

        DaneWizyty dane = (DaneWizyty) getIntent().getSerializableExtra("dane");
        dane.dataOd = (Date)new Date( dataOdDatePicker.getCalendarView().getDate() );
        dane.dataDo = (Date)new Date( dataDoDatePicker.getCalendarView().getDate() );


        Log.d("Tomek","Data od: "+ new SimpleDateFormat("dd/MM/yyyy").format(dane.dataOd));
        Log.d("Tomek","Data do: "+ new SimpleDateFormat("dd/MM/yyyy").format(dane.dataDo));

        if(dane.dataOd.getTime() > dane.dataDo.getTime()){
            Toast.makeText(this,"Change date from to be earlier than to!",Toast.LENGTH_LONG).show();
        }else{
            Intent trzeciEkran = new Intent(this,Ekran3.class);
            trzeciEkran.putExtra("dane",dane);

            startActivity(trzeciEkran);
        }


    }


    private Date addDaysToDate(Date date, int daysToAdd){
        Date returnDate = new Date();
        
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, daysToAdd);

        returnDate = c.getTime();
        
        return returnDate;
    }


}

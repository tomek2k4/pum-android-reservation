package test.tomek.com.cwiczenie2_umawianiewizyt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class Ekran3 extends ActionBarActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekran3);

        prefs = this.getPreferences(MODE_PRIVATE);
        String restoredText = prefs.getString("comment", null);
        if (restoredText != null){
            EditText commentTextEdit = (EditText) findViewById(R.id.editText_commentWindow);
            commentTextEdit.setText(restoredText);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Tomek","onStop invocked");

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("comment", ((EditText)findViewById(R.id.editText_commentWindow)).getText().toString() );
        editor.apply();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public void onDalejEkran3Clicked(View v){
        Log.d("Tomek","onDalejEkran3 click'd");

        DaneWizyty dane = (DaneWizyty) getIntent().getSerializableExtra("dane");
        dane.komentarz = ((EditText)findViewById(R.id.editText_commentWindow)).getText().toString();

        Log.d("Tomek","Komentarz: "+dane.komentarz);

        Intent czwartyEkran = new Intent(this,Ekran4.class);
        czwartyEkran.putExtra("dane",dane);

        startActivity(czwartyEkran);
    }

}

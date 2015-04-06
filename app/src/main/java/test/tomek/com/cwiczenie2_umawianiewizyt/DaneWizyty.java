package test.tomek.com.cwiczenie2_umawianiewizyt;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tomek on 15.03.2015.
 */
public class DaneWizyty implements Serializable {
    public String specjalizacja;
    public boolean czyPierwszyRaz;
    public Date dataOd;
    public Date dataDo;
    public String komentarz;

    public void clear(){
        specjalizacja = "";
        czyPierwszyRaz = false;
        dataDo = new Date();
        dataDo = new Date();
        komentarz = "";
    }

}

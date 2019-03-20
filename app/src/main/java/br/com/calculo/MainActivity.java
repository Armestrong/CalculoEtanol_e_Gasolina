package br.com.calculo;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private static SeekBar seek_bar_gaso;
    private static SeekBar seek_bar_etano;
    private static TextInputEditText txt_resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekbarcalculo();

    }


    public void seekbarcalculo(){

    seek_bar_etano = (SeekBar)findViewById(R.id.Etanol);
    seek_bar_gaso = (SeekBar)findViewById(R.id.Gasolina);

    txt_resultado = (TextInputEditText)findViewById(R.id.result);

    seek_bar_gaso.setOnSeekBarChangeListener(

            new SeekBar.OnSeekBarChangeListener(){
                int vl_seekbar_gaso;
                int vl_seekbar_etano;

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        vl_seekbar_gaso = progress;
                        vl_seekbar_etano = progress;



                        if ((vl_seekbar_gaso / vl_seekbar_etano) <= 0.7){
                            txt_resultado.setText(R.string.txt_gaso);
                            int gasolina = R.drawable.gasolina;
                        }else {
                            txt_resultado.setText(R.string.txt_etano);
                            int eta = R.drawable.Etanol;
                        }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    if ((vl_seekbar_gaso / vl_seekbar_etano) <= 0.7){
                        txt_resultado.setText(R.string.txt_gaso);
                        int gasolina = R.drawable.gasolina;
                    }else {
                        txt_resultado.setText(R.string.txt_etano);
                        int eta = R.drawable.Etanol;
                    }

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                    if ((vl_seekbar_gaso / vl_seekbar_etano) <= 0.7){
                        txt_resultado.setText(R.string.txt_gaso);
                        int gasolina = R.drawable.gasolina;
                    }else {
                        txt_resultado.setText(R.string.txt_etano);
                        int eta = R.drawable.Etanol;
                    }
                }
            }

    );

    }
}

package edu.eseiaat.upc.pma.borreguero.daniel.kmamillasp;

import android.icu.text.DateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Boolean km_activo=false;
    Boolean millas_activo=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText edit_km=(EditText)findViewById(R.id.edit_km);
        final EditText edit_millas= (EditText) findViewById(R.id.edit_millas);

        edit_km.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (millas_activo) {
                     millas_activo= false;
                }
                else {
                    km_activo=true;
                    String skm=edit_km.getText().toString();
                    if (skm.matches(""))
                    {
                        skm="0";
                    }
                    float km=Float.parseFloat(skm);
                    float millas=km/1.609f;
                    String smillas=String.format("%f",millas);
                    edit_millas.setText(smillas);
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edit_millas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (km_activo) {
                    km_activo = false;
                }
                else {
                    millas_activo=true;
                    String smillas = edit_millas.getText().toString();
                    if (smillas.matches(""))
                    {
                        smillas="0";
                    }
                    float millas = Float.parseFloat(smillas);
                    float km = millas * 1.609f;
                    String skm = String.format("%f", km);
                    edit_km.setText(skm);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}

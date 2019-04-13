package carlos.robson.easyprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;


public class TelaCadProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cad_produto);
        final EditText valorMonetario = (EditText) findViewById(R.id.editTextValorProd);
        valorMonetario.addTextChangedListener(new MascaraMonetaria(valorMonetario));








        Button botaoVoltar = (Button) findViewById(R.id.buttonvoltarTCP);

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setContentView(R.layout.activity_main);
                Intent it = new Intent(TelaCadProduto.this, MainActivity.class);
                startActivity(it);
            }
        });




    }
    private class MascaraMonetaria implements TextWatcher{

        final EditText campo;

        private MascaraMonetaria(EditText campo) {
            super();
            this.campo = campo;
        }

        private boolean isUpdating = false;
        // Pega a formatacao do sistema, se for brasil R$ se EUA US$
        private NumberFormat nf = NumberFormat.getCurrencyInstance();



        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Evita que o método seja executado varias vezes.
            // Se tirar ele entre em loop
            if (isUpdating) {
                isUpdating = false;
                return;
        }

            isUpdating = true;
            String str = s.toString();
            // Verifica se já existe a máscara no texto.
            boolean hasMask = ((str.indexOf("R$ ") > -1 || str.indexOf("$") > -1) &&
                    (str.indexOf(".") > -1 || str.indexOf(",") > -1));
            // Verificamos se existe máscara
            if (hasMask) {
                // Retiramos a máscara.
                str = str.replaceAll("[R$]", "").replaceAll("[,]", "")
                        .replaceAll("[.]", "");
            }


            try {
                // Transformamos o número que está escrito no EditText em
                // monetário.
                str = nf.format(Double.parseDouble(str) / 100);
                campo.setText(str);
                campo.setSelection(campo.getText().length());
            } catch (NumberFormatException e) {
                s = "";
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int after) {
            //Não utilizado
        }

        @Override
        public void afterTextChanged(Editable s) {
            //Não utilizado
        }



    }

}


package carlos.robson.easyprice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoCadUsuario = (Button) findViewById(R.id.BotCadUsuario);

        botaoCadUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setContentView(R.layout.activity_telacadusuario);
                Intent it = new Intent(MainActivity.this, TelacadusuarioActivity.class);
                startActivity(it);
            }
        });



        Button botaoCadProduto = (Button) findViewById(R.id.BotCadProdu);
        Button botaoBuscaProd = (Button) findViewById(R.id.BotBuscaProd);
        Button botaoQualProd = (Button) findViewById(R.id.BotQualProd);
        Button botaoExibHisComp = (Button) findViewById(R.id.BotExibHisComp);
        Button botaoBuscMelhoOf = (Button) findViewById(R.id.BotBuscMelhOfer);
        Button botaoComparaPre = (Button) findViewById(R.id.BotComparPrec);
        Button botaoConfig = (Button) findViewById(R.id.BotConfig);
    }
}

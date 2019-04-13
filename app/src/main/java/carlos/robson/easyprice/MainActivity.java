package carlos.robson.easyprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoCadUsuario = (Button) findViewById(R.id.ButtCadastUsu);

        botaoCadUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setContentView(R.layout.activity_telacadusuario);
                Intent it = new Intent(MainActivity.this, TelacadusuarioActivity.class);
                startActivity(it);
            }
        });




        Button botaoCadProduto = (Button) findViewById(R.id.ButtCadastProd);

        botaoCadProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setContentView(R.layout.activity_telacadusuario);
                Intent it = new Intent(MainActivity.this, TelaCadProduto.class);
                startActivity(it);
            }
        });

        Button botaoBuscaProd = (Button) findViewById(R.id.ButtBuscaProd);
        Button botaoQualProd = (Button) findViewById(R.id.ButtQualifPro);
        Button botaoExibHisComp = (Button) findViewById(R.id.ButtExibiHist);
        Button botaoBuscMelhoOf = (Button) findViewById(R.id.ButtBuscMelhorOfer);
        Button botaoComparaPre = (Button) findViewById(R.id.ButtComparaPre);
        Button botaoConfig = (Button) findViewById(R.id.Buttconfiguracoes);
    }
}

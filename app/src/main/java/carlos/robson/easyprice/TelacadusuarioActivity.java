package carlos.robson.easyprice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelacadusuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telacadusuario);

        Button voltar = (Button) findViewById(R.id.buttvoltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setContentView(R.layout.activity_main);
                Intent it = new Intent(TelacadusuarioActivity.this, MainActivity.class);
                startActivity(it);
            }
        });



        Button confirmDados = (Button)findViewById(R.id.butomconfirmar);

    }
}

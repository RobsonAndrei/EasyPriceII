package carlos.robson.easyprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelacadusuarioActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telacadusuario);

        this.mViewHolder.telaCadUsu_editText_nomeCompletoUsuario = findViewById(R.id.telaCadUsuario_editText_nome);
        this.mViewHolder.telaCadUsu_editText_email = findViewById(R.id.telaCadUsuario_editText_email);
        this.mViewHolder.telaCadUsu_editText_cpf = findViewById(R.id.telaCadUsuario_editText_cpf);
        this.mViewHolder.telaCadUsu_editText_nomeUsuario = findViewById(R.id.telaCadUsuario_editText_nomeUsuario);
        this.mViewHolder.telaCadUsu_editText_senha = findViewById(R.id.telaCadUsuario_editText_senha);
        this.mViewHolder.telaCadUsu_editText_confirSenha = findViewById(R.id.telaCadUsuario_editText_confirmasenha);

        this.mViewHolder.telaCadUsu_button_confirmar = findViewById(R.id.telaCadUsuario_button_confirmar);


        this.mViewHolder.telaCadUsu_button_voltar = findViewById(R.id.telaCadUsuario_button_voltar);
        this.mViewHolder.telaCadUsu_button_voltar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.telaCadUsuario_button_voltar) {
            Intent it = new Intent(TelacadusuarioActivity.this, MainActivity.class);
            startActivity(it);
        }
    }


    private static class ViewHolder {
        EditText telaCadUsu_editText_nomeCompletoUsuario;
        EditText telaCadUsu_editText_email;
        EditText telaCadUsu_editText_cpf;
        EditText telaCadUsu_editText_nomeUsuario;
        EditText telaCadUsu_editText_senha;
        EditText telaCadUsu_editText_confirSenha;

        Button telaCadUsu_button_voltar;
        Button telaCadUsu_button_confirmar;

    }

}

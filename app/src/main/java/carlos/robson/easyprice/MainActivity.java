package carlos.robson.easyprice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import carlos.robson.easyprice.Service.AcessoRest;
import carlos.robson.easyprice.Sessao.SessaoUsuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private AlertDialog alert;
    AcessoRest ar = new AcessoRest();
    JSONObject jsonLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        alert = new AlertDialog.Builder(MainActivity.this).create();
        alert.setTitle("");
        alert.setMessage("");
        alert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.login_textView_email = findViewById(R.id.login_textView_email);
        this.mViewHolder.login_textView_senha = findViewById(R.id.login_textView_senha);
        this.mViewHolder.login_button_logar = findViewById(R.id.login_button_entrar);

        this.mViewHolder.login_button_novoUsuario = findViewById(R.id.login_button_cadastrar);
        this.mViewHolder.login_button_novoUsuario.setOnClickListener(this);
        this.mViewHolder.login_button_logar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_button_cadastrar) {

            //Redireciona para a tela de cadastro do usuário
             Intent it = new Intent(MainActivity.this, TelaCadUsuarioActivity.class);
             startActivity(it);
        } else if (v.getId() == R.id.login_button_entrar) {

            String email = mViewHolder.login_textView_email.getText().toString();
            String senha = mViewHolder.login_textView_senha.getText().toString();

            if(email.isEmpty()){
                alert.setTitle("Atenção");
                alert.setMessage("Campo EMAIL não informado");
                alert.show();
            } else if(senha.isEmpty()){
                alert.setTitle("Atenção");
                alert.setMessage("Campo SENHA não informado");
                alert.show();
            } else {

                String[] login = {email, senha};

                String resposta = ar.login(login);

                if (resposta.isEmpty()) {
                    alert.setTitle("Atenção");
                    alert.setMessage("Credenciais de acesso incorretas!");
                    alert.show();
                } else {

                    try {
                        JSONObject jsonUsuario = new JSONObject(resposta);

                        SessaoUsuario sessaoUsuario = new SessaoUsuario(email, jsonUsuario.getString("cpf"));

                        Intent it = new Intent(MainActivity.this, MenuActivity.class);
                        startActivity(it);

                    }catch(JSONException jex){
                        System.out.println("Excecao json: " + jex.getMessage());
                    }
                        Intent it = new Intent(MainActivity.this, MenuActivity.class);
                        startActivity(it);

                }
            }
        }
    }

    private static class ViewHolder {
        EditText login_textView_email;
        EditText login_textView_senha;
        Button login_button_logar;
        Button login_button_novoUsuario;


    }


}

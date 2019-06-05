package carlos.robson.easyprice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import carlos.robson.easyprice.Service.AcessoRest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private ViewHolder mViewHolder = new ViewHolder();
    private AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AcessoRest ar = new AcessoRest();

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
        this.mViewHolder.login_button_logar = findViewById(R.id.login_button_logar);

        this.mViewHolder.login_button_novoUsuario = findViewById(R.id.login_button_novoUsuario);
        this.mViewHolder.login_button_novoUsuario.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_button_novoUsuario) {

           // System.out.println("CLICOUUUU");
           // AcessoRest ar = new AcessoRest();

            //String caminhoURL = "http://54.232.197.19:8080/ApiEasyPrice/api/usuario";

            //String responseAgora = ar.get(caminhoURL);

            //alert.setMessage(responseAgora);

            //alert.show();

            //System.out.println("RESULTADO: " + responseAgora.toString());
            //Log.i("RESPOSTA: ", responseAgora);

            setContentView(R.layout.activity_telacadusuario);
             Intent it = new Intent(MainActivity.this, TelaCadUsuarioActivity.class);
             startActivity(it);
        }
        if (v.getId() == R.id.login_button_logar) {
            //lógica da operação
        }


    }

    private static class ViewHolder {
        EditText login_textView_email;
        EditText login_textView_senha;
        Button login_button_logar;
        Button login_button_novoUsuario;


    }


}

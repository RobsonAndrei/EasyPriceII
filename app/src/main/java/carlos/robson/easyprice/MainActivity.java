package carlos.robson.easyprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


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

            //setContentView(R.layout.activity_telacadusuario);
            Intent it = new Intent(MainActivity.this, TelacadusuarioActivity.class);
            startActivity(it);
        }


    }

    private static class ViewHolder {
        EditText login_textView_email;
        EditText login_textView_senha;
        Button login_button_logar;
        Button login_button_novoUsuario;


    }


}

package carlos.robson.easyprice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.SQLException;

import carlos.robson.easyprice.Service.AcessoRest;

//import carlos.robson.easyprice.Controle.FachadaController;
//import carlos.robson.easyprice.Dominio.Usuario;
//import carlos.robson.easyprice.Utilitario.Utils;

public class TelaCadUsuarioActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    private AlertDialog alert;
    private AcessoRest acessoRest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telacadusuario);

        this.mViewHolder.telaCadUsu_editText_nomeCompletoUsuario = findViewById(R.id.telaCadUsuario_editText_nome);
        this.mViewHolder.telaCadUsu_editText_email = findViewById(R.id.telaCadUsuario_editText_email);
        this.mViewHolder.telaCadUsu_editText_cpf = findViewById(R.id.telaCadUsuario_editText_cpf);
        this.mViewHolder.telaCadUsu_editText_idade = findViewById(R.id.telaCadUsuario_editText_idade);
        this.mViewHolder.telaCadUsu_editText_senha = findViewById(R.id.telaCadUsuario_editText_senha);
        this.mViewHolder.telaCadUsu_editText_confirSenha = findViewById(R.id.telaCadUsuario_editText_confirmasenha);
        this.mViewHolder.telaCadUsu_editText_fxSalarial = findViewById(R.id.telaCadUsuario_editText_fxsalarial);

        this.mViewHolder.telaCadUsu_button_confirmar = findViewById(R.id.telaCadUsuario_button_confirmar);

        this.mViewHolder.telaCadUsu_button_voltar = findViewById(R.id.telaCadUsuario_button_voltar);
        this.mViewHolder.telaCadUsu_button_confirmar.setOnClickListener(this);

        //Instanciando o alert
        alert = new AlertDialog.Builder(TelaCadUsuarioActivity.this).create();
        alert.setTitle("Sucesso");
        alert.setMessage("Usuário cadastrado");
        alert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
    }

    public void onClick(View v) {

        if (v.getId() == R.id.telaCadUsuario_button_voltar) {
            Intent it = new Intent(TelaCadUsuarioActivity.this, MainActivity.class);
            startActivity(it);

            System.out.println("Entrou no primeiro if");
        } else if (v.getId() == R.id.telaCadUsuario_button_confirmar) {

            String cpf = mViewHolder.telaCadUsu_editText_cpf.getText().toString();
            String nome = mViewHolder.telaCadUsu_editText_nomeCompletoUsuario.getText().toString();
            String email = mViewHolder.telaCadUsu_editText_email.getText().toString();
            String senha = mViewHolder.telaCadUsu_editText_senha.getText().toString();
            String idade = mViewHolder.telaCadUsu_editText_idade.getText().toString();
            String salario = mViewHolder.telaCadUsu_editText_fxSalarial.getText().toString();

            acessoRest = new AcessoRest();

            String objetos[] = {cpf, nome, idade, email, salario, senha};

            String response = acessoRest.postUsuario(objetos);

            alert.setMessage(response);

            alert.show();
           /*boolean cpfValido = utils.validarCpf(cpf);

            if(!cpfValido){
                alert.setTitle("Atenção");
                alert.setMessage("O CPF informado não é válido.");
                alert.show();
                return;
            }*/
        }
    }


    private static class ViewHolder {

        EditText telaCadUsu_editText_nomeCompletoUsuario;
        EditText telaCadUsu_editText_email;
        EditText telaCadUsu_editText_cpf;
        EditText telaCadUsu_editText_idade;
        EditText telaCadUsu_editText_senha;
        EditText telaCadUsu_editText_confirSenha;
        EditText telaCadUsu_editText_fxSalarial;
        Button telaCadUsu_button_voltar;
        Button telaCadUsu_button_confirmar;

    }
}

package carlos.robson.easyprice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.InputMismatchException;
import carlos.robson.easyprice.Service.AcessoRest;
import carlos.robson.easyprice.Sessao.SessaoUsuario;

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

        } else if (v.getId() == R.id.telaCadUsuario_button_confirmar) {

            String cpf = mViewHolder.telaCadUsu_editText_cpf.getText().toString();
            String nome = mViewHolder.telaCadUsu_editText_nomeCompletoUsuario.getText().toString();
            String email = mViewHolder.telaCadUsu_editText_email.getText().toString();
            String senha = mViewHolder.telaCadUsu_editText_senha.getText().toString();
            String confirmaSenha = mViewHolder.telaCadUsu_editText_confirSenha.getText().toString();
            String idade = mViewHolder.telaCadUsu_editText_idade.getText().toString();
            String salario = mViewHolder.telaCadUsu_editText_fxSalarial.getText().toString();

            if(nome.isEmpty()){
                alert.setTitle("Atenção");
                alert.setMessage("Campo NOME não informado");
                alert.show();
            } else if(email.isEmpty()){
                alert.setTitle("Atenção");
                alert.setMessage("Campo EMAIL não informado");
                alert.show();
            } else if(cpf.isEmpty()) {
                alert.setTitle("Atenção");
                alert.setMessage("Campo CPF não informado");
                alert.show();
            } else if(!isCPF(cpf)) {
                alert.setTitle("Atenção");
                alert.setMessage("O CPF informado não é válido");
                alert.show();
            } else if(idade.isEmpty()){
                alert.setTitle("Atenção");
                alert.setMessage("Campo IDADE não informado");
                alert.show();
            } else if(senha.isEmpty()){
                alert.setTitle("Atenção");
                alert.setMessage("Campo SENHA não informado");
                alert.show();
             } else if(confirmaSenha.isEmpty()) {
                alert.setTitle("Atenção");
                alert.setMessage("Campo CONFIRMAR SENHA não informado");
                alert.show();
            }else if(salario.isEmpty()){
                alert.setTitle("Atenção");
                alert.setMessage("Campo FAIXA SALARIAL não informado");
                alert.show();

            } else if(!confirmaSenha.equals(senha)){
                alert.setTitle("Atenção");
                alert.setMessage("As senhas devem ser iguais");
                alert.show();
            } else {

                acessoRest = new AcessoRest();

                String objetos[] = {cpf, nome, idade, email, salario, senha};

                String response = acessoRest.postUsuario(objetos);

               System.out.println("RESPONSE AQ: " + response);

                switch (response) {

                    case "1":
                        alert.setTitle("Sucesso");
                        alert.setMessage("Cadastro efetuado com sucesso");
                        alert.show();

                        final Intent it = new Intent(TelaCadUsuarioActivity.this, MenuActivity.class);

                        SessaoUsuario sessao = new SessaoUsuario(email, cpf);

                        alert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        startActivity(it);
                                        ;
                                    }
                                });
                        break;
                    case "-1":
                        alert.setTitle("Erro");
                        alert.setMessage("Este email já está sendo usado por outra conta");
                        alert.show();
                        break;
                    case "-2":
                        alert.setTitle("Erro");
                        alert.setMessage("CPF já cadastrado");
                        alert.show();
                        break;
                }
            }
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

    public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }
}

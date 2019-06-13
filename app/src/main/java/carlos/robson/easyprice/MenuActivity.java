package carlos.robson.easyprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import carlos.robson.easyprice.Sessao.SessaoUsuario;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        System.out.println("Email logado: " + SessaoUsuario.getEmailUsuarioLogado());
        System.out.println("Cpf logado: " + SessaoUsuario.getCpfUsuarioLogado());

        //this.mViewHolder.menu_button_buscaProduto = findViewById(R.id.menu_button_buscarProduto);
        //this.mViewHolder.menu_button_buscarMoferta = findViewById(R.id.menu_button_buscarMelhorOferta);
        //this.mViewHolder.menu_button_cadastrProduto.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.menu_button_buscarProduto) {
            Intent it = new Intent(MenuActivity.this, TelaBuscarProduto.class);
            startActivity(it);
        } else if(v.getId() == R.id.menu_button_cadastrarProduto){
            Intent it = new Intent(MenuActivity.this, TelaCadProdutoActivity.class);
            startActivity(it);
        } else if(v.getId()== R.id.menu_button_buscarMelhorOferta){
           // Intent it = new Intent(MenuActivity.this, TelaBuscarMelhorOfertaActivity.this);
           // startActivity(it);
        } else if(v.getId() == R.id.menu_button_comparaPrecos){
           // Intent it = new Intent(MenuActivity.this, TelaCadProdutoActivity.class);
          //  startActivity(it);
        } else if(v.getId()== R.id.menu_button_exibHist){
          //  Intent it = new Intent(MenuActivity.this, TelaCadProdutoActivity.class);
          //  startActivity(it);
        } else if(v.getId()==R.id.menu_button_qualificarProduto){
         //   Intent it = new Intent(MenuActivity.this, TelaCadProdutoActivity.class);
         //   startActivity(it);
        }
    }

    private static class ViewHolder {

        Button menu_button_cadastrProduto;
        Button menu_button_buscaProduto;
        Button menu_button_buscarMoferta;

    }
}

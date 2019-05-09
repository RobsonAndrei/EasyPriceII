package carlos.robson.easyprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class TelaCadProduto extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cad_produto);

        this.mViewHolder.telaCadProduto_editText_nomeProduto = findViewById(R.id.telacadProduto_editText_nomeProduto);
        this.mViewHolder.telaCadProduto_editText_categoria = findViewById(R.id.telacadProduto_editText_categoria);
        this.mViewHolder.telaCadProduto_editText_nomeMercado = findViewById(R.id.telacadProduto_editText_nomeMercado);
        this.mViewHolder.telaCadProduto_editText_enderecoMercado = findViewById(R.id.telacadProduto_editText_enderecomercado);
        this.mViewHolder.telaCadProduto_editText_valorProduto = findViewById(R.id.telacadProduto_editText_valorProduto);

        this.mViewHolder.telacadProduto_button_confirma = findViewById(R.id.telacadProduto_button_confirmar);
        this.mViewHolder.telacadProduto_button_voltar = findViewById(R.id.telacadProduto_button_voltar);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.telacadProduto_button_voltar) {
            Intent it = new Intent(TelaCadProduto.this, MenuActivity.class);
            startActivity(it);
        }

    }

    private static class ViewHolder {
        EditText telaCadProduto_editText_nomeProduto;
        EditText telaCadProduto_editText_categoria;
        EditText telaCadProduto_editText_nomeMercado;
        EditText telaCadProduto_editText_enderecoMercado;
        EditText telaCadProduto_editText_valorProduto;
        Button telacadProduto_button_confirma;
        Button telacadProduto_button_voltar;


    }


}
















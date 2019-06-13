package carlos.robson.easyprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

import carlos.robson.easyprice.Service.AcessoRest;
import carlos.robson.easyprice.Utils.MaskEditUtil;


public class TelaCadProdutoActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private ArrayList<String> categoria = new ArrayList<>();
    private ArrayList<String> supermercado = new ArrayList<>();

    HashMap<String, String> mapCategoria = new HashMap<>();
    HashMap<String, String> mapSupermercado = new HashMap<>();

    private AcessoRest acessoRest = new AcessoRest();
    private Spinner mSpinnerCategoria;
    private Spinner mSpinnerSupermercado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cad_produto);

        //EditText
        mViewHolder.telaCadProduto_editText_nomeProduto = findViewById(R.id.cadproduto_textView_nome);
        mViewHolder.telaCadProduto_editText_preco = findViewById(R.id.cadproduto_textView_preco);
        mViewHolder.telaCadProduto_editText_dataValidade = findViewById(R.id.cadproduto_textView_validade);
        mViewHolder.telacadProduto_button_confirma = findViewById(R.id.telacadProduto_button_confirmar);

        //Botões
        this.mViewHolder.telacadProduto_button_confirma = findViewById(R.id.telacadProduto_button_confirmar);
        this.mViewHolder.telacadProduto_button_voltar = findViewById(R.id.telacadProduto_button_voltar);

        //Aplicando máscara
        mViewHolder.telaCadProduto_editText_dataValidade.addTextChangedListener(MaskEditUtil.mask(mViewHolder.telaCadProduto_editText_dataValidade, MaskEditUtil.FORMAT_DATE));

        String categorias = acessoRest.get("http://54.232.197.19:8080/EasyPrice/api/categoriaproduto");
        String supermercados = acessoRest.get("http://54.232.197.19:8080/EasyPrice/api/supermercado");

        try {
            JSONArray arrayCategorias = new JSONArray(categorias);
            JSONArray arraySupermercados = new JSONArray(supermercados);

            categoria.add("Selecione...");
            supermercado.add("Selecione...");

            for(int i = 0; i < arrayCategorias.length(); i++){
                JSONObject objetoJsonCategoria = (arrayCategorias.getJSONObject(i));
                categoria.add(objetoJsonCategoria.getString("nome"));
                mapCategoria.put(objetoJsonCategoria.getString("nome"), objetoJsonCategoria.getString("id_categoria"));
            }

            for(int i = 0; i < arraySupermercados.length(); i++){
                JSONObject objetoJsonSupermercado = (arraySupermercados.getJSONObject(i));
                supermercado.add(objetoJsonSupermercado.getString("nome"));
                mapSupermercado.put(objetoJsonSupermercado.getString("nome"), objetoJsonSupermercado.getString("id"));
            }
        }
        catch(Exception e){
            System.out.println("Excecao: " + e.getLocalizedMessage());
        }

        mSpinnerCategoria = findViewById(R.id.cadproduto_spinner_categoria);
        mSpinnerSupermercado = findViewById(R.id.cadproduto_spinner_supermercado);

        ArrayAdapter arrayAdapterCategoria = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categoria);
        arrayAdapterCategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter arrayAdapterSupermercado = new ArrayAdapter(this, android.R.layout.simple_spinner_item, supermercado);
        arrayAdapterSupermercado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinnerCategoria.setAdapter(arrayAdapterCategoria);
        mSpinnerSupermercado.setAdapter(arrayAdapterSupermercado);


        mViewHolder.telacadProduto_button_confirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chaveCategoria = mSpinnerCategoria.getSelectedItem().toString();
                String chaveSupermercado = mSpinnerSupermercado.getSelectedItem().toString();
                //Toast.makeText(getApplicationContext(), "Item escolhido: " + mapCategoria.get(id_categoria) + " " + mapSupermercado.get(id_supermercado), Toast.LENGTH_SHORT).show();
                String nomeProduto = mViewHolder.telaCadProduto_editText_nomeProduto.getText().toString();
                String id_categoria = mapCategoria.get(chaveCategoria);
                String id_supermercado = mapSupermercado.get(chaveSupermercado);
                String preco = mViewHolder.telaCadProduto_editText_preco.getText().toString();
                String dataValidade = mViewHolder.telaCadProduto_editText_dataValidade.getText().toString();

                String []objetos = {nomeProduto, id_categoria, id_supermercado, preco, dataValidade};


            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.telacadProduto_button_voltar) {
            Intent it = new Intent(TelaCadProdutoActivity.this, MenuActivity.class);
            startActivity(it);
        }
    }

    private static class ViewHolder {

        EditText telaCadProduto_editText_nomeProduto;
        EditText telaCadProduto_editText_preco;
        EditText telaCadProduto_editText_dataValidade;
        Button telacadProduto_button_confirma;
        Button telacadProduto_button_voltar;
    }
}
















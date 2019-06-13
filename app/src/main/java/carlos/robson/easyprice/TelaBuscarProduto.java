package carlos.robson.easyprice;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import carlos.robson.easyprice.Service.AcessoRest;

public class TelaBuscarProduto  extends AppCompatActivity implements View.OnClickListener {

    AlertDialog alert;
    Spinner mSpinner;
    ArrayList<String> categoria = new ArrayList<>();
    HashMap<String, String> itens = new HashMap<>();
    AcessoRest acessoRest = new AcessoRest();
    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_produto);

        String resultado = acessoRest.get("http://54.232.197.19:8080/EasyPrice/api/categoriaproduto");

        System.out.println("Resultado do GET " + resultado);

        try {
            JSONArray arrayJson = new JSONArray(resultado);

            categoria.add("Selecione...");

            for(int i = 0; i < arrayJson.length(); i++){
                JSONObject objetoJson = (arrayJson.getJSONObject(i));
                categoria.add(objetoJson.getString("nome"));
            }
        }
        catch(Exception e){
            System.out.println("Excecao: " + e.getLocalizedMessage());
        }

        mSpinner = findViewById(R.id.spinner);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categoria);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner.setAdapter(arrayAdapter);

        alert = new AlertDialog.Builder(TelaBuscarProduto.this).create();
        alert.setTitle("Sucesso");
        alert.setMessage("Usuário cadastrado");
        alert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        this.mViewHolder.telaBuscaProduto_editText_nome = findViewById(R.id.busca_campo_nome);
        this.mViewHolder.telaBuscaProduto_editText_preco = findViewById(R.id.busca_campo_precoProduto);

        this.mViewHolder.telaBuscaProduto_button_buscar = findViewById(R.id.busca_button_buscarProduto);
    }

    public void onClick(View v) {

        if(v.getId() == R.id.busca_button_buscarProduto){
            //logica para buscar produto

        }

    }

    private static class ViewHolder {

        EditText telaBuscaProduto_editText_nome;
        EditText telaBuscaProduto_editText_preco;
        Button telaBuscaProduto_button_buscar;

    }

}

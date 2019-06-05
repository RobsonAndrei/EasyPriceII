package carlos.robson.easyprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.mViewHolder.menu_button_buscaProduto = findViewById(R.id.menu_button_buscarProduto);
        this.mViewHolder.menu_button_buscarMoferta = findViewById(R.id.menu_button_buscarMelhorOferta);
        this.mViewHolder.menu_button_cadastrProduto.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.menu_button_cadastrarProduto) {
            Intent it = new Intent(MenuActivity.this, TelaCadProdutoActivity.class);
            startActivity(it);

        }

    }

    private static class ViewHolder {

        Button menu_button_cadastrProduto;
        Button menu_button_buscaProduto;
        Button menu_button_buscarMoferta;


    }
}

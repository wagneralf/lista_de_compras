package wagner_e_nivaldo.listadecompras;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {

    ArrayList<Itens> itens = new ArrayList<Itens>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        if(savedInstanceState != null)
            itens= (ArrayList<Itens>)savedInstanceState.getSerializable("salvaitens");
        else
            itens=new ArrayList<Itens>();

        TextView txt_nomelista =(TextView)findViewById(R.id.final_nomelista);
        Bundle args = getIntent().getExtras();
        String nomelista = args.getString("nomedalista");
        txt_nomelista.setText(nomelista);

        String[] categorias={"Categoria","Alimentícios","Perfumaria","Limpeza","Utensílios"};
        final Spinner sp=(Spinner)findViewById(R.id.final_categoria);
        final ArrayAdapter<String> adapter_sp = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categorias){

            @Override
            public boolean isEnabled(int position){
                if(position == 0){
                    // Disabilita a primeira posição (hint)
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Deixa o hint com a cor cinza ( efeito de desabilitado)
                    tv.setTextColor(Color.GRAY);
                }else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter_sp.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sp.setAdapter(adapter_sp);

        ListView lista = (ListView)findViewById(R.id.final_lista);
        final ArrayAdapter adapter_lista = new ItensAdapter(this,R.layout.linha,itens);
        lista.setAdapter(adapter_lista);

        Button adicionar =(Button)findViewById(R.id.final_add);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    TextView txt_nomeprod = (TextView) findViewById(R.id.final_nomeprod);
                    TextView txt_quantidade = (TextView) findViewById(R.id.final_quantidade);
                    CheckBox chk_perecivel = (CheckBox) findViewById(R.id.final_perecivel);
                    String nomeprod = txt_nomeprod.getText().toString();
                    int quantidade = Integer.parseInt(txt_quantidade.getText().toString());
                    boolean perecivel = chk_perecivel.isChecked();
                    String categoria = sp.getSelectedItem().toString();
                    if (sp.getSelectedItemPosition() == 0) {
                        alert("Por favor, selecione uma categoria");
                    } else {
                        Itens item = new Itens(nomeprod, quantidade, categoria, perecivel);
                        itens.add(item);
                        adapter_lista.notifyDataSetChanged();
                        chk_perecivel.setChecked(false);
                        txt_nomeprod.setText("");
                        txt_quantidade.setText("");
                        sp.setSelection(0);
                    }
                }
                catch (Exception x) {
                    alert(x.toString());
                }
            }
        });
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("salvaitens", itens);
        super.onSaveInstanceState(outState);
    }
    private void alert(String msg){

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}

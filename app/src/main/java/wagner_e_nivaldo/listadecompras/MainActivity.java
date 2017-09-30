package wagner_e_nivaldo.listadecompras;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button entrar =(Button)findViewById(R.id.main_entrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    TextView txt_nome = (TextView) findViewById(R.id.main_nome);
                    String nome = txt_nome.getText().toString();
                    Intent it = new Intent(getContext(), FinalActivity.class);
                    Bundle params = new Bundle();
                    params.putString("nomedalista", nome);
                    it.putExtras(params);
                    startActivity(it);
                }
                catch (Exception x)
                {
                    Toast.makeText(getContext(),x.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Context getContext(){ return this;}
}

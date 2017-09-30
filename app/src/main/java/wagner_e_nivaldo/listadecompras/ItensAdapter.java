package wagner_e_nivaldo.listadecompras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Wagner on 30/09/2017.
 */

public class ItensAdapter extends ArrayAdapter<Itens> {
    Context contexto;
    ArrayList<Itens> itens;
    public ItensAdapter(Context cx, int resource, ArrayList<Itens> objects){
        super(cx,resource,objects);
        this.contexto=cx;
        this.itens=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View linhaView = LayoutInflater.from(contexto).inflate(R.layout.linha, parent, false);
        TextView txt_nome = (TextView) linhaView.findViewById(R.id.linha_nome);
        TextView txt_quantidade = (TextView) linhaView.findViewById(R.id.linha_quantidade);
        TextView txt_categoria = (TextView) linhaView.findViewById(R.id.linha_categoria);
        TextView txt_perecivel = (TextView) linhaView.findViewById(R.id.linha_perecivel);

        txt_nome.setText("Nome: " + itens.get(position).getNome());
        txt_quantidade.setText("Quantidade: " + itens.get(position).getQuantidade());
        txt_categoria.setText("Categoria: " + itens.get(position).getCategoria());

        boolean bool_perecivel = itens.get(position).isPerecivel();
        if (bool_perecivel)
            txt_perecivel.setText("Produto Perecivel: Sim");
        else
            txt_perecivel.setText("Produto Perecivel: Não");

        return linhaView;
    }
}

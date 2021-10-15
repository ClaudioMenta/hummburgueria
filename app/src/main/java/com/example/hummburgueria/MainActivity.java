package com.example.hummburgueria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantidade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void somar(View view) {
        quantidade = quantidade + 1;
        displayQuantidade(quantidade);
    }

    public void subtrair(View view) {
        quantidade = quantidade - 1;
        displayQuantidade(quantidade);
    }

    public void displayQuantidade(int qtd) {
        TextView qtdTextView = (TextView) findViewById(R.id.quantidade_tv);
        qtdTextView.setText("" + qtd);
    }

    public String criarMensagemPedido(String nome, int valor, boolean temBacon, boolean temQueijo, boolean temSalada) {
        String mensagem = "Nome: " + nome;
        mensagem += "\nBacon? " + temBacon;
        mensagem += "\nQueijo? " + temQueijo;
        mensagem += "\nSalada? " + temSalada;
        mensagem += "\n\nTotal: R$" + valor;
        return(mensagem);
    }

    public void enviarPedido(View view) {
        EditText campoNome = (EditText) findViewById(R.id.campo_nome);
        String nome = campoNome.getText().toString();

        CheckBox checkBoxBacon = (CheckBox) findViewById(R.id.bacon);
        boolean temBacon = checkBoxBacon.isChecked();

        CheckBox checkBoxQueijo = (CheckBox) findViewById(R.id.queijo);
        boolean temQueijo = checkBoxQueijo.isChecked();

        CheckBox checkBoxSalada = (CheckBox) findViewById(R.id.salada);
        boolean temSalada = checkBoxSalada.isChecked();

        int valor = calculaPreco(temBacon, temSalada, temQueijo);

        String pedido = criarMensagemPedido(nome, valor, temBacon, temQueijo, temSalada);

        displayPedido(pedido);

    }

    public void displayPedido(String pedido) {
        TextView pedidoTextView = (TextView) findViewById(R.id.resumo_pedido);
        pedidoTextView.setText(pedido);
    }


    public int calculaPreco(boolean temBacon, boolean temQueijo, boolean temSalada) {
        int precoBase = 20;

        if(temBacon)
                precoBase += 4;
        if(temQueijo)
                precoBase += 3;
        if(temSalada)
                precoBase += 2;
        return precoBase*quantidade;
    }
}
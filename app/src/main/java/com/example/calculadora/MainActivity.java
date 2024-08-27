package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.calculadora.R;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete,
            numeroOito, numeroNove, ponto, soma, subtracao, mulplicacao, divisao, igual, botao_limpar, backSpace;

    private TextView txtExpressao, txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IniciarComponentes();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        mulplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        igual.setOnClickListener(this);
        botao_limpar.setOnClickListener(this);
        //txtExpressao.setOnClickListener(this);
        //txtResultado.setOnClickListener(this);
        backSpace.setOnClickListener(this);

        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();
                if (!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtEspressao = string.substring(var0,var1);
                    expressao.setText(txtEspressao);
                }
                txtResultado.setText("");
            }
        });
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Expression  expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado==(double) longResult){
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    }else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }


            }
        });
    }

    private void IniciarComponentes(){
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subitracao);
        mulplicacao = findViewById(R.id.mutiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backSpace = findViewById(R.id.backSpace);
    }

    public void AcrescentarUmaExpressao(String string, boolean limpar_dados) {
        if (txtResultado.getText().equals("")) {
            txtExpressao.setText(" ");
        }
        if (limpar_dados) {
            txtResultado.setText(" ");
            txtExpressao.append(string);
        } else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.numero_zero) {
            AcrescentarUmaExpressao("0", true);
        } else if (id == R.id.numero_um) {
            AcrescentarUmaExpressao("1", true);
        } else if (id == R.id.numero_dois) {
            AcrescentarUmaExpressao("2", true);
        } else if (id == R.id.numero_tres) {
            AcrescentarUmaExpressao("3", true);
        } else if (id == R.id.numero_quatro) {
            AcrescentarUmaExpressao("4", true);
        } else if (id == R.id.numero_cinco) {
            AcrescentarUmaExpressao("5", true);
        } else if (id == R.id.numero_seis) {
            AcrescentarUmaExpressao("6", true);
        } else if (id == R.id.numero_sete) {
            AcrescentarUmaExpressao("7", true);
        } else if (id == R.id.numero_oito) {
            AcrescentarUmaExpressao("8", true);
        } else if (id == R.id.numero_nove) {
            AcrescentarUmaExpressao("9", true);
        } else if (id == R.id.ponto) {
            AcrescentarUmaExpressao(".", true);
        } else if (id == R.id.soma) {
            AcrescentarUmaExpressao("+", true);
        } else if (id == R.id.subitracao) {
            AcrescentarUmaExpressao("-", true);
        } else if (id == R.id.mutiplicacao) {
            AcrescentarUmaExpressao("*", true);
        } else if (id == R.id.divisao) {
            AcrescentarUmaExpressao("/", true);
        } else if (id == R.id.igual) {
            // Coloque aqui a lógica para realizar o cálculo
        } else if (id == R.id.bt_limpar) {
            txtExpressao.setText("");
            txtResultado.setText("");
        } else if (id == R.id.backSpace) {
            // Lógica para apagar o último caractere
        }
    }
}

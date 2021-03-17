package com.example.calculatrice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

//import android.content.Context;


public class MainActivity extends AppCompatActivity {

    boolean checkbraquet = true ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         //

        //Button's
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 =  findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 =  findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);
        Button num0 = findViewById(R.id.num0);

        //operation's
        Button addition = findViewById(R.id.addition);
        Button division = findViewById(R.id.division);
        Button soustraction = findViewById(R.id.soustraction);
        Button multiplication= findViewById(R.id.multiplication);
        Button virgule= findViewById(R.id.virgule);
        Button delete = findViewById(R.id.delete);
        Button reset= findViewById(R.id.reset);
        Button pourcentage= findViewById(R.id.pourcentage);
        Button braquet = findViewById(R.id.braquet);
        Button equal = findViewById(R.id.equal);

        //Text Views
        TextView result= findViewById(R.id.result);
        TextView operation= findViewById(R.id.operation);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               operation.setText("");
               result.setText("0");
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {
           String process= operation.getText().toString();
          operation.setText(process+"0");
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"1");
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"2");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"3");
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"4");
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"5");
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"6");
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"7");
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"8");
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"9");
            }
        });
        virgule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+",");
            }
        });
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"+");
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"x");
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"÷");
            }
        });
        soustraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"-");
            }
        });
        pourcentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String process= operation.getText().toString();
                operation.setText(process+"%");
            }
        });

        braquet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkbraquet){
                    String process = operation.getText().toString();
                    operation.setText(process + "(" );
                    checkbraquet = false ;
                }else{
                    String process = operation.getText().toString();
                    operation.setText(process + ")" );
                    checkbraquet= true;
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String process = operation.getText().toString();
                process = process.replaceAll("x","*");
                process = process.replaceAll("%","/100");
                process = process.replaceAll("÷","/");

               Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="0";
                }

                result.setText(finalResult);
            }
        });



    }














}
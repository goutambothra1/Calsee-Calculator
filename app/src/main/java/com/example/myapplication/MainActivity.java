package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    Button add,equal, dot,multi, division, minus,one,two,three,four,five,six,seven,eight,nine,zero,clear;

    TextView tvAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAns=findViewById(R.id.AnswerText);
        add=findViewById(R.id.button_add);
        minus=findViewById(R.id.button_sub);
        multi=findViewById(R.id.button_mul);
        clear=findViewById(R.id.button_clear);
        division=findViewById(R.id.button_div);
        one=findViewById(R.id.button1);
        two=findViewById(R.id.button2);
        three=findViewById(R.id.button3);
        four=findViewById(R.id.button4);
        five=findViewById(R.id.button5);
        six=findViewById(R.id.button6);
        seven=findViewById(R.id.button7);
        eight=findViewById(R.id.button8);
        nine=findViewById(R.id.button9);
        zero=findViewById(R.id.button0);
        dot=findViewById(R.id.button_dot);
        equal=findViewById(R.id.button_equal);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvAns.setText("");

            }
        });

        one.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = one.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        two.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = two.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        three.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = three.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        four.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = four.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        five.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = five.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        six.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = six.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = seven.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = eight.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = nine.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        zero.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = zero.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = add.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        multi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = multi.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        division.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = division.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = minus.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        dot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String res=tvAns.getText().toString();
                String buttonText = dot.getText().toString();
                res=res+buttonText;
                tvAns.setText(res);

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                try {
                    String expression = tvAns.getText().toString();
                    double result = evaluateExpression(expression);
                    String Answer = Double.toString(result);

                    tvAns.setText(Answer);
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }

        }
            public  double evaluateExpression(String expression) {
                if (expression == null || expression.isEmpty()) {
                    throw new IllegalArgumentException("Expression cannot be empty");
                }

                Stack<Double> operands = new Stack<>();
                Stack<Character> operators = new Stack<>();

                for (int i = 0; i < expression.length(); i++) {
                    char ch = expression.charAt(i);
                    if (Character.isDigit(ch)) {
                        StringBuilder numStr = new StringBuilder();
                        while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                            numStr.append(expression.charAt(i));
                            i++;
                        }
                        i--; // Move back one position as the loop will advance it
                        operands.push(Double.parseDouble(numStr.toString()));
                    } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                        while (!operators.isEmpty() && hasHigherPrecedence(operators.peek(), ch)) {
                            double operand2 = operands.pop();
                            double operand1 = operands.pop();
                            char operator = operators.pop();
                            double result = applyOperator(operator, operand1, operand2);
                            operands.push(result);
                        }
                        operators.push(ch);
                    }
                }

                while (!operators.isEmpty()) {
                    double operand2 = operands.pop();
                    double operand1 = operands.pop();
                    char operator = operators.pop();
                    double result = applyOperator(operator, operand1, operand2);
                    operands.push(result);
                }

                return operands.pop();
            }

            private  boolean hasHigherPrecedence(char op1, char op2) {
                return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
            }

            private  double applyOperator(char operator, double operand1, double operand2) {
                switch (operator) {
                    case '+':
                        return operand1 + operand2;
                    case '-':
                        return operand1 - operand2;
                    case '*':
                        return operand1 * operand2;
                    case '/':
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        return operand1 / operand2;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + operator);
                }
            }
        });
    }
}
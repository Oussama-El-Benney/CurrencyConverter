package isetcom.oussama.devise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConvertActivity extends AppCompatActivity {
    Spinner spinnerFirst, spinnerSecond;
    Button btnConvert;
    EditText userInput;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        userInput = this.findViewById(R.id.userInput);
        tvResult = this.findViewById(R.id.tvResult);

        Toast.makeText(ConvertActivity.this, getResources().getString(R.string.warn), Toast.LENGTH_LONG).show();

        btnConvert = this.findViewById(R.id.btnConvert);
//        managing spinner
        spinnerFirst = findViewById(R.id.spinnerfirst);
        spinnerSecond = findViewById(R.id.spinnersecond);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFirst.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapterSecond = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSecond.setAdapter(adapterSecond);

        spinnerFirst.setSelection(0);
        spinnerSecond.setSelection(1);


        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String convertFrom = (String) spinnerFirst.getSelectedItem();
                String convertTo = (String) spinnerSecond.getSelectedItem();

                String s1 = userInput.getText().toString();

                if (s1.equals("")) {
                    Toast.makeText(ConvertActivity.this, getResources().getString(R.string.notifErreurValue), Toast.LENGTH_LONG).show();
                }
                else if (convertFrom.equals("TND – Tunisian Dinar")) {
                    Double x1 = Double.parseDouble(s1);
                    switch (convertTo) {
                        case "USD – US Dollar":
                            tvResult.setText(String.format("%.2f", x1 * 3.11));
                            break;
                        case "EUR – Euro":
                            tvResult.setText(String.format("%.2f", x1 * 3.32));
                            break;
                        case "GBP – British Pound":
                            tvResult.setText(String.format("%.2f", x1 * 3.75));
                            break;
                        case "CAD – Canadian Dollar":
                            tvResult.setText(String.format("%.2f", x1 * 2.28));
                            break;
                        case "JPY – Japanese Yen":
                            tvResult.setText(String.format("%.2f", x1 * 0.02));
                            break;
                        case "CHF – Swiss Franc":
                            tvResult.setText(String.format("%.2f", x1 * 3.34));
                            break;
                        default:
                            System.out.println("Looking forward to continue");
                    }
                }
                else Toast.makeText(ConvertActivity.this, getResources().getString(R.string.notifDev), Toast.LENGTH_LONG).show();

            }
        });


    }
}
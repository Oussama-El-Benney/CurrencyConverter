package isetcom.oussama.devise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText name;
    TextView deviseChanges;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = this.findViewById(R.id.btnStart);
        name = this.findViewById(R.id.enterName);
        deviseChanges = this.findViewById(R.id.deviseChanges);

        deviseChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adr ="https://www.xe.com/fr/currencytables/?from=TND&date=2022-12-23#table-section";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(adr));
                startActivity(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String playerName = name.getText().toString();
                if(!(playerName.equals(""))){

                    Intent i = new Intent(MainActivity.this, ConvertActivity.class);
                    i.putExtra("startGame", playerName);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.notifErreur), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
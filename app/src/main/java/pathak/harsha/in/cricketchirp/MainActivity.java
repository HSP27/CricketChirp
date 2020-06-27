package pathak.harsha.in.cricketchirp;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText cricketChirpsEditText;
    private TextView tempTextView, apprxTempTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        cricketChirpsEditText = findViewById(R.id.cricketChirpsEditText);
        apprxTempTextView = findViewById(R.id.apprxTempTextView);
        Button calTempBtn = findViewById(R.id.calTempBtn);
        tempTextView = findViewById(R.id.tempTextView);
        tempTextView.setVisibility(View.GONE);
        apprxTempTextView.setVisibility(View.GONE);
        calTempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chirps = cricketChirpsEditText.getText().toString();
                if (chirps.isEmpty()) {
                    tempTextView.setText("Empty Value." + "\n" + "Please Enter a Valid Number");
                    tempTextView.setVisibility(View.VISIBLE);
                    hideKeybaord(view);
                    return;
                }
                int NumberOfChirps = Integer.parseInt(chirps);
                int temperature = (NumberOfChirps / 3) + 4;
                tempTextView.setText(temperature + "°C");
                hideKeybaord(view);
                apprxTempTextView.setVisibility(View.VISIBLE);
                tempTextView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void hideKeybaord(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
    }
}

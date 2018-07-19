package dlwjddms.com.closet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameText =(EditText)findViewById(R.id.nameText);
        Button button1=(Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =nameText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), button_1.class);
                intent.putExtra("nameText",name);
                startActivity(intent);

            }
        });  // button1 대해



        Button button3=(Button)findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), button_3.class);
                startActivity(intent);
            }
        });       //button3 대해




    }

}

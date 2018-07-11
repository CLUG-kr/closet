package dlwjddms.com.closet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class button_2 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button2);

        Button button2_1 = (Button) findViewById(R.id.button2_1);

        button2_1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), button2_1gallery.class);
                startActivity(intent);
            }
        });  //button2_1 대해


        Button button2_2 = (Button) findViewById(R.id.button2_2);

        button2_2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), button2_2gallery.class);
                startActivity(intent);
            }
        });  //button2_2 대해



        Button button2_3 = (Button) findViewById(R.id.button2_3);

        button2_3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), button2_3gallery.class);
                startActivity(intent);
            }
        });  //button2_3 대해


        Button button2_4 = (Button) findViewById(R.id.button2_4);

        button2_4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), button2_4gallery.class);
                startActivity(intent);
            }
        });  //button2_4 대해

    }
}

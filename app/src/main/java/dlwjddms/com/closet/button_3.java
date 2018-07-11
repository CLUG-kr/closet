package dlwjddms.com.closet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;



public class button_3 extends AppCompatActivity {

    ImageView imageView;
   File file;
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button3);
File sdcard = Environment.getExternalStorageDirectory();
 file = new File(sdcard,"capture.jpg");
        imageView=(ImageView)findViewById(R.id.imageView);

        Button button =(Button)findViewById(R.id.button3_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               capture();
            }
        });
    }

     public  void capture(){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        startActivityForResult(intent,101); // 사진 찍은후 응답받기

     }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101 && resultCode== Activity.RESULT_OK){
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8; //사진 용량 줄이기
           Bitmap bitmap= BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            imageView.setImageBitmap(bitmap);
        }
    }
}



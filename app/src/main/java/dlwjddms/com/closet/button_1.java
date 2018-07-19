package dlwjddms.com.closet;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import static android.content.ContentValues.TAG;


public class button_1 extends Activity {

    static Integer a;

    final int REQ_CODE_SELECT_IMAGE=100;


    @Override

    protected  void  onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.button1);
        TextView nameText = findViewById(R.id.nameText);
        final Intent intent = getIntent();
        nameText.setText(intent.getStringExtra("nameText").toString());

        ImageView imageView2 = findViewById(R.id.imageView2);

        imageView2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                a=2;
            performFileSearch();
            }
        });
        ImageView imageView3 = findViewById(R.id.imageView3);

        imageView3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                a=3;
                performFileSearch();
            }
        });
        ImageView imageView4 = findViewById(R.id.imageView4);

        imageView4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                a=4;
                performFileSearch();

            }
        });
        final ImageView imageView5= findViewById(R.id.imageView5);

        imageView5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                a=5;
                performFileSearch();

            }
        });
        ImageView imageView6 = findViewById(R.id.imageView6);

        imageView6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                 a=6;
                performFileSearch();  // 해당 이미지 화면 클릭시 문서 들어갈수 있도록
            }
        });

    }


    private static final int READ_REQUEST_CODE = 42;

    public void performFileSearch() {

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");

        startActivityForResult(intent, READ_REQUEST_CODE);



    }


    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {


        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                Log.i(TAG, "Uri: " + uri.toString());
             showImage(uri);
                dumpImageMetaData(uri);

                try {
                    Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), resultData.getData());
                    if(a==2){
                    ImageView image = (ImageView)findViewById(R.id.imageView2);
                        image.setImageBitmap(image_bitmap);}
                    else if(a==3){ ImageView image = (ImageView)findViewById(R.id.imageView3);
                        image.setImageBitmap(image_bitmap);}
                    else if(a==4){ ImageView image = (ImageView)findViewById(R.id.imageView4);
                        image.setImageBitmap(image_bitmap);}
                    else if(a==5){ ImageView image = (ImageView)findViewById(R.id.imageView5);
                        image.setImageBitmap(image_bitmap);}
                    else{ ImageView image = (ImageView)findViewById(R.id.imageView6);
                        image.setImageBitmap(image_bitmap);}

                } catch (IOException e) {
                    e.printStackTrace();
                }








            }

        }

    }

    public void dumpImageMetaData(Uri uri) {

        // The query, since it only applies to a single document, will only return
        // one row. There's no need to filter, sort, or select fields, since we want
        // all fields for one document.
        Cursor cursor = this.getContentResolver().query(uri, null, null, null, null, null);

        try {

            if (cursor != null && cursor.moveToFirst()) {

                String displayName = cursor.getString(
                        cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                Log.i(TAG, "Display Name: " + displayName);

                int sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE);

                String size = null;
                if (!cursor.isNull(sizeIndex)) {

                    size = cursor.getString(sizeIndex);
                } else {
                    size = "Unknown";
                }
                Log.i(TAG, "Size: " + size);
            }
        } finally {
            cursor.close();
        }
    }


public void showImage(Uri uri){



}







}

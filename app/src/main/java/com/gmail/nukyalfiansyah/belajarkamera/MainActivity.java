package com.gmail.nukyalfiansyah.belajarkamera;
//Nama com.gmail.nukyalfiansyah.belajarkamera, berarti kelas-kelas Java di aplikasi tersebut secara hierarki berada
// di dalam tiga buah tingkatan folder, yaitu folder belajarkamera, yang berada di dalam folder nukyalfiasyah,
// yang berada lagi di dalam folder com.
//pada bagian com : yang artinya nama domain/tempat aplikasi di buat
//pada bagian gmail.nukyalfiansyah : nama developer pembuat aplikasi
//pada bagian belajarkamera :adalah nama aplikasinya


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//Import Pada Java Merupakan Suatu Perintah Untuk Memasukan suatu Method atau perintah dalam Bahasa Pemrograman Java
// sehingga perintah tersebut dapat Aktif dan digunakan atau berfungsi.
public class MainActivity extends AppCompatActivity {
    //pada bagian script di atas adalah mendeklerasikan id dari class mainactivity pada java
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //pada bagian script di atas Protected adalah kode akses yang membuat
        // suatu data atau method yang didefinisikan dengan tingkatan akses ini dapat diakses oleh kelas yang
        // memilikinya saja dan juga kelas-kelas yang memasih memiliki keturunan atau Encapsulation data,

        setContentView(R.layout.activity_main);
        //pada bagian script di atas adalah untuk mendeklerasikan layout actifity_main pada layout di bagian xml fungsinya
        //sebagai seperti inten
        Button btnCamera = (Button) findViewById(R.id.btnCamera);
        //pada bagian script d atas adalah membuat fungsi tombbol button berfungsi pada hal nya dan
        //memasukan id nya adalah btnCamera
        imageView = findViewById(R.id.imageView);
        //pada script di atas adalah sama hal nya fungsinya seperti di atas yaitu membuat suatu fungsi yang berfungsi pada
        //halnya
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, 0);
                //pada bagian script di atas adalah untuk perpindahan layout,jadi ketika button di klik maka
                //akan pindah ke layout kamera.
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        //Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
        //imageView.setImageBitmap(imageBitmap);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(imageBitmap);
                //pada bagian script di atas adalah untuk mengidentifikasi data gambar,jadi fungsi ini halnya sama
                //seperti kamera pada umumnya yaitu mengambil gambar pada kamera.
            }
        }

    }
}

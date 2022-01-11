package simple.example.hewanpedia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import simple.example.hewanpedia.model.Harimau;
import simple.example.hewanpedia.model.Hewan;
import simple.example.hewanpedia.model.Kumbang;
import simple.example.hewanpedia.model.Tikus;

public class DaftarHewanActivity extends AppCompatActivity {
    public final static String HEWAN_TERPILIH ="hewan_obj_key";
    List<Hewan> hewans;
    ListView listView;
    String jenisHewan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_hewan);
        Intent intent = getIntent();
        jenisHewan = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        hewans = DataProvider.getHewansByTipe(this,jenisHewan);
        // sesuaikan judul
        TextView txJudul = findViewById(R.id.text_title_daftar);
        String judul="";
        if (hewans.get(0) instanceof Harimau) {
            judul = getString(R.string.harimau_list_title);
        } else if (hewans.get(0) instanceof Kumbang) {
            judul = getString(R.string.kumbang_list_title);
        } else if (hewans.get(0) instanceof Tikus) {
            judul = getString(R.string.tikus_list_title);
        }
        txJudul.setText("DAFTAR BERBAGAI RAS "+jenisHewan.toUpperCase());
        hewans = DataProvider.getHewansByTipe(this,jenisHewan);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_hewan);
        DaftarHewanAdapter adapter = new DaftarHewanAdapter(this,hewans);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Hewan terpilih = hewans.get(position);
            bukaProfileHewan(terpilih);
        }
    };

    private void bukaProfileHewan(Hewan hewanTerpilih) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, ProfilActivity.class);
        intent.putExtra(HEWAN_TERPILIH, hewanTerpilih);
        startActivity(intent);
    }


}
package com.example.listviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listviewnangcao.adapter.SanPhamAdapter;
import com.example.listviewnangcao.model.SanPham;

public class MainActivity extends AppCompatActivity {
    ListView lvSanPham;
    SanPhamAdapter sanPhamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        fakeData();
    }

    private void fakeData() {
        sanPhamAdapter.add(new SanPham(R.drawable.cam,"Cam",15000));
        sanPhamAdapter.add(new SanPham(R.drawable.chomchom,"Chôm chôm",25000));
        sanPhamAdapter.add(new SanPham(R.drawable.chuoi,"Chuối",35000));
        sanPhamAdapter.add(new SanPham(R.drawable.dau,"Dâu",5000));
        sanPhamAdapter.add(new SanPham(R.drawable.khom,"Khóm",20000));
        sanPhamAdapter.add(new SanPham(R.drawable.man,"Mận",18000));
        sanPhamAdapter.add(new SanPham(R.drawable.mangcut,"Măng cụt",17000));
        sanPhamAdapter.add(new SanPham(R.drawable.nhan,"Nhãn",6000));
        sanPhamAdapter.add(new SanPham(R.drawable.sobo,"Sơ bô",9000));
        sanPhamAdapter.add(new SanPham(R.drawable.tao,"Táo",10000));
    }

    private void addEvents() {
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham sp=sanPhamAdapter.getItem(i);
                Toast.makeText(MainActivity.this,"Bạn chọn:"+sp.getTen()+"-"+sp.getGia()+"VND",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addControls() {
        lvSanPham= (ListView) findViewById(R.id.lvSanPham);
        sanPhamAdapter=new SanPhamAdapter(MainActivity.this,R.layout.item);
        lvSanPham.setAdapter(sanPhamAdapter);
    }
}
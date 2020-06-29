package wawa.developer.saungapung.adapeter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import wawa.developer.saungapung.Activities.MainActivity;
import wawa.developer.saungapung.R;

public class CustumListAdapter extends BaseAdapter {
    String naama_makanan[];
    String harga_makanan[];
    int gambar_makanan[];
    Activity act;
    public CustumListAdapter(MainActivity mainActivity, String[]
            nama_makanan, int[] gambar_makanan, String[] harga_makanan) {
        naama_makanan=nama_makanan;
        this.gambar_makanan = gambar_makanan;
        this.harga_makanan = harga_makanan;
        act = mainActivity;
    }
    @Override
    public int getCount() {
        //berapa banyak data yg di tampilkan
        return gambar_makanan.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater =
                (LayoutInflater)act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.tampilancustomlist,null);
        ImageView imgmakanan =
                (ImageView)convertView.findViewById(R.id.imgmakanan);
        TextView txtmakanan =
                (TextView)convertView.findViewById(R.id.txtmakanan);
        TextView hargamakanan =
                (TextView)convertView.findViewById(R.id.txtharga);
        txtmakanan.setText(naama_makanan[i]);
        hargamakanan.setText(harga_makanan[i]);
        imgmakanan.setImageResource(gambar_makanan[i]);
        return convertView;
    }
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}

package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{
    private Planeta[] planetas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planets, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
        String[] planetarr = getResources().getStringArray(R.array.Planets);
        String[] distanciarr = getResources().getStringArray(R.array.Distancia);
        String[] tamanioarr = getResources().getStringArray(R.array.Tamanio);
        TypedArray imagenes = getResources().obtainTypedArray(R.array.imagenes);
        planetas = new Planeta[getResources().getStringArray(R.array.Planets).length];
        Log.d("DRAWABLE", "onActivityCreated: "+ imagenes.getDrawable(0).toString());
        for (int i = 0;i<getResources().getStringArray(R.array.Planets).length;i++){
            planetas[i] = new Planeta(planetarr[i],tamanioarr[i],distanciarr[i],imagenes.getResourceId(i,0));
             }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            newIntent.setAction(Intent.ACTION_SEND);
            newIntent.setType("*/*");
            Bundle bundle = new Bundle();
            bundle.putSerializable("PLANETA",planetas[i]);
            newIntent.putExtras(bundle);
            startActivity(newIntent);
        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putSerializable("PLANETA", planetas[i]);
            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundle);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }



    }
}

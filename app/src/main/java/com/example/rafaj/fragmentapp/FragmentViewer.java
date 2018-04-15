package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentViewer extends Fragment {
    TextView text,tam,distancia;
    ImageView imagen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        text = view.findViewById(R.id.textId);
        distancia = view.findViewById(R.id.distancia);
        tam = view.findViewById(R.id.tamanio);
        imagen = view.findViewById(R.id.imagenview);
        Bundle bundle = this.getArguments();


        if(bundle != null){

            Planeta planeta = (Planeta) bundle.getSerializable("PLANETA");
            text.setText(planeta.getNombre());
            distancia.setText(planeta.getDistancia());
            tam.setText(planeta.getTamanio());
            imagen.setImageResource(planeta.getImageID());
            Toast.makeText(getActivity(), "Item: " + planeta.getNombre(), Toast.LENGTH_SHORT).show();

        }

        return view;
    }


}

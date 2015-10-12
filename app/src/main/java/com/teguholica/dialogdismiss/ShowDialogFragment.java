package com.teguholica.dialogdismiss;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by teguholica on 13/10/2015.
 */
public class ShowDialogFragment extends AppCompatDialogFragment {

    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    public static ShowDialogFragment newInstance() {

        Bundle args = new Bundle();

        ShowDialogFragment fragment = new ShowDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView txtContent = new TextView(getActivity());
        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Judul Dialog")
                .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                .setPositiveButton("Tambah", null)
                .setNegativeButton("Batalkan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //GANTI KODE DIBAWAH DENGAN EVENT NEGATIF
                        Toast.makeText(getActivity(), "Ini event negatif", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        alertDialog = builder.create();
        return alertDialog;
    }

    @Override
    public void onResume() {
        Button btnPositive = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GANTI KODE DIBAWAH DENGAN EVENT POSITIF
                Toast.makeText(getActivity(), "Ini event positif", Toast.LENGTH_SHORT).show();
            }
        });
        super.onResume();
    }
}

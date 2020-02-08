package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDialog extends AppCompatDialogFragment {
    //in the next 3 lines we initialise both textBoxes (that are on the dialog) and create a listner
    //object which will allow us to connect the main activity and mydialog class
    private EditText textBox1;
    private EditText textBox2;
    private MyDialogListner listner;


    //creates a dialog instance with buttons and text boxes
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout, null);

        //we set the view to the dialog
        builder.setView(view)
                .setTitle("My Dialog")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //do nothing if the cancel button is clicked
                //all buttons automatically exit out of the dialog anyway
            }
        }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String boxText1 = textBox1.getText().toString();
                String boxText2 = textBox2.getText().toString();
                listner.retrieveText(boxText1, boxText2);
            }
        });
        textBox1 = view.findViewById(R.id.box_1);
        textBox2 = view.findViewById(R.id.box_2);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);

        try {
            listner = (MyDialogListner) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement MyDialogListner");
        }
    }

    public interface MyDialogListner{
        void retrieveText(String boxText1, String boxText2);
    }
}

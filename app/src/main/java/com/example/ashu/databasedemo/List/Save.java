package com.example.ashu.databasedemo.List;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ashu.databasedemo.Database;
import com.example.ashu.databasedemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Save extends Fragment {
    TextView tvname,tvadd,tvcontact;
    Button btn_save,btn_cancel;
    private View view;
    String name;
    String contact;
    String address;
    Database db;

    public Save() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_save, container, false);
        tvcontact=(TextView)view.findViewById(R.id.contact_et);
        tvname=(TextView)view.findViewById(R.id.name_et);
        tvadd=(TextView)view.findViewById(R.id.address_et);
        btn_save=(Button)view.findViewById(R.id.save_btn);
        btn_cancel=(Button)view.findViewById(R.id.cancel_btn);
        db=new Database(getActivity());


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

        return view;

    }

    private void save() {

        address=tvadd.getText().toString();
        contact=tvcontact.getText().toString();
        name=tvname.getText().toString();
        System.out.println("Inserting :");
        db.insertdata(name,contact,address);

    }

}

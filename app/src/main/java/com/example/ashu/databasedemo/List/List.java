package com.example.ashu.databasedemo.List;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ashu.databasedemo.Database;
import com.example.ashu.databasedemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class List extends Fragment {

    ListView list;
    View view;
    Database myDb;

    public List() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.list_view, container, false);
        list=(ListView)view.findViewById(R.id.listView);
        myDb=new Database(getActivity());
        Cursor cursor=myDb.getData();
        String[] from = {myDb.name1,myDb.address1,myDb.contact1};
        int[] to = {R.id.tv_name, R.id.tv_address,R.id.tv_contact};
        SimpleCursorAdapter cursorAdapter=new SimpleCursorAdapter(getActivity(),R.layout.display,cursor,from,to);
        list.setAdapter(cursorAdapter);

        return view;
    }

}

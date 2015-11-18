package com.tecpoint.mobilfirsat.mobilfirsat.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tecpoint.mobilfirsat.mobilfirsat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainList extends Fragment {

private ListView lsvMainList ;
    public MainList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        lsvMainList=(ListView)getActivity().findViewById(R.id.lsvMainList);
        String[]dizi={"TUGBA","asjdkfl"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,android.R.id.text1,dizi);
        lsvMainList.setAdapter(adapter);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_list, container, false);
    }


}

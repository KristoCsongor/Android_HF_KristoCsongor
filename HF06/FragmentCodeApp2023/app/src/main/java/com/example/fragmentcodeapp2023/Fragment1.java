package com.example.fragmentcodeapp2023;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    protected static final String FRAG2 = "2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);
        Context context = getActivity().getApplicationContext();

        final String[] fruits = {"Apple", "Mango", "Orange", "Grapes", "Banana"};
        ListView fruitsList = view.findViewById(R.id.fruits_list);
        ArrayAdapter<String> arrayAdpt = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, fruits);
        fruitsList.setAdapter(arrayAdpt);

        FragmentManager fm = getParentFragmentManager();
        fruitsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (fm.findFragmentByTag(FRAG2) != null) {
                    TextView selectedOpt = getActivity().findViewById(R.id.selectedopt);
                    selectedOpt.setText("You have selected " + ((TextView) view).getText().toString());
                } else {
                    Intent intent = new Intent(getActivity().getApplicationContext(), ShowItemActivity.class);
                    intent.putExtra("item", ((TextView) view).getText().toString());
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}
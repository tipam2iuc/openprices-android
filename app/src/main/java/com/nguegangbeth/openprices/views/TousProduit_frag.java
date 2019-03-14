package com.nguegangbeth.openprices.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nguegangbeth.openprices.R;
import com.nguegangbeth.openprices.modeles.Market;
import com.nguegangbeth.openprices.modeles.Produits;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TousProduit_frag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TousProduit_frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TousProduit_frag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Produits> produitsList;
    private Calendar  calendar = Calendar.getInstance();
    private ImageView imageView;
    //private int dateNow = (int) calendar.get(calendar.getTimeZone());
    public TousProduit_frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TousProduit_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static TousProduit_frag newInstance(String param1, String param2) {
        TousProduit_frag fragment = new TousProduit_frag();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tous_produit_frag, container, false);
        RecyclerView list = (RecyclerView)view.findViewById(R.id.recycleview_lesplusrecommandes);
        list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        list.setAdapter(new HorizontalAdapter
                        (new int[]{
                                R.drawable.pain,
                                R.drawable.saucisson_ail,
                                R.drawable.tour_canteloup,
                                R.drawable.riz_broli_5kg,
                                R.drawable.pate_brise,
                                R.drawable.beurre_jadida,
                                R.drawable.jadida_table_45kg
                                },
                         new String[]{
                                 "Pain complet",
                                 "Saucisson a l'ail",
                                 "Tour de canteloup",
                                 "Riz broli 5kg",
                                 "Pate brise",
                                 "Beurre Jadida 2.5kg",
                                 "Jadida table 45kg"
                        }
                        ));


        recyclerView = (RecyclerView)view.findViewById(R.id.recycle_view_touslesproduits);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        produitsList = new ArrayList<>();
        for(int i = 0; i <= 10; i++){
            Produits listItem = new Produits(

                    1,"sauc2","Saucisson",1500,
                    2.0,R.drawable.saucisson_ail, null,
                    0,"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod"
            );

            produitsList.add(listItem);
        }


        adapter = new Holder_tous_les_produitsAdapter(produitsList, getContext());

        recyclerView.setAdapter(adapter);
        imageView = (ImageView)view.findViewById(R.id.imageView_coeurvide_holderTousProduits);



       /* produitsList.add(new Produits(1,"sauc2","Saucisson",1500,
               2.0,R.drawable.saucisson_ail, null,
               0,"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod"));

        produitsList.add(new Produits(2,"beure1","Beurre jadida table",2500,
                45,R.drawable.jadida_table_45kg, null,
                0,"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod"));

        produitsList.add(new Produits(3,"beure2","Beurre jadida",2500,
                2.5,R.drawable.jadida_2_5kg, null,
                0,"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod"));

        produitsList.add(new Produits(4,"beure2","Spaghetti panzani",2500,
                1,R.drawable.panzani_1kg, null,
                0,"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod"));
        adapter = new Holder_tous_les_produitsAdapter(produitsList,getContext());*/
       recyclerView.setAdapter(adapter);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}

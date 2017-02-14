package com.notogt.socialissues.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.*;
import com.notogt.socialissues.R;

import java.util.*;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PieChartFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PieChartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PieChartFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_CHART_TITLE = "chartTitle";

    // TODO: Rename and change types of parameters
    private String mChartTitle = null;

    public PieChart mChart;

    public PieDataSet mDataSet;

    public Map<String, Float> mEntryMap = new HashMap<String, Float>();

    public List<PieEntry> mEntries = new ArrayList<PieEntry>();

    private OnFragmentInteractionListener mListener;

    public PieChartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param chartTitle The the title of the chart.
     * @return A new instance of fragment PieChartFragment.
     */
    public static PieChartFragment newInstance(String chartTitle) {
        PieChartFragment fragment = new PieChartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CHART_TITLE, chartTitle);
        fragment.setArguments(args);
        return fragment;
    }

    public void addEntry(String label, float value) {
        mEntryMap.put(label, value);
    }

    public void updateChart() {
        mEntries.clear();
        for (Map.Entry<String, Float> entry : mEntryMap.entrySet()) {
            mEntries.add(new PieEntry(entry.getValue(), entry.getKey()));
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mChartTitle = getArguments().getString(ARG_CHART_TITLE);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_piechart, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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

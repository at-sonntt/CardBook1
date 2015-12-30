package com.example.sonntt.cardbook.fragment;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sonntt.cardbook.model.DataHeaderRecycle;
import com.example.sonntt.cardbook.R;
import com.example.sonntt.cardbook.adapter.RecycleHeaderAdapter;
import com.example.sonntt.cardbook.until.MyMarker;
import com.example.sonntt.cardbook.until.RecyclerViewHeader;
import com.example.sonntt.cardbook.until.SimpleDividerItemDecoration;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author SonNTT on 12/23/15.
 */
@EFragment(R.layout.one_fragment)
public class OneFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnCameraChangeListener {
    @ViewById(R.id.recycleHeader)
    RecyclerViewHeader mRecyclerHeader;

    @ViewById(R.id.recycler)
    RecyclerView mRecycler;

    private ArrayList<DataHeaderRecycle> mDatas;

    private GoogleMap mMap;

    private ArrayList<MyMarker> mMyMarkersArray;


    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private HashMap<Marker, MyMarker> mMarkersHashMap;

    @AfterViews
    void afterView() {

        setData();
        setTingRecycleView();

        InitDataMap();
        setUpMapClickMaker();
        plotMarkers(mMyMarkersArray);

    }

    private void setData() {

        mDatas = new ArrayList<>();
        DataHeaderRecycle dataFake = new DataHeaderRecycle();
        dataFake.setName("Nguyen Tran Thai Son");
        for (int i = 0; i <= 10; i++) {
            mDatas.add(dataFake);
        }

    }

    private void setTingRecycleView() {
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycler.addItemDecoration(new SimpleDividerItemDecoration(
                getActivity().getApplicationContext()
        ));
        RecycleHeaderAdapter mRecycleHeaderAdapter = new RecycleHeaderAdapter(mDatas, getActivity().getBaseContext());
        mRecycler.setAdapter(mRecycleHeaderAdapter);
        mRecyclerHeader.attachTo(mRecycler, true);
    }

    private void InitDataMap() {

        mMyMarkersArray = new ArrayList<>();

        mMyMarkersArray.add(new MyMarker("Brasil", "icon1", Double.parseDouble("-28.5971788"), Double.parseDouble("-52.7309824")));
        mMyMarkersArray.add(new MyMarker("United States", "icon2", Double.parseDouble("33.7266622"), Double.parseDouble("-87.1469829")));
        mMyMarkersArray.add(new MyMarker("Canada", "icon3", Double.parseDouble("51.8917773"), Double.parseDouble("-86.0922954")));
        mMyMarkersArray.add(new MyMarker("England", "icon4", Double.parseDouble("52.4435047"), Double.parseDouble("-3.4199249")));
        mMyMarkersArray.add(new MyMarker("España", "icon5", Double.parseDouble("41.8728262"), Double.parseDouble("-0.2375882")));
        mMyMarkersArray.add(new MyMarker("Portugal", "icon6", Double.parseDouble("40.8316649"), Double.parseDouble("-4.936009")));
        mMyMarkersArray.add(new MyMarker("Deutschland", "icon7", Double.parseDouble("51.1642292"), Double.parseDouble("10.4541194")));
        mMyMarkersArray.add(new MyMarker("Atlantic Ocean", "icondefault", Double.parseDouble("-13.1294607"), Double.parseDouble("-19.9602353")));
    }

    private void setUpMapClickMaker() {

        if (mMap == null) {

            //noinspection deprecation
            mMap = ((MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map)).getMap();
            if (mMap != null) {
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker) {
                        marker.showInfoWindow();
                        return true;
                    }
                });

            } else
                Toast.makeText(getActivity().getApplicationContext(), "Unable to create Maps", Toast.LENGTH_SHORT).show();
        }
    }

    private void plotMarkers(ArrayList<MyMarker> markers) {
        mMarkersHashMap = new HashMap<>();

        if (markers.size() > 0) {
            for (MyMarker myMarker : markers) {

                // Create user marker with custom icon and other options
                MarkerOptions markerOption = new MarkerOptions().position(new LatLng(myMarker.getmLatitude(), myMarker.getmLongitude()));
                markerOption.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker50));

                Marker currentMarker = mMap.addMarker(markerOption);
                mMarkersHashMap.put(currentMarker, myMarker);

                mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter());
            }
        }
    }


    @Override
    public void onCameraChange(CameraPosition cameraPosition) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
        public MarkerInfoWindowAdapter() {
        }
        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            @SuppressLint("InflateParams") View v = getActivity().getLayoutInflater().inflate(R.layout.infowindow_layout, null);

            MyMarker myMarker = mMarkersHashMap.get(marker);

            ImageView markerIcon = (ImageView) v.findViewById(R.id.marker_icon);

            TextView markerLabel = (TextView) v.findViewById(R.id.marker_label);


            markerIcon.setImageResource(manageMarkerIcon(myMarker.getmIcon()));

            markerLabel.setText(myMarker.getmLabel());
            // anotherLabel.setText("A custom text");

            return v;
        }


    }

    private int manageMarkerIcon(String markerIcon) {

        switch (markerIcon) {
            case "icon1":
                return R.drawable.ic_directions_bike_red;
            case "icon2":
                return R.drawable.ic_directions_bike_red;
            case "icon3":
                return R.drawable.ic_directions_bike_red;
            case "icon4":
                return R.drawable.ic_directions_bike_red;
            case "icon5":
                return R.drawable.ic_directions_bike_red;
            case "icon6":
                return R.drawable.ic_directions_bike_red;
            case "icon7":
                return R.drawable.ic_directions_bike_red;
            default:
                return R.drawable.ic_directions_bike_red;
        }
    }
}

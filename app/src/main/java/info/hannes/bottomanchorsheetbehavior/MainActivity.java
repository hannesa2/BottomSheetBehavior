package info.hannes.bottomanchorsheetbehavior;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import info.hannes.bottomsheetanchor.BottomSheetAnchorBehavior;
import info.hannes.bottomsheetanchor.MergedAppBarLayoutBehavior;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    int[] mDrawables = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(" ");
        }


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.support_map);
        mapFragment.getMapAsync(this);

        /*
          If we want to listen for states callback
         */
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);
        View bottomSheet = coordinatorLayout.findViewById(R.id.bottom_sheet);
        final BottomSheetAnchorBehavior behavior = BottomSheetAnchorBehavior.from(bottomSheet);
        behavior.addBottomSheetCallback(new BottomSheetAnchorBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetAnchorBehavior.STATE_COLLAPSED:
                        Log.d("bottomsheet-", "STATE_COLLAPSED");
                        break;
                    case BottomSheetAnchorBehavior.STATE_DRAGGING:
                        Log.d("bottomsheet-", "STATE_DRAGGING");
                        break;
                    case BottomSheetAnchorBehavior.STATE_EXPANDED:
                        Log.d("bottomsheet-", "STATE_EXPANDED");
                        break;
                    case BottomSheetAnchorBehavior.STATE_ANCHOR_POINT:
                        Log.d("bottomsheet-", "STATE_ANCHOR_POINT");
                        break;
                    case BottomSheetAnchorBehavior.STATE_HIDDEN:
                        Log.d("bottomsheet-", "STATE_HIDDEN");
                        break;
                    default:
                        Log.d("bottomsheet-", "STATE_SETTLING");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });

        AppBarLayout mergedAppBarLayout = (AppBarLayout) findViewById(R.id.merged_appbarlayout);
        MergedAppBarLayoutBehavior mergedAppBarLayoutBehavior = MergedAppBarLayoutBehavior.from(mergedAppBarLayout);
        mergedAppBarLayoutBehavior.setToolbarTitle("Title Dummy by Code");
        mergedAppBarLayoutBehavior.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                behavior.setState(BottomSheetAnchorBehavior.STATE_COLLAPSED);
            }
        });

        ItemPagerAdapter adapter = new ItemPagerAdapter(this, mDrawables);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(adapter);

        behavior.setState(BottomSheetAnchorBehavior.STATE_ANCHOR_POINT);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(48, 12);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}

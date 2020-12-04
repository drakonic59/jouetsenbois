package fr.hattane.ilias.jouetenbois;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

import fr.hattane.ilias.jouetenbois.adapters.ExpandableFooterAdapter;

public class ScrollingActivity extends AppCompatActivity {

    private CarouselView carouselView;
    private int[] sampleImages = {R.mipmap.carousel_one, R.mipmap.carousel_two};

    private ExpandableListView footerList;
    private ExpandableListAdapter footerListAdapter;
    private ArrayList<String> footerTitles;
    private HashMap<String, ArrayList<String>> footerDetails;

    private ExpandableListView contentList;
    private ExpandableListAdapter contentListAdapter;
    private ArrayList<String> contentTitles;
    private HashMap<String, ArrayList<String>> contentDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        };

        carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        footerList = findViewById(R.id.footerList);
        contentList = findViewById(R.id.contentList);

        initFooterListData();
        footerTitles = new ArrayList<String>(footerDetails.keySet());
        footerListAdapter = new ExpandableFooterAdapter(this, footerTitles, footerDetails);
        footerList.setAdapter(footerListAdapter);

        contentTitles = new ArrayList<String>(footerDetails.keySet());
        contentListAdapter = new ExpandableFooterAdapter(this, contentTitles, footerDetails);
        contentList.setAdapter(contentListAdapter);

        footerList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                return false;
            }
        });

        contentList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                return false;
            }
        });
    }


    public void initFooterListData() {
        ArrayList<String> products = new ArrayList<>();
        products.add("Prix bas");
        products.add("Nouveaux produits");
        products.add("Meilleures ventes");

        ArrayList<String> compagny = new ArrayList<>();
        compagny.add("Livraison");
        compagny.add("Informations légales");
        compagny.add("Conditions générales");
        compagny.add("À propos de nous");
        compagny.add("Paiements sécurisés");
        compagny.add("Nous contacter");
        compagny.add("La carte");
        compagny.add("Nos magasins");

        ArrayList<String> account = new ArrayList<>();
        account.add("Informations personnelles");
        account.add("Commandes");
        account.add("Paiements en cours");
        account.add("Adresses");

        ArrayList<String> store = new ArrayList<>();
        store.add("Localisation");
        store.add("Horraires");

        footerDetails = new HashMap<>();
        footerDetails.put("Magasin", store);
        footerDetails.put("Compte", account);
        footerDetails.put("Compagnie", compagny);
        footerDetails.put("Produits", products);

    }

}

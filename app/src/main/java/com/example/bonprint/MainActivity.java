package com.example.bonprint;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> al;
    private String[] selectedArrayList = new String[500];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView lV = (ListView) findViewById(R.id.listV);

        Button bottomBtn = findViewById(R.id.bottomBtn);


        //BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(navView, navController);

        ArrayList<String> al = makeAL();
        setAl(al);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                al );

        lV.setAdapter(arrayAdapter);
        lV.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        //lV.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        lV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //Debug
                Log.d("HelloListView", "You clicked Item: " + id + " at position:" + position);
                // Then you start a new Activity via Intent

                ArrayList<String> al = getAl();
                String foodValue = al.get(position);

                //Debug
                Log.d("HelloListView", "FoodVal: " + foodValue);


                String[] foodParts = foodValue.split("\\|");

                //Debug
                Log.d("HelloListView", "Index 0: " + foodParts[0] + ", Index 1: " + foodParts[1]);

                double price = Double.parseDouble(foodParts[1]);//get Price
                getSelectedArrayList()[position] = String.valueOf(price);


            }
        });


        final Button button = findViewById(R.id.bottomBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String[] loopList = getSelectedArrayList();
                double totalPrice = 0;
                for(String itemPrice : loopList) {
                    if(itemPrice != null) {
                        totalPrice = totalPrice + Double.parseDouble(itemPrice);
                    }
                }

                //Debug
                Log.d("HelloListView", "Total Price: " + totalPrice);

            }
        });
    }

    private ArrayList<String> makeAL() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("ABSOLUT VODKA|4.50");
        al.add("ABSOLUT VODKA 70 CL|90.00");
        al.add("AMARETTO|4.00");
        al.add("AMARETTO BROWNIE|9.00");
        al.add("APPELSAP|2.75");
        al.add("ASAHI SUPER DRY|4.30");
        al.add("AUTODROP|3.00");
        al.add("AVOCADO MAKI|4.50");
        al.add("B52|4.50");
        al.add("BACARDI|4.00");
        al.add("BACARDI 100 CL|90.00");
        al.add("BACARDI 8YO 70 CL|100.00");
        al.add("BACARDI LEMON|4.25");
        al.add("BACARDI RAZZ|4.25");
        al.add("BACARDI RESERVA|4.50");
        al.add("BAILEYS|4.00");
        al.add("BELVEDERE|6.50");
        al.add("BELVEDERE 70 CL|110.00");
        al.add("BITTER LEMON|2.50");
        al.add("BITTERBALLEN|5.00");
        al.add("BOLLS ZEER OUDE JENEVER|2.75");
        al.add("BORRELPLANK|19.50");
        al.add("BULLDOG GIN|4.50");
        al.add("CALIFORNIA ROLL|12.50");
        al.add("CAPTAIN MORGAN OLD SPICE|4.50");
        al.add("CAPTAIN MORGAN SPICED GOLD 100 CL|90.00");
        al.add("CARPACCIO|9.00");
        al.add("CHAUDFONTAINE BLAUW|2.50");
        al.add("CHAUDFONTAINE ROOD|2.50");
        al.add("CHICKEN WINGS|5.00");
        al.add("CHIVAS 12 YO|5.00");
        al.add("CHIVAS 18 YO|9.00");
        al.add("CHIVAS 21 YO|21.00");
        al.add("CHOCOMEL|2.75");
        al.add("CHUKA WAKAME|3.50");
        al.add("COCA COLA|2.50");
        al.add("COCA COLA LIGHT|2.50");
        al.add("COCA COLA ZERO|2.50");
        al.add("COEBERGH BESSEN JENEVER|2.75");
        al.add("CONTREAU|4.50");
        al.add("COPPERHEAD GIN|9.00");
        al.add("CORONA|4.75");
        al.add("COURVOISIER VSOP|5.50");
        al.add("CRABSTICK MAKI|5.50");
        al.add("CRISPY CHICKEN|5.50");
        al.add("CRISPY CHICKEN ROLL|13.50");
        al.add("CRISPY CRAB ROLL|14.50");
        al.add("CRISPY EBI PRAWN ROLL|14.50");
        al.add("DESPERADOS|3.75");
        al.add("DOUBLE TROUBLE ROLL|18.50");
        al.add("DRAMBUIE|4.00");
        al.add("EBI PANKO|5.50");
        al.add("EDAMAME|4.50");
        al.add("ERISTOFF RED|4.00");
        al.add("ERISTOFF VODKA|4.00");
        al.add("FANTA CASSIS|2.50");
        al.add("FANTA ORANGE|2.50");
        al.add("FENTIMANS MANDARIN & SEVILLE|4.00");
        al.add("FENTIMANS ROSE LEMONADE|4.00");
        al.add("FENTIMANS SPARKLING RASPBERRY|4.00");
        al.add("FENTIMANS TROPICAL SODA|4.00");
        al.add("FENTIMANS VICTORIAN LEMONADE|4.00");
        al.add("FEVERTREE TONIC|3.50");
        al.add("FLAMED BEEF LOIN ROLL|14.50");
        al.add("FRANGELICO|4.00");
        al.add("FRISTI|2.75");
        al.add("GAMBASPIESJES|8.50");
        al.add("GINGER ALE|2.75");
        al.add("GINGER BEER|3.75");
        al.add("GORDON GIN|4.25");
        al.add("GORDON GIN PINK|4.00");
        al.add("GRAND MARNIER|4.50");
        al.add("GREY GOOSE|6.50");
        al.add("GREY GOOSE 70 CL|110.00");
        al.add("GRIMBERGEN BLOND|4.75");
        al.add("GRIMBERGEN DUBBEL|4.75");
        al.add("GRIMBERGEN TRIPEL|4.75");
        al.add("GROLSCH|2.75");
        al.add("GROLSCH IPA|4.50");
        al.add("GROLSCH RADLER CITROEN|2.75");
        al.add("GROLSCH RADLER CITROEN 0.0|2.75");
        al.add("GYOZA|5.50");
        al.add("HENDRICKS GIN|6.30");
        al.add("HENNESSY|5.00");
        al.add("HENNESSY 70 CL|90.00");
        al.add("HENNESSY VSOP|10.00");
        al.add("HENNESSY VSOP 100 CL|200.00");
        al.add("HENNESSY XO|27.50");
        al.add("HENNESSY XO 70 CL|330.00");
        al.add("HOPPE VIEUX|2.75");
        al.add("IJSMACARONE PASSION|8.00");
        al.add("IJSMACARONE PISTACHE|8.00");
        al.add("IJSMACARONE RED|8.00");
        al.add("JACK DANIELS|4.50");
        al.add("JACK DANIELS 100 CL|90.00");
        al.add("JACK DANIELS gentlemans jack|5.50");
        al.add("JACK DANIELS GENTLEMANS JACK 70 CL|100.00");
        al.add("JACK DANIELS single barrel|6.80");
        al.add("JACK DANIELS SINGLE BARREL 70 CL|120.00");
        al.add("JAGERMEISTER|2.75");
        al.add("JAMESON|4.00");
        al.add("JOHNNY BLACK|4.75");
        al.add("JOHNNY BLACK 100 CL|100.00");
        al.add("JOHNNY BLUE|27.50");
        al.add("JOHNNY BLUE 70 CL|300.00");
        al.add("JOHNNY GOLD|6.50");
        al.add("JOHNNY GOLD 70 CL|110.00");
        al.add("JOHNNY RED|4.00");
        al.add("JUS D' ORANGE|2.75");
        al.add("KAASTENGELS|5.50");
        al.add("KAPPA MAKI|4.50");
        al.add("KETEL 1 JONGE JENEVER|2.75");
        al.add("KING JACOB|20.00");
        al.add("KIPSPIESJES|6.00");
        al.add("KORNUIT 0.5 L|5.00");
        al.add("KORNUIT FLUIT|2.40");
        al.add("KORNUIT PULL|4.50");
        al.add("KORNUIT SCHUIM|3.40");
        al.add("KORNUIT VAAS|2.60");
        al.add("LICOR 43|4.00");
        al.add("LIPTON TEA|3.00");
        al.add("LIPTON TEA GREEN|3.00");
        al.add("LOEMPIA'S|3.50");
        al.add("LOUIS ROEDERER CRISTAL 75 CL|775.00");
        al.add("MALIBU|4.00");
        al.add("NACHO'S|6.50");
        al.add("NIGIRI AVOCADO|3.50");
        al.add("NIGIRI FLAMED SALMON|5.00");
        al.add("NIGIRI FLAMED SEA BASS|5.00");
        al.add("NIGIRI FLAMED TUNA|6.00");
        al.add("NIGIRI SALMON|4.00");
        al.add("NIGIRI SALMON TARTARE GUNKAN|5.75");
        al.add("NIGIRI TUNA|5.00");
        al.add("NIGIRI TUNA TARTARE GUNKAN|6.75");
        al.add("OSSENHAASSPIESJES|7.00");
        al.add("PERONI LIBERA |2.75");
        al.add("PINA COLADA|8.00");
        al.add("PINA COLADA|4.00");
        al.add("PISANG AMBON|4.00");
        al.add("PORNSTAR MARTINI|8.00");
        al.add("PRAWN ROLL|15.50");
        al.add("RED BULL|3.60");
        al.add("REMY MARTIN VSOP|6.75");
        al.add("REMY MARTIN VSOP 70 CL|120.00");
        al.add("REMY MARTIN XO|26.50");
        al.add("RONDJE BIER VOOR HET PERSONEEL|10.00");
        al.add("RUBY CUBE|10.00");
        al.add("SAFARI|4.00");
        al.add("SALMARI DROP|2.75");
        al.add("SALMON AVOCADO ROLL|13.50");
        al.add("SALMON MAKI|5.00");
        al.add("SALMON TARTARE ROLL|13.50");
        al.add("SAMBUCCA|4.00");
        al.add("SAMBUCCA|3.00");
        al.add("SASHIMI FLAMED SALMON|9.00");
        al.add("SASHIMI FLAMED TUNA|11.00");
        al.add("SASHIMI SALMON|6.50");
        al.add("SASHIMI TUNA|7.50");
        al.add("SODA WATER|2.75");
        al.add("SOUTHERN COMFORT|4.00");
        al.add("SPRITE|2.50");
        al.add("STRAWBERRY DAIQUIRI|8.00");
        al.add("SUSHI & SASHIMI PLANK|42.50");
        al.add("TEQUILA GOLD|3.50");
        al.add("TIA MARIA|4.00");
        al.add("TONIC|2.50");
        al.add("TUNA AVOCADO ROLL|14.50");
        al.add("TUNA MAKI|6.00");
        al.add("TUNA TARTARE ROLL|15.50");
        al.add("VEGA ROLL|10.50");
        al.add("WIECKSE ROSÉ|3.75");

        return al;
    }

    public ArrayList<String> getAl() {
        return al;
    }

    public void setAl(ArrayList<String> al) {
        this.al = al;
    }

    public String[] getSelectedArrayList() {
        return selectedArrayList;
    }

    public void setSelectedArrayList(String[] selectedArrayList) {
        this.selectedArrayList = selectedArrayList;
    }
}
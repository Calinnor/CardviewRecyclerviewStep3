package ocr.exercice.cardviewandrecyclerexercicestep3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CardViewStatuesDetails extends AppCompatActivity {

    /**
     * utilisation de butterknife
     */
    @BindView(R.id.author_name_for_detail) TextView mCreatoName;
    @BindView(R.id.date_for_detail) TextView date;
    @BindView(R.id.content_information_for_details) TextView contentInformation;
    @BindView(R.id.statue_name_for_detail) TextView statueName;
    @BindView(R.id.statues_view_for_detail) ImageView statueImage;

    public CardViewStatues cardViewStatues;
    /**
     * var de classes a utiliser avec une recuperation des valeurs de l'intent "normal"
     */
//    public static final String SCULPTOR_NAME = "SCULPTOR_NAME";
//    public static final String DATE = "DATE";
//    public static final String CONTENT_INFORMATION ="CONTENT_INFORMATION";
//    public static final String STATUE_NAME ="STATUE_NAME";
//    public static final String STATUE_IMAGE = "STATUE_IMAGE";
    /**
     * ci dessous a utiliser lors d'une utilisation parcelable
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_statues_details);
        /**
         * Ne pas oublier d'implementer le retour butter knife !!!
         */
        ButterKnife.bind(this);
        /**
         * Ne pas oublier d'implementer le retour butter knife !!!
         */

        this.configureToolbar();

        /**
         * utilisation d'une methode recuperant l'intent
         */
        getNeighbourIntent();
        /**
         * ci dessous recuperation de l'intent sans methode
         */
//        Intent intent = getIntent();
//        cardViewStatues = intent.getParcelableExtra("CardviewStatue");
        /**
         *ci dessous developpement pour un intent normal
         */
//        String getSculptorName = getIntent().getStringExtra(SCULPTOR_NAME);
//        TextView sculptorName = findViewById(R.id.author_name_for_detail);
//        sculptorName.setText(getSculptorName);
//
//        String getDate = getIntent().getStringExtra(DATE);
//        TextView date = findViewById(R.id.date_for_detail);
//        date.setText(getDate);
//
//        String getContentInformation = getIntent().getStringExtra(CONTENT_INFORMATION);
//        TextView contentInformation = findViewById(R.id.content_information_for_details);
//        contentInformation.setText(getContentInformation);
//
//        String getStatueName = getIntent().getStringExtra(STATUE_NAME);
//        TextView statueName = findViewById(R.id.statue_name_for_detail);
//        statueName.setText(getStatueName);
//
//        int getStatueImage = getIntent().getIntExtra(STATUE_IMAGE, 0);
//        ImageView statueImage = findViewById(R.id.statues_view_for_detail);
//        statueImage.setImageResource((getStatueImage));
        /**
         * ci dessous recuperation des valeurs de l'intent via un intent parcelable
         */
//        String getSculptorName = cardViewStatues.getCreatorName();
//        TextView sculptorName = findViewById(R.id.author_name_for_detail);
//        sculptorName.setText(getSculptorName);
//
//        String getDate = cardViewStatues.getActualDate();
//        TextView date = findViewById(R.id.date_for_detail);
//        date.setText(getDate);
//
//        String getContentInformation = cardViewStatues.getInformationsContent();
//        TextView contentInformation = findViewById(R.id.content_information_for_details);
//        contentInformation.setText(getContentInformation);
//
//        String getStatueName = cardViewStatues.getTitleName();
//        TextView statueName = findViewById(R.id.statue_name_for_detail);
//        statueName.setText(getStatueName);
//
//        int getStatueImage = cardViewStatues.getStatueImage();
//        ImageView statueImage = findViewById(R.id.statues_view_for_detail);
//        statueImage.setImageResource((getStatueImage));
        /**
         * ci dessous utilisation d'une methode pour liberer oncreate
         */
       updateCardViewStatue();

    }//fin onCreate

    private void configureToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private  void getNeighbourIntent(){
        Intent intent = getIntent();
        cardViewStatues = intent.getParcelableExtra("CardviewStatue");
    }

    private void updateCardViewStatue(){
        /**
         * sans butterknife
         */
//        String getSculptorName = cardViewStatues.getCreatorName();
//        TextView sculptorName = findViewById(R.id.author_name_for_detail);
//        sculptorName.setText(getSculptorName);
//
//        String getDate = cardViewStatues.getActualDate();
//        TextView date = findViewById(R.id.date_for_detail);
//        date.setText(getDate);
//
//        String getContentInformation = cardViewStatues.getInformationsContent();
//        TextView contentInformation = findViewById(R.id.content_information_for_details);
//        contentInformation.setText(getContentInformation);
//
//        String getStatueName = cardViewStatues.getTitleName();
//        TextView statueName = findViewById(R.id.statue_name_for_detail);
//        statueName.setText(getStatueName);
//
//        int getStatueImage = cardViewStatues.getStatueImage();
//        ImageView statueImage = findViewById(R.id.statues_view_for_detail);
//        statueImage.setImageResource((getStatueImage));
        /**
         * avec butterknife
         */
        mCreatoName.setText(cardViewStatues.getCreatorName());
        date.setText(cardViewStatues.getActualDate());
        contentInformation.setText(cardViewStatues.getInformationsContent());
        statueName.setText(cardViewStatues.getTitleName());
        statueImage.setImageResource(cardViewStatues.getStatueImage());
    }
}

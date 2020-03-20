package ocr.exercice.cardviewandrecyclerexercicestep3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CardViewStatuesDetails extends AppCompatActivity {

    public static final String SCULPTOR_NAME = "SCULPTOR_NAME";
    public static final String DATE = "DATE";
    public static final String CONTENT_INFORMATION ="CONTENT_INFORMATION";
    public static final String STATUE_NAME ="STATUE_NAME";
    public static final String STATUE_IMAGE = "STATUE_IMAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_statues_details);

        this.configureToolbar();

        String getSculptorName = getIntent().getStringExtra(SCULPTOR_NAME);
        TextView sculptorName = findViewById(R.id.author_name_for_detail);
        sculptorName.setText(getSculptorName);

        String getDate = getIntent().getStringExtra(DATE);
        TextView date = findViewById(R.id.date_for_detail);
        date.setText(getDate);

        String getContentInformation = getIntent().getStringExtra(CONTENT_INFORMATION);
        TextView contentInformation = findViewById(R.id.content_information_for_details);
        contentInformation.setText(getContentInformation);

        String getStatueName = getIntent().getStringExtra(STATUE_NAME);
        TextView statueName = findViewById(R.id.statue_name_for_detail);
        statueName.setText(getStatueName);

        int getStatueImage = getIntent().getIntExtra(STATUE_IMAGE, 0);
        ImageView statueImage = findViewById(R.id.statues_view_for_detail);
        statueImage.setImageResource((getStatueImage));


    }//fin onCreate

    private void configureToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}

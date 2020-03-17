package ocr.exercice.cardviewandrecyclerexercicestep3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements RecyclerAdpterForCardViewStatues.OnCardviewListerner{
    //listerner step 9
    //on indique qu'on implemente l'interface du listerner de la classe du recycler
    //on implemente l'interface du listerner de la classe du recycler
    //du coup on doit aussi precicser qu'il y a un parametre de plus dans l'adapter
    TextView SculptorName, Date, ContentInformation ,StatueName;
    ImageView StatueImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SculptorName = findViewById(R.id.sculptor_name);
        Date = findViewById(R.id.date);
        ContentInformation = findViewById(R.id.content_information);
        StatueName = findViewById(R.id.statue_name);
        StatueImage = findViewById(R.id.statue_image);

        this.configureToolbar();

        Date actualDate = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance();


//mise en place du contenu de l'arraylist
        ArrayList<CardViewStatues> cardViewStatuesList = new ArrayList<>();
        cardViewStatuesList.add(new CardViewStatues(dateFormat.format(actualDate),"Le Centaure Nessus enlevant Déjanire"," H. 3,05 ; L. 2,50 ; P. 1,35 m. Son dernier travail accompli, Héraclès épousa Déjanire la fille du roi d'Etolie. Pour passer le fleuve grossi de la fonte des neiges, le centaure Nessus proposa son dos. Tandis qu'Héraclès traversait à la nage, Nessus enleva Déjanire. Héraclès le perça d'une flèche empoisonée. Le centaure mourant conseilla à Déjanire de tremper une tunique dans son sang afin de reconquérir un jour l'amour de son époux. Cette tunique brûla Héraclès qui gravit en hurlant les pentes de l'Etna ; purifié sur un bûcher il fut enlevé au ciel où Zeus lui donna pour épouse Hébé, la jeunesse éternelle. France, Ile-de-France, Seine, Paris, 1er arr., jardin des Tuileries", "Sculpteur: Marqueste, Laurent-Honoré (Toulouse 1848 - Paris 1920)",R.drawable.statue1));
        cardViewStatuesList.add(new CardViewStatues(dateFormat.format(actualDate),"Fontaine des Quatre Parties du Monde ","La fontaine des Quatre-Parties-du-Monde, ou fontaine de l’Observatoire, ou encore fontaine Carpeaux, est un monument parisien situé place Ernest-Denis, dans le jardin des Grands-Explorateurs Marco-Polo et Cavelier-de-la-Salle qui prolonge l'avenue de l'Observatoire en direction du jardin du Luxembourg. ","Gabriel Davioud ",R.drawable.statue2));
        cardViewStatuesList.add(new CardViewStatues(dateFormat.format(actualDate),"La Danse des fées","L'artiste britannique Robin Wight s'est spécialisé dans la réalisation de sculptures en acier inoxydables. Il s'amuse à créer des statues de fées dansantes dont la dynamique est impressionnante. Souvent accompagnées d'immenses pissenlits, l'effet de mouvement de ces statues d'acier est à couper le souffle. ","Robin Wight",R.drawable.image3));
        cardViewStatuesList.add(new CardViewStatues(dateFormat.format(actualDate),"Freedom Statue","J'ai essayé de créer une sculpture que presque n'importe qui, indépendamment de son origine , pouvait voir et percevoir immédiatement  l' idée de quelqu'un qui se battrait pour se libérer Cette sculpture traite de la lutte pour la liberté à travers le processus créatif.Bien que, pour moi , ce sentiment provenait d'une situation personnelle particulière , je savais qu'il reflétait un désir universel.  Tout le monde doit sortir d'une situation, que ce soit une lutte interne ou une circonstance défavorable , et s'en affranchir, être libre.","Zenos Frudakis",R.drawable.h));
        cardViewStatuesList.add(new CardViewStatues(dateFormat.format(actualDate),"Temple du Bouddha de Printemps","Ce Bouddha géant est la plus grande statue du monde… avec beaucoup de différence! Avec ses 128 mètres de haut, les autres statues célèbres paraissent minuscules : la Statue de la Liberté ne fait même pas la moitié de sa taille ou le Cristo Redentor qui ne dépasse même pas son pédestral. Et comme vous pouvez l’imaginer ce Bouddha n’est pas un poids plume : 1000 tonnes, pas plus, pas moins ! Pour voir ce géant de cuivre il vous suffit de vous rendre dans la province chinoise du Henan et en plus vous pourrez profiter des magnifiques sources chaudes de la région. Chine. Terminé en 2008","Inconnu",R.drawable.boudha));
//arrylist terminée


 //configuration du recyclerview
        RecyclerView mRecyclerView = findViewById(R.id.recyclerViewId);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

        //listerner step 10
        //ligne de code avant :RecyclerView.Adapter mAdapter = new RecyclerAdpterForCardViewStatues(cardViewStatuesList);
        //on indique le nouveau parametre: le listerner
        RecyclerView.Adapter mAdapter = new RecyclerAdpterForCardViewStatues(cardViewStatuesList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
 //fin de la configuration du recyclerview

//initialisation de la toolbar et configuration du bouton share
     private void configureToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.share_button) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            String body ="";
            String subject ="";
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            shareIntent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(shareIntent,"Partagez sur"));
            //return true;
        }
        return super.onOptionsItemSelected(item);
    }
//fin de l'implementation de la toolbar et de l'implementation du bouton share


    @Override
    //step 11
    //implementation de l'interface du listerner
    public void onCardviewClik(CardViewStatues item) {
        Toast.makeText(this, "Il ne faut pas oublier qu'il s'agit d'une nouvelle activity et " +
                "non d'une simple classe java sinon ca ne marche pas !!! Une matinée de perdue à cause de ça !!!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, CardViewStatuesDetails.class);//attention, c'est une nouvelle activité pas une classe java !!!
        intent.putExtra(CardViewStatuesDetails.SCULPTOR_NAME, item.getCreatorName());
        intent.putExtra(CardViewStatuesDetails.DATE, item.getActualDate());
        intent.putExtra(CardViewStatuesDetails.STATUE_NAME, item.getTitleName());
        intent.putExtra(CardViewStatuesDetails.CONTENT_INFORMATION, item.getInformationsContent());

       // intent.putExtra(CardViewStatuesDetails.STATUE_IMAGE, );


        startActivity(intent);
    }
}

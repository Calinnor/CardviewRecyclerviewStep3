package ocr.exercice.cardviewandrecyclerexercicestep3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdpterForCardViewStatues extends RecyclerView.Adapter<RecyclerAdpterForCardViewStatues.ViewHolderForCardViewStatues>{

    private ArrayList<CardViewStatues>mCardViewStatuesList;

    //listerner step 3
    //suite a la creation de l'interface mise en place de la var de classe concernée
    private OnCardviewListerner mOnRecyclerAdapterForCardViewStatuesListerner;

    static class ViewHolderForCardViewStatues extends RecyclerView.ViewHolder {
        private TextView mItemActualDate;
        private TextView mItemTitleName;
        private TextView mItemInformationsContent;
        private TextView mItemCreatorName;
        private ImageView mItemStatueImage;

        public ViewHolderForCardViewStatues(@NonNull View itemView) {
            super(itemView);
            mItemActualDate = itemView.findViewById(R.id.date);
            mItemTitleName = itemView.findViewById(R.id.statue_name);
            mItemInformationsContent = itemView.findViewById(R.id.content_information);
            mItemCreatorName = itemView.findViewById((R.id.sculptor_name));
            mItemStatueImage = itemView.findViewById(R.id.statue_image);
        }
    }


    //listerner step 4
    //constructeur
    //apres la creation de la var de classe du listerner il est necessaire de la rajouter dans le constructeur
    public RecyclerAdpterForCardViewStatues(ArrayList<CardViewStatues> cardViewStatuesList, OnCardviewListerner onRecyclerAdapterForCardViewStatuesListerner) {
         //listerner step 5 on ajoute ici en second parametre du constructeur le champ du listerner

        mCardViewStatuesList = cardViewStatuesList;

        //listerner step 6
        //on implemente le second champ du constructeur: ce listerner courant est le listerner ciblé
        this.mOnRecyclerAdapterForCardViewStatuesListerner = onRecyclerAdapterForCardViewStatuesListerner;
        //this mOnRecy***Cardview*** prend en valeur l'objet cardview courrant
        //c'est lui que l'on doit passer en param extra vers la seconde activity
        //il est ensuite necessaire de dire et
        // transmettre ce contenu dans onBind pour transmettre la vue complete
    }

    @NonNull
    @Override//cree un objet viewholder qui contient les données du layout
    public ViewHolderForCardViewStatues onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_statues,parent,false);
        return new ViewHolderForCardViewStatues(v);
    }


    @Override//l'objet viewholder est implenté des valeurs de l'objet auquel il fait reference et on y ajoute un integer pour la position dans la liste
    public void onBindViewHolder(@NonNull ViewHolderForCardViewStatues viewHolder, int position) {
       final CardViewStatues currentItem = mCardViewStatuesList.get(position);
        viewHolder.mItemActualDate.setText(currentItem.getActualDate());//getter de la date dans CardViewStatues
        viewHolder.mItemTitleName.setText(currentItem.getTitleName());
        viewHolder.mItemInformationsContent.setText(currentItem.getInformationsContent());
        viewHolder.mItemCreatorName.setText(currentItem.getCreatorName());
        viewHolder.mItemStatueImage.setImageResource(currentItem.getStatueImage());//attention une image est une image ressource !

        //listerner step 7
        //on indique un nouveau champ a prendre en compte dans bindholder: un onclcklisterner
        //il s'agit d'une vue: elle a pour valeur la vue en cours liée au click et sera la valeur settée
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            //listerner step 8
            //implementation de la methode obligatoire du onclick
            @Override
            public void onClick(View v) {
                //listerner step 8
                //on indique le listerner a utiliser lors du click puis la methode a utiliser avec
                //la methode prend en parametre un item: listerner.onItemClick(item) que l'on obtient dans le bindviewHolder
                //popur rappel il a la valeur de l'objet cardview*** avec un iteger de position
                //il s'agit donc de l'objet visible sur lequel on click

                mOnRecyclerAdapterForCardViewStatuesListerner.onCardviewClik(currentItem);
                //il faut maintenant dire au main, recycler view de main qu'il y a un changement
                //il faut aussi implementer l'interface puisqu'on la signale au main

            }
        });

    }

    @Override
    public int getItemCount() {
        return mCardViewStatuesList.size();
    }

    //Listerner recycler. Step one
    // creation d'une interface pour acceder au listerner du recyclerview(a creer de toutes pieces
    //interface publique + nom de l'interface
    public interface OnCardviewListerner {


        //listerner step 2 on ajoute la fonction de l'interface
        //void nom((nom du type objet a ecouter=classe cardview concernée)+(nom de l'objet))
        void onCardviewClik (CardViewStatues cardViewStatues);

        //il est ensuite necessaire de creer le constructeur, donc le parametre de classe sous forme de private final
    }




    }






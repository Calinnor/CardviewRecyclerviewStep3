package ocr.exercice.cardviewandrecyclerexercicestep3;

public class CardViewStatues {

    private String mActualDate;
    private String mTitleName;
    private String mInformationsContent;
    private String mCreatorName;
    private int mStatueImage;

    public CardViewStatues(String actualDate, String titleName, String informationsContent, String creatorName, int statueImage) {
       this.mActualDate = actualDate;
       this.mTitleName = titleName;
       this.mInformationsContent = informationsContent;
       this.mCreatorName = creatorName;
       this.mStatueImage = statueImage;
    }

    public String getActualDate() {
        return mActualDate;
    }

    public String getTitleName() {
        return mTitleName;
    }

    public String getInformationsContent() {
        return mInformationsContent;
    }

    public String getCreatorName() {
        return mCreatorName;
    }

    public int getStatueImage() {
        return mStatueImage;
    }
}

package ocr.exercice.cardviewandrecyclerexercicestep3;

import android.os.Parcel;
import android.os.Parcelable;

public class CardViewStatues implements Parcelable {

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

    protected CardViewStatues(Parcel in) {
        mActualDate = in.readString();
        mTitleName = in.readString();
        mInformationsContent = in.readString();
        mCreatorName = in.readString();
        mStatueImage = in.readInt();
    }

    public static final Creator<CardViewStatues> CREATOR = new Creator<CardViewStatues>() {
        @Override
        public CardViewStatues createFromParcel(Parcel in) {
            return new CardViewStatues(in);
        }

        @Override
        public CardViewStatues[] newArray(int size) {
            return new CardViewStatues[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mActualDate);
        dest.writeString(mTitleName);
        dest.writeString(mInformationsContent);
        dest.writeString(mCreatorName);
        dest.writeInt(mStatueImage);
    }
}

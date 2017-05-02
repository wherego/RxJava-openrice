package com.sihua.rxjava.model;

import android.os.Parcel;
import android.os.Parcelable;


public class OAuthModel implements Parcelable {
    public static final Creator<OAuthModel> CREATOR = new Creator<OAuthModel>() {
        @Override
        public OAuthModel createFromParcel(Parcel source) {
            return new OAuthModel(source);
        }

        @Override
        public OAuthModel[] newArray(int size) {
            return new OAuthModel[size];
        }
    };
    public int httpcode;
    public String access_token;
    public String token_type;
    public String expires_in;
    public String refresh_token;
    public String userName;
    public String registeredCountry;
    public String ssouserid;
    public String eats365_token;
    //from fb
    public String name;
    public String birthday;
    public int genderid;
    public String email;
    public String suggestedname;

    public OAuthModel() {
    }

    protected OAuthModel(Parcel in) {
        this.httpcode = in.readInt();
        this.access_token = in.readString();
        this.token_type = in.readString();
        this.expires_in = in.readString();
        this.refresh_token = in.readString();
        this.userName = in.readString();
        this.registeredCountry = in.readString();
        this.ssouserid = in.readString();
        this.eats365_token = in.readString();
        this.name = in.readString();
        this.birthday = in.readString();
        this.genderid = in.readInt();
        this.email = in.readString();
        this.suggestedname = in.readString();
    }

    @Override
    public String toString() {
        return "OAuthModel{" +
                "httpcode=" + httpcode +
                ", access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", userName='" + userName + '\'' +
                ", registeredCountry='" + registeredCountry + '\'' +
                ", ssouserid='" + ssouserid + '\'' +
                ", eats365_token='" + eats365_token + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", genderid=" + genderid +
                ", email='" + email + '\'' +
                ", suggestedname='" + suggestedname + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.httpcode);
        dest.writeString(this.access_token);
        dest.writeString(this.token_type);
        dest.writeString(this.expires_in);
        dest.writeString(this.refresh_token);
        dest.writeString(this.userName);
        dest.writeString(this.registeredCountry);
        dest.writeString(this.ssouserid);
        dest.writeString(this.eats365_token);
        dest.writeString(this.name);
        dest.writeString(this.birthday);
        dest.writeInt(this.genderid);
        dest.writeString(this.email);
        dest.writeString(this.suggestedname);
    }
}

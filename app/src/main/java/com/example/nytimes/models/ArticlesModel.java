package com.example.nytimes.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Emad Mohamed Oun on 3/24/2019.
 * Rytalo
 * e.oun@rytalo.com
 */
public class ArticlesModel {

    private String status;
    private String copyright;
    private int num_results;
    private List<ResultsDataModel> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public List<ResultsDataModel> getResults() {
        return results;
    }

    public void setResults(List<ResultsDataModel> results) {
        this.results = results;
    }

    public static class ResultsDataModel implements Parcelable {
        private String url;
        private String adx_keywords;
        private Object column;
        private String section;
        private String byline;
        private String type;
        private String title;
        @SerializedName("abstract")
        private String abstractX;
        private String published_date;
        private String source;
        private long id;
        private long asset_id;
        private int views;
        private String uri;
        private List<MediaDataModel> media;

        protected ResultsDataModel(Parcel in) {
            url = in.readString();
            adx_keywords = in.readString();
            section = in.readString();
            byline = in.readString();
            type = in.readString();
            title = in.readString();
            abstractX = in.readString();
            published_date = in.readString();
            source = in.readString();
            id = in.readLong();
            asset_id = in.readLong();
            views = in.readInt();
            uri = in.readString();
            media = in.createTypedArrayList(MediaDataModel.CREATOR);
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(url);
            dest.writeString(adx_keywords);
            dest.writeString(section);
            dest.writeString(byline);
            dest.writeString(type);
            dest.writeString(title);
            dest.writeString(abstractX);
            dest.writeString(published_date);
            dest.writeString(source);
            dest.writeLong(id);
            dest.writeLong(asset_id);
            dest.writeInt(views);
            dest.writeString(uri);
            dest.writeTypedList(media);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<ResultsDataModel> CREATOR = new Creator<ResultsDataModel>() {
            @Override
            public ResultsDataModel createFromParcel(Parcel in) {
                return new ResultsDataModel(in);
            }

            @Override
            public ResultsDataModel[] newArray(int size) {
                return new ResultsDataModel[size];
            }
        };

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAdx_keywords() {
            return adx_keywords;
        }

        public void setAdx_keywords(String adx_keywords) {
            this.adx_keywords = adx_keywords;
        }

        public Object getColumn() {
            return column;
        }

        public void setColumn(Object column) {
            this.column = column;
        }

        public String getSection() {
            return section;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public String getByline() {
            return byline;
        }

        public void setByline(String byline) {
            this.byline = byline;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAbstractX() {
            return abstractX;
        }

        public void setAbstractX(String abstractX) {
            this.abstractX = abstractX;
        }

        public String getPublished_date() {
            return published_date;
        }

        public void setPublished_date(String published_date) {
            this.published_date = published_date;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getAsset_id() {
            return asset_id;
        }

        public void setAsset_id(long asset_id) {
            this.asset_id = asset_id;
        }

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public List<MediaDataModel> getMedia() {
            return media;
        }

        public void setMedia(List<MediaDataModel> media) {
            this.media = media;
        }

        public static class MediaDataModel implements Parcelable {
            private String type;
            private String subtype;
            private String caption;
            private String copyright;
            private int approved_for_syndication;
            @SerializedName("media-metadata")
            private List<MediametadataDataModel> mediametadata;

            protected MediaDataModel(Parcel in) {
                type = in.readString();
                subtype = in.readString();
                caption = in.readString();
                copyright = in.readString();
                approved_for_syndication = in.readInt();
                mediametadata = in.createTypedArrayList(MediametadataDataModel.CREATOR);
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(type);
                dest.writeString(subtype);
                dest.writeString(caption);
                dest.writeString(copyright);
                dest.writeInt(approved_for_syndication);
                dest.writeTypedList(mediametadata);
            }

            @Override
            public int describeContents() {
                return 0;
            }

            public static final Creator<MediaDataModel> CREATOR = new Creator<MediaDataModel>() {
                @Override
                public MediaDataModel createFromParcel(Parcel in) {
                    return new MediaDataModel(in);
                }

                @Override
                public MediaDataModel[] newArray(int size) {
                    return new MediaDataModel[size];
                }
            };

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSubtype() {
                return subtype;
            }

            public void setSubtype(String subtype) {
                this.subtype = subtype;
            }

            public String getCaption() {
                return caption;
            }

            public void setCaption(String caption) {
                this.caption = caption;
            }

            public String getCopyright() {
                return copyright;
            }

            public void setCopyright(String copyright) {
                this.copyright = copyright;
            }

            public int getApproved_for_syndication() {
                return approved_for_syndication;
            }

            public void setApproved_for_syndication(int approved_for_syndication) {
                this.approved_for_syndication = approved_for_syndication;
            }

            public List<MediametadataDataModel> getMediametadata() {
                return mediametadata;
            }

            public void setMediametadata(List<MediametadataDataModel> mediametadata) {
                this.mediametadata = mediametadata;
            }

            public static class MediametadataDataModel implements Parcelable {
                private String url;
                private String format;
                private int height;
                private int width;

                protected MediametadataDataModel(Parcel in) {
                    url = in.readString();
                    format = in.readString();
                    height = in.readInt();
                    width = in.readInt();
                }

                public static final Creator<MediametadataDataModel> CREATOR = new Creator<MediametadataDataModel>() {
                    @Override
                    public MediametadataDataModel createFromParcel(Parcel in) {
                        return new MediametadataDataModel(in);
                    }

                    @Override
                    public MediametadataDataModel[] newArray(int size) {
                        return new MediametadataDataModel[size];
                    }
                };

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(url);
                    dest.writeString(format);
                    dest.writeInt(height);
                    dest.writeInt(width);
                }
            }
        }
    }
}

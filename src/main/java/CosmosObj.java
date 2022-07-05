import com.fasterxml.jackson.annotation.JsonProperty;

public class CosmosObj {
    private String date;
    private String explanation;
    private String hdUrl;
    private String mediaType;
    private String serviceVersion;
    private String title;
    private String url;

    public CosmosObj(@JsonProperty("date") String date,
                     @JsonProperty("explanation") String explanation,
                     @JsonProperty("hdurl") String hdurl,
                     @JsonProperty("media_type") String mediaType,
                     @JsonProperty("service_version") String serviceVersion,
                     @JsonProperty("title") String title,
                     @JsonProperty("url") String url) {
        this.date = date;
        this.explanation = explanation;
        this.hdUrl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getHdUrl() {
        return hdUrl;
    }

    @Override
    public String toString() {
        return "Nasa: \n" +
                "\tdate : " + date + "\n" +
                "\texplanation : " + explanation + "\n" +
                "\thdurl : " + hdUrl + "\n" +
                "\tmedia_type : " + mediaType + "\n" +
                "\tservice_version : " + serviceVersion + "\n" +
                "\ttitle : " + title + "\n" +
                "\turl : " + url + "\n";
    }
}

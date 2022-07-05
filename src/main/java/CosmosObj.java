import com.fasterxml.jackson.annotation.JsonProperty;

public class CosmosObj {
    private String date;
    private String explanation;
    private String hdurl;
    private String media_type;
    private String service_version;
    private String title;
    private String url;

    public CosmosObj(@JsonProperty("date") String date,
                     @JsonProperty("explanation") String explanation,
                     @JsonProperty("hdurl") String hdurl,
                     @JsonProperty("media_type") String media_type,
                     @JsonProperty("service_version") String service_version,
                     @JsonProperty("title") String title,
                     @JsonProperty("url") String url) {
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getHdurl() {
        return hdurl;
    }

    @Override
    public String toString() {
        return "Nasa: \n" +
                "\tdate : " + date + "\n" +
                "\texplanation : " + explanation + "\n" +
                "\thdurl : " + hdurl + "\n" +
                "\tmedia_type : " + media_type + "\n" +
                "\tservice_version : " + service_version + "\n" +
                "\ttitle : " + title + "\n" +
                "\turl : " + url + "\n";
    }
}

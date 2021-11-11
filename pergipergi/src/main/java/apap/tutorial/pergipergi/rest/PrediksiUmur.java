package apap.tutorial.pergipergi.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PrediksiUmur {

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private Integer age;

    public Integer getAge() {
        return age;
    }

    @JsonProperty("count")
    private Integer count;

}

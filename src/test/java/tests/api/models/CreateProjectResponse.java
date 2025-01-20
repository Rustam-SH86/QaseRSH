package tests.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.xml.transform.Result;

@Data
public class CreateProjectResponse {
    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName("result")
    @Expose
    private ProjectResult result;
}

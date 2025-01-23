package tests.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;


@Data
public class ProjectResult {
    @SerializedName("code")
    @Expose
    private String code;
}

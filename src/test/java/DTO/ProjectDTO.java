package DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectDTO {
    private String projectName;
    private String projectCode;
}

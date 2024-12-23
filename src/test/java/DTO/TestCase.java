package DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {
    private String Status;
    private String Type;
    private String Severity;
    private String Layer;
    private String Behavior;
    private String Priority;
    private String IsFlaky;
    private String AutomationStatus;



}
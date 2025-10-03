package access_control_app.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Permission {

    CONFIGURATION_SYSTEM("configuration_system"),

    ;
    private final String permission;

}
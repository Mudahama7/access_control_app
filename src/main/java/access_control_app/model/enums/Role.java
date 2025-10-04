package access_control_app.model.enums;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static access_control_app.model.enums.Permission.*;

@AllArgsConstructor
@Getter
public enum Role {

    COMMON_PERMISSIONS(
            Sets.newHashSet(

            )
    ),
    ADMINISTRATOR_SYSTEM(
            Sets.newHashSet(

            )
    ),
    LOCAL_ADMINISTRATOR(
            Sets.newHashSet(

            )
    ),
    FINAL_USER(
            Sets.newHashSet(

            )
    ),

    ;

    private final Set<Permission> permissions;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {

        Set<SimpleGrantedAuthority> authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        authorities.addAll(
                COMMON_PERMISSIONS.getPermissions().stream()
                        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                        .collect(Collectors.toSet()));

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }

}
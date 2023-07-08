package baemin.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberAuthDto {

    @NotNull
    private String email;

    @NotNull
    private String authKey;
}

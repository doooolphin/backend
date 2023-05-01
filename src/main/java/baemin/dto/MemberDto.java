package baemin.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    @NotNull
    private String id;

    @NotNull
    private String password;

    private String activeYn;

    @NotNull
    private String name;

    private String lastLoginDate;

    @NotNull
    private String gender;

    @NotNull
    private String phone;

    @NotNull
    private String birth;

    @NotNull
    private String nickName;

    private String orderCountAgreeYn;

    private String grade;

    private String address;

    private String lastChangePasswordDate;

    private String fileName;

    private String fileOriginalName;

    private String filePath;

    private String fileSize;

    private String fileType;

    @NotNull
    private String foreignerYn;

    @NotNull
    private String personalInfoAgreeYn;

    @NotNull
    private String thirdPartyAgreeYn;

    @NotNull
    private String marketingReceiveAgreeYn;
}

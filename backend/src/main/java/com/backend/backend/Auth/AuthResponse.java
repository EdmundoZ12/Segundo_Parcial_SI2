package com.backend.backend.Auth;

import com.backend.backend.Auth.DTO.DTO_User_Res;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    String token;
    DTO_User_Res user;

}

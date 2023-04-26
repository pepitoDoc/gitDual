package org.example.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class AltaUsuario {

    private String user;
    private String password;
}

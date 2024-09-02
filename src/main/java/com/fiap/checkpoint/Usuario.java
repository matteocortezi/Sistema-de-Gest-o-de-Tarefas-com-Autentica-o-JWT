package com.fiap.checkpoint;

import lombok.Getter;
import lombok.Setter;

public class Usuario {
    @Entity
    @Table(name="TB_API_USUARIO")
    @Getter
    @Setter
    @NoArgsConstructor
    public class Usuario implements UserDetails {
        @Id
        @GeneratedValue
        private Long id;
        @Column(name="ds_login", nullable = false, length = 50, unique = true)
        private String login;
        @Column(name="ds_senha", nullable = false)
        private String senha;
    }

}

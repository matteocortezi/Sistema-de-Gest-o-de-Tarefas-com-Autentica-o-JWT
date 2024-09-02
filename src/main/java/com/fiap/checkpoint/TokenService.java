package com.fiap.checkpoint;

public class TokenService {
    @Service
    public class TokenService {
        @Value("${api.token.secret}")
        private String senhaToken;
        public String gerarToken(Usuario usuario){
            try {
                Algorithm algoritmo = Algorithm.HMAC256(senhaToken);
                return JWT.create()
                        .withIssuer("API FIAP")
                        .withSubject(usuario.getLogin())
                        .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                        .sign(algoritmo);
            } catch (JWTCreationException e){
                throw new RuntimeException("Erro ao gerar token jwt");
            }
        }
    }
}

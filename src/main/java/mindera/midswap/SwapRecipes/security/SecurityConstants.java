package mindera.midswap.SwapRecipes.security;

public class SecurityConstants {
    public static final String SECRET = "SECRET_KEY";
    //comentar linha do tempo do token, o token nao expira
    public static final long EXPIRATION_TIME = 120_000_000; // 33 horas
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/v1/user";
}

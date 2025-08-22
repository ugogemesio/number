package mv.cripto.number;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.Base64;

@Service
public class CriptoNumberService {

    private final String url;

    public CriptoNumberService(@Value("${meu.servico.url}") String url) {
        this.url = url;
    }

    public String encodeBase64(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    public String buildUrlWithEncodedQ(String number) {
        try {
            String atendimento = "[ATENDIMENTO]=" + number;
            String encoded = encodeBase64(atendimento);
            String encodedParam = URLEncoder.encode(encoded, "UTF-8");

            return url + "&q=" + encodedParam;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao codificar número", e);
        }
    }
}

package mv.cripto.number;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class CriptoNumberController {

    private final CriptoNumberService service;

    public CriptoNumberController(CriptoNumberService service) {
        this.service = service;
    }

    @GetMapping("/{number}")
    public void redirectWithNumber(@PathVariable String number, HttpServletResponse response) throws IOException {
        String newUrl = service.buildUrlWithEncodedQ(number);
        response.sendRedirect(newUrl);
    }
}

package lmh.tribune.community.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: TODO
 * @author: lmh
 * @date: 2022年03月12日 11:47
 */
@Controller
public class indexController {
    @GetMapping("/")
    public String Index(){
        return "index";
    }

}

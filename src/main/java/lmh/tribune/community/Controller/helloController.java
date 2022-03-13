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
public class helloController {
    @GetMapping("/hello")
    public String Hello(@RequestParam(name = "name")String name, Model model){
    model.addAttribute("name",name);
        return "hello";
    }

}

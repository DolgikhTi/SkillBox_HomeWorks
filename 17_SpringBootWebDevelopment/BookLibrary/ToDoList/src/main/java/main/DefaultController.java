package main;

import main.model.Case;
import main.model.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class DefaultController {
    @Autowired
    CaseRepository caseRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Case> caseIterable = caseRepository.findAll();
        ArrayList<Case> cases = new ArrayList<>();
        for (Case deal : caseIterable){
            cases.add(deal);
        }
        model.addAttribute("", cases);
        model.addAttribute("casesCount", cases.size());
        return "index";
    }
}

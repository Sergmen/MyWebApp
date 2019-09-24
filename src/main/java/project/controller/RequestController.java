package project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import project.model.Energy;
import project.service.EnergyServiceImpl;
import java.util.List;


@Controller
public class RequestController {

    @Autowired
    private EnergyServiceImpl energyServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("firstPage");
        return modelAndView;
    }

    @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
    public @ResponseBody  List<Energy> ajaxTest() throws JsonProcessingException {
        List<Energy> list = energyServiceImpl.allEnergy();
        return list;
    }


}



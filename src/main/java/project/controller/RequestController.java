package project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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




    @RequestMapping(value = "/list", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ModelAndView allFilms() {
        List<Energy> list = energyServiceImpl.allEnergy();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("firstPage");
        modelAndView.addObject("energyList",list);
        return modelAndView;
    }

    @RequestMapping(value = "/2", method = RequestMethod.POST)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
    public @ResponseBody  List<Energy> ajaxTest() throws JsonProcessingException {
        List<Energy> list = energyServiceImpl.allEnergy();


        return list;
    }


}



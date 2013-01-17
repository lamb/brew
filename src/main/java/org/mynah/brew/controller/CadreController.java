package org.mynah.brew.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.mynah.brew.model.Cadre;
import org.mynah.brew.service.CadreService;

@Controller
@RequestMapping("/cadre")
public class CadreController {

    @Autowired
    private CadreService cadreService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Cadre> cadres = cadreService.query(new Cadre(), Cadre.class);
        model.addAttribute("cadres", cadres);
        return "cadre/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable int id, Cadre param, Model model) {
        Cadre cadre = cadreService.queryForObject(param, Cadre.class);
        model.addAttribute("cadre", cadre);
        return "cadre/show";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "cadre/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid Cadre cadre, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.getDefaultMessage());
            }
            return "redirect:";
        } else {
            return "redirect:" + cadreService.save(cadre);
        }

    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.GET)
    public String modify(@PathVariable int id, Cadre param, Model model) {
        Cadre cadre = cadreService.queryForObject(param, Cadre.class);
        model.addAttribute("cadre", cadre);
        return "cadre/modify";
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public String modify(@PathVariable int id, @Valid Cadre cadre, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.getDefaultMessage());
            }
            return "redirect:";
        } else {
            cadre.setId(id);
            Cadre where = new Cadre();
            where.setId(id);
            cadreService.update(where, cadre);
            return "redirect:";
        }

    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int id, Cadre cadre) {
        cadre.setId(id);
        cadreService.delete(cadre);
        return "redirect:../";
    }

}
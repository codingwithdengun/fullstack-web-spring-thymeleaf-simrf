package com.afterlife.javafullstackweb.controllers;

import com.afterlife.javafullstackweb.models.Returs;
import com.afterlife.javafullstackweb.usecases.RetursUsecase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/returs")
@Slf4j
public class RetursController {

    @Autowired
    private RetursUsecase retursUsecase;

    // METHOD UNTUK GET INDEX DATA RETURS
    @GetMapping(value = "/index")
    public String getIndexReturs(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        map.addAttribute("returs", retursUsecase.getAllDataReturs());
        redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Get Index Returs");
        return "pages/returs/index";
    }
    // METHOD UNTUK GET FORM (NAMBAH DATA)
    @GetMapping(value = "/form")
    public String getForm(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
            return "redirect:/returs/index";
        }
        map.addAttribute("getFormReturs", retursUsecase.getAllDataReturs());
        redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Get Form Returs");
        return "pages/returs/index";
    }
    // METHOD UNTUK SUBMIT DATA (NAMBAH DATA)
    @PostMapping(value = "/submit")
    public String saveDataReturs(@ModelAttribute(value = "returs")Returs returs, BindingResult result, RedirectAttributes
                                 redirectAttributes) {
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
            return "redirect:/returs/form";
        }
        retursUsecase.saveReturs(returs);
        redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Save Data Returs");
        return "redirect:/returs/index";
    }
    // METHOD UNTUK GET FORM (EDIT FORM)
    @GetMapping(value = "/form/{id}")
    public String getEditForm(ModelMap map, @PathVariable(value = "id") Integer id,
                              BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
            return "redirect:/returs/index";
        }
        map.addAttribute("getEditForm", retursUsecase.getDataByIdReturs(id));
        redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Get Edit Form Returs");
        return "pages/returs/index";
    }
    // METHOD UNTUK UPDATE DATA (SUBMIT EDIT DATA )
    @PostMapping(value = "/update/{id}")
    public String updateReturs(ModelMap map, @ModelAttribute(value = "returs")Returs returs, BindingResult result, RedirectAttributes
            redirectAttributes) {
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        map.addAttribute("updateReturs", returs);
        retursUsecase.saveReturs(returs);
        redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Update Data Returs");
        return "redirect:/returs/index";
    }
    // METHOD UNTUK DELETE DATA

    @GetMapping(value = "/delete/{id}")
    public String removeData(@PathVariable(value = "id") Integer id, BindingResult result, RedirectAttributes
            redirectAttributes) {
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        retursUsecase.deleteDataRetursById(id);
        redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Delete Data Returs");
        return "redirect:/returs/index";
    }
}

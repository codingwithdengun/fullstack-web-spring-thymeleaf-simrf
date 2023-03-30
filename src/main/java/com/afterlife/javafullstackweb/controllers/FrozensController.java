package com.afterlife.javafullstackweb.controllers;

import com.afterlife.javafullstackweb.models.Frozens;
import com.afterlife.javafullstackweb.usecases.FrozensUsecase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/frozens")
@Slf4j
public class FrozensController {

    @Autowired
    private FrozensUsecase frozensUsecase;

    // METHOD  UNTUK GET INDEX DATA FROZEN DARI DATABASE
    @GetMapping(value = "/index")
    public String getIndexFrozen(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes) {
        // berikan kondisi saat error
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        map.addAttribute("fronzens", frozensUsecase.getAllDataFrozens());
        redirectAttributes.addFlashAttribute("alertSuccess", "Get Data Berhasil");
        return "/pages/frozens/index";
    }

    // METHOD UNTUK GET FORM -> UNTUK MENGARAHKAN KE FORM TAMBAH DATA
    @GetMapping(value = "/form")
    public String getForm(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        map.addAttribute("getFormFrozens", frozensUsecase.getAllDataFrozens());
        redirectAttributes.addFlashAttribute("alertSuccess", "Get Form Berhasil");
        return "/pages/frozens/form";
    }
    // METHOD UNTUK TAMBAH DATA
    @PostMapping(value = "/submit")
    public String saveData(@ModelAttribute(value = "frozens")Frozens frozens, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + bindingResult);
            return "redirect:/frozens/form";
        }
        frozensUsecase.saveFrozen(frozens);
        redirectAttributes.addFlashAttribute("alertSuccess", "Save Data Berhasil");
        return "redirect:/frozens/index";
    }

    // METHOD UNTUK GET FORM EDIT -> MENGARAHKAN KE FORM EDIT
    @GetMapping(value = "/form/{id}")
    public String getFormEdit(ModelMap map, @PathVariable(value = "id") Integer id, BindingResult result,
                              RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
            return "redirect:/frozens/index";
        }
        map.addAttribute("getEditFrozens", frozensUsecase.getDataById(id));
        redirectAttributes.addFlashAttribute("alertSuccess", "Get Edit Data Berhasil");
        return "redirect:/frozens/edit";
    }

    // METHOD UNTUK EDIT DATANYA (UPDATE DATA)
    @PostMapping(value = "/update/{id}")
    public String updateData(ModelMap map, @ModelAttribute(value = "frozens") Frozens frozens, BindingResult result,
                             RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        map.addAttribute("updateFrozens", frozens);
        frozensUsecase.saveFrozen(frozens);
        redirectAttributes.addFlashAttribute("alertSuccess", "Update Data Berhasil");
        return "redirect:/frozens/index";
    }

    // METHOD UNTUK REMOVE DATANYA
    @GetMapping(value = "/delete/{id}")
    public String removeData(@PathVariable(value = "id") Integer id, BindingResult result,
                             RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        frozensUsecase.deleteDataFrozenById(id);
        redirectAttributes.addFlashAttribute("alertSuccess", "Delete Data Berhasil");
        return "redirect:/frozens/index";
    }

}

package com.afterlife.javafullstackweb.controllers;

import com.afterlife.javafullstackweb.models.Transferplants;
import com.afterlife.javafullstackweb.usecases.TransferplantUsecase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/transferplants")
@Slf4j
public class TransferplantController {

    @Autowired
    private TransferplantUsecase transferplantUsecase;

    // METHOD  UNTUK GET INDEX DATA TRANSFERPLANT DARI DATABASE
    @GetMapping(value = "/index")
    public String getIndex(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes) {
        // berikan kondisi saat error
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        map.addAttribute("transferplants", transferplantUsecase.getAllDataTransferplant());
        redirectAttributes.addFlashAttribute("alertSuccess", "Get Data Berhasil");
        return "/pages/transferplants/index";
    }

    // METHOD UNTUK GET FORM -> UNTUK MENGARAHKAN KE FORM TAMBAH DATA
    @GetMapping(value = "/form")
    public String getForm(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        map.addAttribute("getFormTransferplants", transferplantUsecase.getAllDataTransferplant());
        redirectAttributes.addFlashAttribute("alertSuccess", "Get Form Berhasil");
        return "/pages/transferplants/form";
    }
    // METHOD UNTUK TAMBAH DATA
    @PostMapping(value = "/submit")
    public String saveData(@ModelAttribute(value = "transferplant") Transferplants transferplant, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + bindingResult);
            return "redirect:/transferplants/form";
        }
        transferplantUsecase.saveTransferplant(transferplant);
        redirectAttributes.addFlashAttribute("alertSuccess", "Save Data Berhasil");
        return "redirect:/transferplants/index";
    }

    // METHOD UNTUK GET FORM EDIT -> MENGARAHKAN KE FORM EDIT
    @GetMapping(value = "/form/{id}")
    public String getFormEdit(ModelMap map, @PathVariable(value = "id") Integer id, BindingResult result,
                              RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
            return "redirect:/transferplants/index";
        }
        map.addAttribute("getEditTransferplants", transferplantUsecase.getDataTransferplantById(id));
        redirectAttributes.addFlashAttribute("alertSuccess", "Get Edit Data Berhasil");
        return "redirect:/transferplants/edit";
    }

    // METHOD UNTUK EDIT DATANYA (UPDATE DATA)
    @PostMapping(value = "/update/{id}")
    public String updateData(ModelMap map, @ModelAttribute(value = "transferplant") Transferplants transferplant, BindingResult result,
                             RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        map.addAttribute("updateTransferplants", transferplant);
        transferplantUsecase.saveTransferplant(transferplant);
        redirectAttributes.addFlashAttribute("alertSuccess", "Update Data Berhasil");
        return "redirect:/transferplants/index";
    }

    // METHOD UNTUK REMOVE DATANYA
    @GetMapping(value = "/delete/{id}")
    public String removeData(@PathVariable(value = "id") Integer id, BindingResult result,
                             RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan, Silahkan Check Kembali, berikut detailnya : " + result);
        }
        transferplantUsecase.deleteDataTransferplantById(id);
        redirectAttributes.addFlashAttribute("alertSuccess", "Delete Data Berhasil");
        return "redirect:/transferplants/index";
    }

}

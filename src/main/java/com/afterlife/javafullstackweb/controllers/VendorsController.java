package com.afterlife.javafullstackweb.controllers;

import com.afterlife.javafullstackweb.models.Vendors;
import com.afterlife.javafullstackweb.usecases.VendorsUsecase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/vendor")
@Slf4j
public class VendorsController {
    @Autowired
  private VendorsUsecase vendorsUsecase;

    // GET INDEX (GET TABLE VENDOR)
    @GetMapping(value = "/index")
    public String getListVendor(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes){
        // berikan kondisi ketika error
        if(result.hasErrors()){
            log.error("Ada Kesalahan Saat Get Data Vendor, Silahkan Check Kembali, berikut detail erronya : " + result);
        }
        map.addAttribute("vendors", vendorsUsecase.getListVendors());
        redirectAttributes.addFlashAttribute("alertSuccess", "Get Data Berhasil");
        return "pages/vendor/index";
    }

    // GET FORM
    @GetMapping(value = "/form")
    public String getForm(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan Saat Get Form , Silahkan Check Kembali, berikut detail erronya : " + result);
        }
        map.addAttribute("formVendors", vendorsUsecase.getListVendors());
        redirectAttributes.addFlashAttribute("alertSuccess", "Get Data With Form Berhasil");
        return "pages/vendor/form";
    }

    // GET FORM UNTUK EDIT DATA
    @GetMapping(value = "/form/{id}")
    public String getFormEdit(ModelMap map, @PathVariable(value = "id") Integer id, BindingResult result,
                              RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan Saat Get Form Edit, Silahkan Check Kembali, berikut detail erronya : " + result);
            return "pages/vendor/index";
        }
        map.addAttribute("getEditVendors", vendorsUsecase.findByIdVendors(id));
        redirectAttributes.addFlashAttribute("alertSuccess", "Get Edit Form Berhasil");
        return "pages/vendor/edit";
    }

    // update data
    @PostMapping(value = "/update/{id}")
    public String UpdateData(ModelMap map, @ModelAttribute(value = "vendors") Vendors vendors,
                             BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan Saat Update Data, Silahkan Check Kembali, Berikut detail erronya : " + result );
        }
        map.addAttribute("vendors", vendors);
        vendorsUsecase.saveVendors(vendors);
        redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Update Data");
        return "redirect:/vendor/index";
    }

    // SAVE DATA
    @PostMapping(value = "/submit")
    public String saveData(@ModelAttribute(value = "vendors") Vendors vendors, BindingResult result,
                           RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan saat menambahkan data , Silahkan Check Kembali , berikut detail erronya : " + result);
            return "redirect:/vendor/form";
        }
        vendorsUsecase.saveVendors(vendors);
        redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Proses Simpan Data");
        return "redirect:/vendor/index";
    }

    // delete data
    @GetMapping(value = "/delete/{id}")
    public String removeData(@PathVariable(value = "id") Integer id, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            log.error("Ada Kesalahan saat delete data, silahakn check kembali, berikut detail erronya : " + result );
        }
        vendorsUsecase.deleteVendorsById(id);
        redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Proses Delete Data");
        return "redirect:/vendor/index";
    }
}
